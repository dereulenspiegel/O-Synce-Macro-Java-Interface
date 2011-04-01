package de.akuz.osynce.macro.serial.payloads;

import de.akuz.osynce.macro.utils.Utils;

public class TrainingDetailPayload extends AbstractFixedLengthPayload {
	
	public TrainingDetailPayload(){
		super(258);
	}
	
	public int getPageNumber(){
		byte[] raw = Utils.invertByteArray(this.getBytesFromPosition(0, 2));
		return Utils.convertByteArrayToInt(raw);
	}
	
	public int getNumberOfData(){
		return Utils.byteToInt(this.getByteFromPosition(2));
	}

}
