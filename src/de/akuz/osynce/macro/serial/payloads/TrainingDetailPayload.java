package de.akuz.osynce.macro.serial.payloads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.akuz.osynce.macro.interfaces.GraphElement;
import de.akuz.osynce.macro.utils.Utils;

public class TrainingDetailPayload extends AbstractFixedLengthPayload {
	
	public class Summary{
		
		/**
		 * Private constructor, so this class can't be
		 * instantiated by accident
		 */
		private Summary(){
			
		}
		
		/**
		 * Returns the time the user was below the lower heart rate limit
		 * @return time in seconds
		 */
		public int getLoZoneTime(){
			int secs = Utils.convertBCDToInt(getByteFromPosition(3));
			int minutes = Utils.convertBCDToInt(getByteFromPosition(4));
			int hours = Utils.convertBCDToInt(getByteFromPosition(5));
			
			return secs + (minutes*60) + (hours*3600);
		}
		
		/**
		 * Returns the time the user was above the upper heat rate limit
		 * @return time in seconds
		 */
		public int getHiZoneTime(){
			int secs = Utils.convertBCDToInt(getByteFromPosition(6));
			int minutes = Utils.convertBCDToInt(getByteFromPosition(7));
			int hours = Utils.convertBCDToInt(getByteFromPosition(8));
			
			return secs + (minutes*60) + (hours*3600);
		}
		
		public int getInZoneTime(){
			int secs = Utils.convertBCDToInt(getByteFromPosition(9));
			int minutes = Utils.convertBCDToInt(getByteFromPosition(10));
			int hours = Utils.convertBCDToInt(getByteFromPosition(11));
			
			return secs + (minutes*60) + (hours*3600);
		}
		
		public int getAverageHeartRate(){
			return Utils.byteToInt(getByteFromPosition(12));
		}
		
		public float getAverageSpeed(){
			byte[] data = getBytesFromPosition(16,2);
			data = Utils.invertByteArray(data);
			return (float)Utils.convertByteArrayToInt(data)/10.0f;
		}
		
		public int getPositiveAverageGradient(){
			return Utils.byteToInt(getByteFromPosition(18));
		}
		
		public int getNegativeAverageGradient(){
			return Utils.byteToInt(getByteFromPosition(20));
		}
		
		public int getAltitudeGain(){
			byte[] data = getBytesFromPosition(22,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}
		
		public int getAltitudeLoss(){
			byte[] data = getBytesFromPosition(24,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}
		
		public int getBurnedEnergy(){
			byte[] data = getBytesFromPosition(26,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}
		
		public float getBurnedFat(){
			return (float)Utils.byteToInt(getByteFromPosition(28))/10.f;
		}
		
		public int getAverageCadence(){
			return Utils.byteToInt(getByteFromPosition(29));
		}
		
		/**
		 * Returns the trip distance
		 * @return distance in mm
		 */
		public int getTripDistance(){
			byte[] data = getBytesFromPosition(31,4);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}
		
		/**
		 * Returns the duration of this training
		 * @return the duration in seconds
		 */
		public int getTrainingDuration(){
			int secs = Utils.convertBCDToInt(getByteFromPosition(35));
			int minutes = Utils.convertBCDToInt(getByteFromPosition(36));
			int hours = Utils.convertBCDToInt(getByteFromPosition(37));
			
			return secs + (minutes*60) + (hours*3600);
		}
		
		public int getAveragePower(){
			byte[] data = getBytesFromPosition(38,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}
		
		/**
		 * Check whether this summary and training data belongs
		 * to a complete training record or to lap of a record
		 * @return true if this belongs to a lap
		 */
		public boolean isLap(){
			return !((getByteFromPosition(42) & 0x01) == 1);
		}
	}
	
	public class GraphData implements GraphElement{
		
		private int offset;
		
		private GraphData(int offset){
			this.offset = offset;
		}

		@Override
		public float getTemperature() {
			byte[] data = getBytesFromPosition(offset,2);
			data = Utils.invertByteArray(data);
			return (float)Utils.convertByteArrayToInt(data)/100.0f;
		}

		@Override
		public int getAltitude() {
			byte[] data = getBytesFromPosition(offset+2,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}

		@Override
		public int getGradient() {
			return Utils.byteToInt(getByteFromPosition(offset+4));
		}

		@Override
		public int getCadence() {
			return Utils.byteToInt(getByteFromPosition(offset+5));
		}

		@Override
		public float getSpeed() {
			byte[] data = getBytesFromPosition(offset+6,2);
			data = Utils.invertByteArray(data);
			return (float)Utils.convertByteArrayToInt(data)/10.0f;
		}

		@Override
		public int getHeartRate() {
			return Utils.byteToInt(getByteFromPosition(offset+8));
		}

		@Override
		public int getPower() {
			byte[] data = getBytesFromPosition(offset+9,2);
			data = Utils.invertByteArray(data);
			return Utils.convertByteArrayToInt(data);
		}

		@Override
		public int getDataRate() {
			int rate = (0x03 & getByteFromPosition(offset+11));
			rate = rate * 10;
			if(rate == 0){
				rate = 5;
			}
			return rate;
		}

		@Override
		public boolean isBike2() {	
			return (0x08 & getByteFromPosition(offset+11))==1;
		}
		
	}
	
	public final static int lastPage = 0xFA0A;
	
	private Summary summary = new Summary();
	
	public TrainingDetailPayload(){
		super(258);
	}
	
	public int getPageNumber(){
		byte[] raw = Utils.invertByteArray(this.getBytesFromPosition(0, 2));
		return Utils.convertByteArrayToInt(raw);
	}
	
	public int getNumberOfData(){
		return Utils.byteToInt(this.getByteFromPosition(2));
	}
	
	public Summary getSummary(){
		if(getPageNumber()==1){
			return summary;
		}
		return null;
	}
	
	public List<GraphElement> getGraphData(){
		int numberOfElements = getNumberOfData();
		if(getSummary() != null){
			numberOfElements = numberOfElements - 1;
		}
		List<GraphElement> list = 
			new ArrayList<GraphElement>(numberOfElements);
		
		int startOffset = 4;
		if(getSummary() != null){
			startOffset = 75;
		} 
		
		for(int i=0;i<numberOfElements;i++){
			GraphData data = new GraphData(startOffset);
			list.add(data);
			startOffset = startOffset + 12;
		}
		
		return Collections.unmodifiableList(list);
	}

}
