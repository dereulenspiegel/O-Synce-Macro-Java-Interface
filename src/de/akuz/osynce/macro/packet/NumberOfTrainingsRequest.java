package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.interfaces.Command;

public class NumberOfTrainingsRequest extends AbstractPacket 
												implements Command {
	
	public NumberOfTrainingsRequest(){
		super(Commands.NUMBER_OF_TRAINING_REQUESTS);
		setPayload(new SimplePayload());
	}

}
