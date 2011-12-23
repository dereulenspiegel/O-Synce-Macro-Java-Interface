package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;

public class EraseAllDoneProvider implements PacketProvider{

	@Override
	public Packet parse(byte[] array) {
		if(array[0] == Commands.ERASE_DONE.toByte()){
			Packet packet = new EraseAllDonePacket();
			for(int i=0;i<array.length;i++){
				packet.addReceivedByte(array[i]);
			}
			return packet;
		}
		return null;
	}

	@Override
	public Packet getEmptyPacket(byte command) {
		EraseAllDonePacket packet = new EraseAllDonePacket();
		packet.addReceivedByte(command);
		return packet;
	}

}
