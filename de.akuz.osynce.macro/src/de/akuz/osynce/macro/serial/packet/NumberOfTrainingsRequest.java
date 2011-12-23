package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Command;

public class NumberOfTrainingsRequest extends AbstractPacket 
												implements Command {
	
	public NumberOfTrainingsRequest(){
		super(Commands.NUMBER_OF_TRAINING_REQUESTS);
		setPayload(new SimplePayload());
	}

}
