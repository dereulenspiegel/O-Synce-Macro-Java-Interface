package de.akuz.osynce.macro.utils;

/**
 * Utility class to handle conversions
 * @author Till Klocke
 *
 */
public class Utils {
	
	/**
	 * Converts a 23-bit integer value into 4 bytes, where the last byte in
	 * the array is the least significant byte;
	 * @param in 32-bit signed integer
	 * @return byte array containing 4 bytes
	 */
	public static byte[] convertIntToByteArray(int in){
		byte[] retVal = new byte[4];
		retVal[0] = (byte)(in >>> 24);
		retVal[1] = (byte)(in >>> 16);
		retVal[2] = (byte)(in >>> 8);
		retVal[3] = (byte)(in);
		return retVal;
	}
	
	/**
	 * Converts a byte array with up to 4 bytes into an 32-bit 
	 * signed integer
	 * @param in byte array with max length of 4
	 * @return signed 32-bit integer
	 */
	public static int convertByteArrayToInt(byte[] in){
		if(in.length > 4){
			throw new IllegalArgumentException("Byte Array too long");
		}
		int value = 0x00;
		
		for(int i = 0; i < in.length; i++){
			value = value | byteToInt(in[i]);
			if(i < in.length - 1){
				value = value << 8;
			}
		}
		
		return value;
	}
	
	/**
	 * Converts a byte into a 32-bit signed integer. The byte is
	 * interpreted as unsigned.
	 * @param b unsigned byte
	 * @return signed 32-bit integer
	 */
	public static int byteToInt(byte b){
		return (int)(b & 0xFF);
	}
	
	/**
	 * Converts a positive signed integer into a byte with BCD representation
	 * @param in an integer between 0 and 99
	 * @return a byte representing the integer in BCD
	 */
	public static byte convertIntToBCD(int in){
		if(in > 99 | in < 0){
			throw new IllegalArgumentException("Integer must be between 0 and 99");
		}
		byte value = 0x00;
		if(in > 10){
			int high = in/10;
			in = in % 10;
			value = (byte)(value | high);
			value = (byte)(value << 4);
		}
		
		value = (byte)(value | in);
		
		return value;
	}
	
	/**
	 * Converts a byte with a number represented in BCD to a signed integer
	 * @param in byte with BCD number
	 * @return signed 32-bit integer
	 */
	public static int convertBCDToInt(byte in){
		int value = 0x00;
		
		value = (byteToInt((byte)(in >>> 4))*10);
		in = (byte)(in & 0x0F);
		value = value + byteToInt(in);
		
		return value;
	}
	
	public static int sumOfDigits(int i){
		int sum = 0;
		while(i>10){
			sum = sum + (i%10);
			i = i/10;
		}
		sum = sum+i;
		return sum;
	}

}
