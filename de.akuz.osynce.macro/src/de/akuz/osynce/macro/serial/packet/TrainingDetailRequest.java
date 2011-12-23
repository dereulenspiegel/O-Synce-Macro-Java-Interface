package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Command;

public class TrainingDetailRequest extends AbstractPacket implements Command {
	
	public TrainingDetailRequest(int trainingNum){
		super(Commands.TRAINING_DETAIL_REQUEST);
		if(trainingNum>255 || trainingNum<0){
			throw new IllegalArgumentException("Number if Training must be between 0 and 255");
		}
		setPayload(new SimplePayload((byte)trainingNum));
	}

}
