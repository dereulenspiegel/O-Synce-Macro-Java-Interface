package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.payloads.GenericPayload;

/**
 * This class represents a generic packet without interpretation of the data.
 * The payload is a GenericPayload. The last added byte is always interpreted
 * as checksum.
 * @author Till Klocke
 *
 */
public class GenericPacket extends AbstractPacket {
	
	int counter = 0;

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
	
	/**
	 * Adds a byte to this packet. If it is the first byte it is interpreted
	 * as the command byte. Every following byte is first interpreted as
	 * checksum and will be moved to the payload if another byte is added
	 * @param b byte to be added
	 */
	public void addReceivedByte(byte b){
		if(counter == 0){
			this.command = Commands.fromByte(b);
		} else if(counter > 1){
			((GenericPayload)this.payload).addByte(this.checksum);
			this.checksum = b;
		} else {
			this.checksum = b;
		}
		counter++;
	}

}
