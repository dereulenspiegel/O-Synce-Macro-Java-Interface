package de.akuz.osynce.macro.payloads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import de.akuz.osynce.macro.utils.Utils;

public class TrainingsList extends AbstractPayload {
	
	public static class Training {
		
		private final static SimpleDateFormat dateFormat =
			new SimpleDateFormat("HH:mm:ss dd.MM.yy");
		
		private byte[] data = new byte[8];
		private int byteCount = 0;
		
		public void addByte(byte b){
			data[byteCount] = b;
			byteCount++;
		}
		
		public int getId(){
			return Utils.byteToInt(data[1]);
		}
		
		public Date getTrainingStartDate() throws ParseException{
			int secs = Utils.convertBCDToInt(data[1]);
			int mins = Utils.convertBCDToInt(data[2]);
			int hours = Utils.convertBCDToInt(data[3]);
			int day = Utils.convertBCDToInt(data[4]);
			int month = Utils.convertBCDToInt(data[5]);
			int year = Utils.convertBCDToInt(data[6]);
			
			StringBuilder builder = new StringBuilder(17);
			if(hours<10){
				builder.append(0);
			}
			builder.append(hours);
			builder.append(':');
			if(mins<10){
				builder.append(0);
			}
			builder.append(mins);
			builder.append(':');
			if(secs<10){
				builder.append(0);
			}
			builder.append(secs);
			builder.append(' ');
			
			if(day<10){
				builder.append(0);
			}
			builder.append(day);
			builder.append('.');
			
			if(month<10){
				builder.append(0);
			}
			builder.append(month);
			builder.append('.');
			
			if(year<10){
				builder.append(0);
			}
			builder.append(year);
			return dateFormat.parse(builder.toString());
		}	
		
		public byte[] getBytes(){
			return data;
		}
	}
	
	private List<Training> trainings = new LinkedList<Training>();
	
	private int byteCount = 0;

	@Override
	public byte[] getBytes() {
		byte[] array = new byte[trainings.size()];
		int i=0;
		for(Training t : trainings){
			byte[] data = t.getBytes();
			for(int j=i;j<i+8;j++){
				array[j] = data[j-i];
			}
		}
		return array;
	}

	@Override
	public int getLength() {
		return byteCount;
	}

	@Override
	public void addByte(byte b) {
		if(byteCount == 0 || byteCount%8==0){
			trainings.add(new Training());
		}
		trainings.get(trainings.size()-1).addByte(b);
		byteCount++;
	}
	
	public List<Training> getListOfTrainings(){
		return Collections.unmodifiableList(trainings);
	}
	
	public int getTrainingCount(){
		return trainings.size();
	}

}
