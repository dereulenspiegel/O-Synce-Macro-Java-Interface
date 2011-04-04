package de.akuz.osynce.macro.serial.payloads;

import de.akuz.osynce.macro.utils.Utils;

/**
 * This class represents the payload needed to be send to set the
 * personal data of the user in the cycle computer. All values should be
 * set here, since everything not set defaults to zero and is written to
 * the device.
 * @author Till Klocke
 *
 */
public class PersonalData extends AbstractFixedLengthPayload {
	
	public PersonalData(){
		super(28);
	}
	
	/**
	 * Sets the odo meter for bike 1
	 * @param km odo value in km
	 */
	public void setBike1ODO(int km){
		if(km > 99999 || km < 0){
			throw new IllegalArgumentException("ODO value must be between 0 and 99999");
		}
		writeBytesToData(Utils.convertIntToByteArray(km),0,3);
	}
	
	/**
	 * Sets the odo meter for bike 2
	 * @param km odo value in km
	 */
	public void setBike2ODO(int km){
		if(km > 99999 || km < 0){
			throw new IllegalArgumentException("ODO value must be between 0 and 99999");
		}
		writeBytesToData(Utils.convertIntToByteArray(km),3,3);
	}
	
	/**
	 * Sets the tire perimeter for bike 1
	 * @param mm tire perimeter in mm
	 */
	public void setBike1WS(int mm){
		if(mm < 0 || mm > 3999){
			throw new IllegalArgumentException("WS value must be between 0 and 3999");
		}
		writeBytesToData(Utils.convertIntToByteArray(mm),6,2);
	}
	
	/**
	 * Sets the tire perimeter for bike 2
	 * @param mm tire perimeter in mm
	 */
	public void setBike2WS(int mm){
		if(mm < 0 || mm > 3999){
			throw new IllegalArgumentException("WS value must be between 0 and 3999");
		}
		writeBytesToData(Utils.convertIntToByteArray(mm),8,2);
	}
	
	/**
	 * Sets the weight of the user
	 * @param lb weight in pound
	 */
	public void setWeight(int lb){
		if(lb < 44 || lb > 485){
			throw new IllegalArgumentException("Weight must be between 44 and 485 lb");
		}
		writeBytesToData(Utils.convertIntToByteArray(lb),10,2);
	}
	
	/**
	 * Sets the home altitude
	 * @param meters altitude in meters
	 */
	public void setHomeAlti(int meters){
		if(meters < -381 || meters > 6000){
			throw new IllegalArgumentException("Home Altitude must be between -381 and 6000 meters");
		}
		writeBytesToData(Utils.convertIntToByteArray(meters),12,2);
	}
	
	/**
	 * Sets the upper heart rate limit. This limit must be below 240 and
	 * above the lower heart rate limit. This limit should be set first.
	 * @param limit heart rate in beats per minute
	 */
	public void setUpperHeartRateLimit(int limit){
		if(limit > 240 || limit < getLowerHeartRateLimit()){
			throw new IllegalArgumentException("Max heart rate limit too high or lower von lower limit");
		}
		writeBytesToData(Utils.convertIntToByteArray(limit),14,1);
	}
	
	/**
	 * Sets the lower heart rate limit. This limit must be above 30 and
	 * below the upper heart rate limit. The upper heart rate limit should
	 * be set first.
	 * @param limit heart rate in beats per minute
	 */
	public void setLowerHeartRateLimit(int limit){
		if(limit < 30 || limit > getUpperHeartRateLimit()){
			throw new IllegalArgumentException("Min heart rate limit too low or higher than upper limit");
		}
		writeBytesToData(Utils.convertIntToByteArray(limit),15,1);
	}
	
	/**
	 * Sets the minutes of the device clock
	 * @param min minutes
	 */
	public void setRTCmin(int min){
		if(min < 0 || min > 59){
			throw new IllegalArgumentException("Minute must be between 0 and 59");
		}
		writeByteToData(Utils.convertIntToBCD(min),16);
	}
	
	/**
	 * Sets the hours of the device clock
	 * @param hour hours
	 */
	public void setRTChour(int hour){
		if(hour < 0 || hour > 23){
			throw new IllegalArgumentException("Hour must be between 0 and 23");
		}
		writeByteToData(Utils.convertIntToBCD(hour),17);
	}
	
	/**
	 * Sets the day of month of the device clock
	 * @param day day of month
	 */
	public void setRTCDay(int day){
		if(day < 1 || day > 31){
			throw new IllegalArgumentException("Day must be between 1 and 31");
		}
		writeByteToData(Utils.convertIntToBCD(day),18);
	}
	
	/**
	 * Sets the month of the device clock
	 * @param month month of year
	 */
	public void setRTCMonth(int month){
		if(month < 1 || month > 12){
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}
		writeByteToData(Utils.convertIntToBCD(month),19);
	}
	
	/**
	 * Sets the year of the device clock. Note that you only the last two digits
	 * of the year. For example for 2011 you set 11.
	 * @param year last two digits of year
	 */
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
	
	/**
	 * Sets the distance for for the stopwatch auto distance lap mode
	 * @param distance distance in km
	 */
	public void setStopwatchDistance(int distance){
		if(distance < 0 || distance > 999){
			throw new IllegalArgumentException("Distance must be between 0 and 999");
		}
		writeBytesToData(Utils.convertIntToByteArray(distance),22,2);
	}
	
	/**
	 * Sets the minutes for the stopwatch auto time lap mode
	 * @param min minutes
	 */
	public void setStopwatchTimeMinute(int min){
		if(min < 0 || min > 59){
			throw new IllegalArgumentException("Stopwatch auto lap Minute must be between 0 and 59");
		}
		writeByteToData(Utils.convertIntToBCD(min),24);
	}
	
	/**
	 * Sets the hours for the stopwatch auto time lap mode. The maximum is 9.
	 * @param hour hours
	 */
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
	
	private void addFlag(int flag){
		int flags = this.getByteFromPosition(26);
		flags = flags | flag;
		this.writeByteToData((byte)flags, 26);
	}
	
	/**
	 * Sets a flag in user flags by using exclusive or.
	 * @param flag
	 */
	private void removeFlag(int flag){
		int flags = this.getByteFromPosition(26);
		flags = flags ^ flag;
		this.writeByteToData((byte)flags, 26);
	}
	
	/**
	 * Set to true if user is female and to false if user
	 * is male
	 * @param gender
	 */
	public void setFemale(boolean gender){
		if(gender){
			addFlag(0x02);
		} else {
			removeFlag(0x02);
		}
	}
	
	/**
	 * Set to true for bike 2.
	 * @param bike2
	 */
	public void setBike2(boolean bike2){
		if(bike2){
			addFlag(0x01);
		} else {
			removeFlag(0x01);
		}
	}
	
	/**
	 * Set to true for speed scale in miles per hour, to false
	 * for speed scale in kilometers per hour
	 * @param mph
	 */
	public void setSpeedScaleMpH(boolean mph){
		if(mph){
			addFlag(0x04);
		} else {
			removeFlag(0x04);
		}
	}
	
	/**
	 * Set to true for weight scale in kilogramm and to false 
	 * for weight scale in pounds.
	 * @param kg
	 */
	public void setWeightScaleToKg(boolean kg){
		if(kg){
			addFlag(0x08);
		} else {
			removeFlag(0x08);
		}
	}
	
	/**
	 * Set to true for Fahrenheit, to false for Celsius scale
	 * @param fahrenheit
	 */
	public void setTemperatureScaleToFahrenheit(boolean fahrenheit){
		if(fahrenheit){
			addFlag(0x10);
		} else {
			removeFlag(0x10);
		}
	}
	
	/**
	 * Set to true if user wants to use 24h format, otherwise to false
	 * @param h
	 */
	public void set24hFormat(boolean h){
		if(h){
			addFlag(0x20);
		} else {
			removeFlag(0x20);
		}
	}
	
	/**
	 * Set data rate to 5, 10 or 20 seconds. This method simply divides
	 * the given integer by 10 and shifts all bits by six to get the
	 * necessary flag. No Exception will be thrown if given rate is not 5,10
	 * or 20, but strange things could happen.
	 * @param rate
	 */
	public void setDataRate(int rate){
		int flag = rate/10;
		flag = flag << 6;
		addFlag(flag);
	}
	
	public int getLowerHeartRateLimit(){
		return Utils.byteToInt(getByteFromPosition(15));
	}
	
	public int getUpperHeartRateLimit(){
		return Utils.byteToInt(getByteFromPosition(14));
	}
	
	public int getBike1Odo(){
		byte[] data = getBytesFromPosition(0,3);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getBike2Odo(){
		byte[] data = getBytesFromPosition(3,3);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getBike1WS(){
		byte[] data = getBytesFromPosition(6,2);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getBike2WS(){
		byte[] data = getBytesFromPosition(8,2);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getWeight(){
		byte[] data = getBytesFromPosition(10,2);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getHomeAltitude(){
		byte[] data = getBytesFromPosition(12,2);
		data = Utils.invertByteArray(data);
		return Utils.convertByteArrayToInt(data);
	}
	
	public int getRTCMin(){
		return Utils.convertBCDToInt(getByteFromPosition(16));
	}
}
