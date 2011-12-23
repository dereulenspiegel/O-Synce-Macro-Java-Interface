package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.payloads.GenericPayload;

/**
 * This class represents a generic packet without interpretation of the data.
 * The payload is a GenericPayload. The last added byte is always interpreted
 * as checksum.
 * @author Till Klocke
 *
 */
public class GenericPacket extends AbstractPacket {

	public GenericPacket() {
		super(Commands.ACKNOWLEDGE);
		setPayload(new GenericPayload());
	}
	
	/**
	 * Constructor for convenience if all received bytes are already 
	 * available.
	 * @param array array of received bytes
	 */
	public GenericPacket(byte[] array){
		this();
		for(int i=0; i<array.length;i++){
			addReceivedByte(array[i]);
		}
	}
	
	public byte getCalculatedChecksum(){
		return calculateChecksum();
	}
}
