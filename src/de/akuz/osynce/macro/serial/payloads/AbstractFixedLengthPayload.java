package de.akuz.osynce.macro.serial.payloads;


/**
 * Asbtract class representing the payload of a packet
 * and providing helper methods to write data to this payload.
 * The length of this payload must be known in advance.
 * @author Till Klocke
 *
 */
public abstract class AbstractFixedLengthPayload extends AbstractPayload{
	
	protected byte[] dataBytes;
	
	public AbstractFixedLengthPayload(int length){
		dataBytes = new byte[length];
	}
	
	/**
	 * Returns the byte array containing the payload
	 */
	public byte[] getBytes(){
		return dataBytes;
	}

	@Override
	public int getLength() {
		return dataBytes.length;
	}
}
