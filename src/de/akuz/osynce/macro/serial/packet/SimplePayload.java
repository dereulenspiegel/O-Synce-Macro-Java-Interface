package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.payloads.AbstractFixedLengthPayload;

public class SimplePayload extends AbstractFixedLengthPayload {
	
	int byteCounter = 0;
	
	public SimplePayload(){
		super(1);
		dataBytes[0] = (byte)0x00;
	}

	public SimplePayload(byte b) {
		super(1);
		dataBytes[0] = b;
	}
	
	public void setByte(byte b){
		dataBytes[0] = b;
	}

	@Override
	public void addByte(byte b) {
		dataBytes[byteCounter] = b;
		byteCounter++;
		
	}

}
