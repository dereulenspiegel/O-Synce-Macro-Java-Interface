package de.akuz.osynce.macro.serial.interfaces;

/**
 * An interface for payloads contained in packets
 * @author Till Klocke
 *
 */
public interface Payload {
	
	/**
	 * Returns the byte array represented by the payload
	 * @return
	 */
	public byte[] getBytes();
	
	/**
	 * The returns the number of bytes contained in this payload
	 * @return
	 */
	public int getLength();
	
	/**
	 * Adds a new byte at the end of the payload
	 * @param b
	 */
	public void addByte(byte b);

}
