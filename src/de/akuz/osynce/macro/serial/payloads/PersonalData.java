package de.akuz.osynce.macro.serial.payloads;

import de.akuz.osynce.macro.utils.Utils;

public class PersonalData extends AbstractFixedLengthPayload {
	
	public PersonalData(){
		super(28);
	}
	
	public void setBike1ODO(int km){
		if(km > 99999 || km < 0){
			throw new IllegalArgumentException("ODO value must be between 0 and 99999");
		}
		writeBytesToData(Utils.convertIntToByteArray(km),0,3);
	}
	
	public void setBike2ODO(int km){
		if(km > 99999 || km < 0){
			throw new IllegalArgumentException("ODO value must be between 0 and 99999");
		}
		writeBytesToData(Utils.convertIntToByteArray(km),3,3);
	}
	
	public void setBike1WS(int mm){
		if(mm < 0 || mm > 3999){
			throw new IllegalArgumentException("WS value must be between 0 and 3999");
		}
		writeBytesToData(Utils.convertIntToByteArray(mm),6,2);
	}
	
	public void setBike2WS(int mm){
		if(mm < 0 || mm > 3999){
			throw new IllegalArgumentException("WS value must be between 0 and 3999");
		}
		writeBytesToData(Utils.convertIntToByteArray(mm),8,2);
	}
	
	public void setWeight(int lb){
		if(lb < 44 || lb > 485){
			throw new IllegalArgumentException("Weight must be between 44 and 485 lb");
		}
		writeBytesToData(Utils.convertIntToByteArray(lb),10,2);
	}
	
	public void setHomeAlti(int meters){
		if(meters < -381 || meters > 6000){
			throw new IllegalArgumentException("Home Altitude must be between -381 and 6000 meters");
		}
		writeBytesToData(Utils.convertIntToByteArray(meters),12,2);
	}
	
	public void setUpperHeartRateLimit(int limit){
		if(limit > 240){
			throw new IllegalArgumentException("Max heart rate limit too high");
		} //TODO: Check for lower heart rate limit
		writeBytesToData(Utils.convertIntToByteArray(limit),14,1);
	}
	
	public void setLowerHeartRateLimit(int limit){
		if(limit < 30){
			throw new IllegalArgumentException("Min heart rate limit too high");
		} //TODO: Check for higher heart rate limit
		writeBytesToData(Utils.convertIntToByteArray(limit),15,1);
	}
	
	public void setRTCmin(int min){
		if(min < 0 || min > 59){
			throw new IllegalArgumentException("Minute must be between 0 and 59");
		}
		writeByteToData(Utils.convertIntToBCD(min),16);
	}
	
	public void setRTChour(int hour){
		if(hour < 0 || hour > 23){
			throw new IllegalArgumentException("Hour must be between 0 and 23");
		}
		writeByteToData(Utils.convertIntToBCD(hour),17);
	}
	
	public void setRTCDay(int day){
		if(day < 1 || day > 31){
			throw new IllegalArgumentException("Day must be between 1 and 31");
		}
		writeByteToData(Utils.convertIntToBCD(day),18);
	}
	
	public void setRTCMonth(int month){
		if(month < 1 || month > 12){
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}
		writeByteToData(Utils.convertIntToBCD(month),19);
	}
	
	public void setRTCYear(int year){
		if(year < 0 || year > 99){
			throw new IllegalArgumentException("Year must be between 0 and 99");
		}
		writeByteToData(Utils.convertIntToBCD(year),20);
	}
	
	/**
	 * Sets the stopwatch mode. 0: for manual lap, 1: distance auto
	 * lap, 2: time auto lap
	 * @param mode
	 */
	public void setStopwatchMode(int mode){
		if(mode < 0 || mode > 2){
			throw new IllegalArgumentException("Mode must be between 0 and 2");
		}
		writeByteToData((byte)mode,21);
	}
	
	public void setStopwatchDistance(int distance){
		if(distance < 0 || distance > 999){
			throw new IllegalArgumentException("Distance must be between 0 and 999");
		}
		writeBytesToData(Utils.convertIntToByteArray(distance),22,2);
	}
	
	public void setStopwatchTimeMinute(int min){
		if(min < 0 || min > 59){
			throw new IllegalArgumentException("Stopwatch auto lap Minute must be between 0 and 59");
		}
		writeByteToData(Utils.convertIntToBCD(min),24);
	}
	
	public void setStopwatchTimeHour(int hour){
		if(hour < 0 || hour >9){
			throw new IllegalArgumentException("Stopwatch auto lap Hour must be between 0 and 9");
		}
		writeByteToData(Utils.convertIntToBCD(hour),25);
	}
	
	/**
	 * - User flag:	Bit 0: set if bike2 selected
	Bit 1: set if user sex is female
	Bit 2: set if speed scale is m/h
	Bit 3: set if weight scale is kg
	Bit 4: set if temperature scale is degree F
	Bit 5: set if user go to use 24 hour format
	Bit 6/7 : Data rate setting
		00b = 5sec
		01b = 10 sec
		10b = 20sec
	 * @param flags
	 */
	public void setUserFlags(int flags){
		writeByteToData((byte)flags,26);
	}

	@Override
	public void addByte(byte b) {
		// Ignore
		
	}
}
