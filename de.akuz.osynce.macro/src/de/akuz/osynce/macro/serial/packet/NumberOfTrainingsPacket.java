package de.akuz.osynce.macro.serial.packet;

import java.util.List;

import de.akuz.osynce.macro.serial.payloads.TrainingsList;
import de.akuz.osynce.macro.serial.payloads.TrainingsList.Training;

public class NumberOfTrainingsPacket extends AbstractPacket {
	
	public NumberOfTrainingsPacket(){
		super(Commands.NUMBER_OF_TRAININGS);
		this.payload = new TrainingsList();
	}
	
	public List<Training> getListOfTrainings(){
		return ((TrainingsList)payload).getListOfTrainings();
	}

}
