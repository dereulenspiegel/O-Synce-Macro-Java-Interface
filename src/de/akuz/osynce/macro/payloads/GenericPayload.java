package de.akuz.osynce.macro.payloads;

/**
 * This class represents a generic payload. It is essentially 
 * just a list of bytes.
 * @author Till Klocke
 *
 */
public class GenericPayload extends AbstractVariableLenghtPayload {
	
	/**
	 * Adds a byte to the payload
	 * @param b
	 */
	public void addByte(byte b){
		dataBytes.add(b);
	}

}
