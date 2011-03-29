package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Command;

public class EraseAllRecords extends AbstractPacket implements Command {
	
	public EraseAllRecords(){
		super(Commands.ERASE_ALL_RECORDS);
		setPayload(new SimplePayload());
	}

}
