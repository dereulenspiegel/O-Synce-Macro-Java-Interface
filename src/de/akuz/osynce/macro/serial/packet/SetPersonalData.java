package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Command;
import de.akuz.osynce.macro.serial.payloads.PersonalDataPayload;

public class SetPersonalData extends AbstractPacket implements Command {
	
	public SetPersonalData(PersonalDataPayload personalData){
		super(Commands.PERSONAL_DATA_PACKET);
		setPayload(personalData);
	}
}
