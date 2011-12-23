package de.akuz.osynce.macro.serial.packet;

public class EraseAllDonePacket extends AbstractPacket {

	public EraseAllDonePacket() {
		super(Commands.ERASE_DONE);
		this.payload = new SimplePayload((byte)0x00);
	}

}
