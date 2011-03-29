package de.akuz.osynce.macro.serial.payloads;

import de.akuz.osynce.macro.serial.interfaces.Payload;

/**
 * Abstract class which represents Payloads contained in packets.
 * This class provides some methods to write into a byte array provided
 * by extending classes. Please note that, if the byte array returned by
 * getBytes() isn't the actual data structure that hold the payload, these
 * method have to be overwritten
 * @author Till Klocke
 *
 */
public abstract class AbstractPayload implements Payload {


	/**
	 * Writes a byte array into the byte array holding the payload.
	 * The least significant byte is written first. This can throw
	 * NullPointerExceptions or ArrayOutOfBoundsExceptions.
	 * @param value byte array with least significant byte at last position
	 * @param byteOffset offset from which bytes are used if the bytearray
	 * @param offset offset of the payload or starting address
	 * @param length how much data should be written
	 */
	public void writeBytesToData(byte[] value, int byteOffset, 
			int offset, int length){
		for(int i=length-1;i>0;i--){
			getBytes()[offset+(length-(i+1))] = value[i+byteOffset];
		}
	}
	
	/**
	 * Writes a byte array into the byte array holding the payload
	 * @param value the byte array to be written, with LSB last
	 * @param offset the offset or address of the position in the payload
	 * @param length how much data should be written
	 */
	public void writeBytesToData(byte[] value, 
			int offset, int length){
		writeBytesToData(value, 0, offset, length);
	}
	
	/**
	 * Writes a single byte to the specified position
	 * @param value the byte to be written
	 * @param offset the position in the payload
	 */
	public void writeByteToData(byte value, int offset){
		writeBytesToData(new byte[]{value},0,offset,1);
	}
	
	/**
	 * returns a byte array from the payload, starting at the specified
	 * position
	 * @param position which is the first byte of the returned array
	 * @param count how much data should be read
	 * @return byte array containing the specified subset
	 */
	public byte[] getBytesFromPosition(int position, int count){
		byte[] value = new byte[count];
		
		System.arraycopy(getBytes(), position, value, 0, count);

		return value;
	}
	
	/**
	 * Returns the byte at the specified position
	 * @param position position in the payload
	 * @return the byte at that position
	 */
	public byte getByteFromPosition(int position){
		return getBytesFromPosition(position,1)[0];
	}

}
