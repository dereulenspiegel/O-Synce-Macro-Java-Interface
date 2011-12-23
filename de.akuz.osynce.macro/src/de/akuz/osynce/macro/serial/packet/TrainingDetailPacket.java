package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.payloads.TrainingDetailPayload;

public class TrainingDetailPacket extends AbstractPacket {
	
	public final static int lastPage = 0xFA0A;
	
	public TrainingDetailPacket(){
		super(Commands.TRAINING_DETAIL);
		this.payload = new TrainingDetailPayload();
	}

}
