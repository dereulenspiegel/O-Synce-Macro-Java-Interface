package de.akuz.osynce.macro.serial.payloads;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import de.akuz.osynce.macro.utils.Utils;

public class TrainingsList extends AbstractPayload {
	
	public static class Training {
		
		private byte[] data = new byte[TRAINING_LENGTH];
		private int byteCount = 0;
		
		public void addByte(byte b){
			data[byteCount] = b;
			byteCount++;
		}
		
		public int getId(){
			return Utils.byteToInt(data[0]);
		}
		
		public Date getTrainingStartDate() throws ParseException{
			int secs = Utils.convertBCDToInt(data[1]);
			int mins = Utils.convertBCDToInt(data[2]);
			int hours = Utils.convertBCDToInt(data[3]);
			int day = Utils.convertBCDToInt(data[4]);
			int month = Utils.byteToInt(data[5]);
			int year = Utils.convertBCDToInt(data[6]);
			return Utils.getDateFromTime(secs, mins, hours, day, month, year);
		}	
		
		public byte[] getBytes(){
			return data;
		}
	}
	
	private final static int TRAINING_LENGTH = 7;
	
	private List<Training> trainings = new LinkedList<Training>();
	
	private int byteCount = 0;
	
	private byte trainingCount = 0;

	@Override
	public byte[] getBytes() {
		byte[] array = new byte[(trainings.size()*TRAINING_LENGTH)+1];
		array[0] = trainingCount;
		int i=0;
		for(Training t : trainings){
			byte[] data = t.getBytes();
			for(int j=i*TRAINING_LENGTH;j<(i*TRAINING_LENGTH)+7;j++){
				array[j+1] = data[j-(i*TRAINING_LENGTH)];
			}
			i++;
		}
		return array;
	}

	@Override
	public int getLength() {
		return (trainings.size()*TRAINING_LENGTH)+1;
	}

	@Override
	public void addByte(byte b) {
		if(byteCount == 0){
			 trainingCount = b;
		} else {
			if(byteCount == 0 || (byteCount-1)%TRAINING_LENGTH==0){
				trainings.add(new Training());
			}
			trainings.get(trainings.size()-1).addByte(b);
		}
		byteCount++;
	}
	
	public List<Training> getListOfTrainings(){
		return Collections.unmodifiableList(trainings);
	}
	
	public int getTrainingCount(){
		return trainings.size();
	}

}
