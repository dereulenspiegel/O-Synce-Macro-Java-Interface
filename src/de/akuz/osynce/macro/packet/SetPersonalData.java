package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.interfaces.Command;
import de.akuz.osynce.macro.payloads.PersonalData;

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
