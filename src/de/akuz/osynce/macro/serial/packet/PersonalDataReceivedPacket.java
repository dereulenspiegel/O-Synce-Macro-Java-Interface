package de.akuz.osynce.macro.serial.packet;

public class PersonalDataReceivedPacket extends AbstractPacket {
	
	public PersonalDataReceivedPacket(){
		super(Commands.PERSONAL_DATA_RECEIVED);
		this.payload = new SimplePayload((byte)0x00);
	}

}
