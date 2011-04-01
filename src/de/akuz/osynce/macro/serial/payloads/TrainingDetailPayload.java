package de.akuz.osynce.macro.serial.payloads;

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
	}
	
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

}
