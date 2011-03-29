package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Command;
import de.akuz.osynce.macro.serial.payloads.PersonalData;

public class SetPersonalData extends AbstractPacket implements Command {
	
	public SetPersonalData(PersonalData personalData){
		super(Commands.PERSONAL_DATA_PACKET);
		setPayload(personalData);
	}

	@Override
	public void addReceivedByte(byte b) {
		// Ignore
		
	}

}
