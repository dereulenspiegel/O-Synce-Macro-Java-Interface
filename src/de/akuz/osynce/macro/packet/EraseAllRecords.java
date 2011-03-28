package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.interfaces.Command;

public class EraseAllRecords extends AbstractPacket implements Command {
	
	public EraseAllRecords(){
		super(Commands.ERASE_ALL_RECORDS);
		setPayload(new SimplePayload());
	}

}
