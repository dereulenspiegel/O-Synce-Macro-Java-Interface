package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;

public class PersonalDataReceivedProvider implements PacketProvider{

	@Override
	public Packet parse(byte[] array) {
		if(array[0] == Commands.PERSONAL_DATA_RECEIVED.toByte()){
			return new PersonalDataReceivedPacket();
		}
		return null;
	}

	@Override
	public Packet getEmptyPacket(byte command) {
		if(command == Commands.PERSONAL_DATA_RECEIVED.toByte()){
			return new PersonalDataReceivedPacket();
		}
		return null;
	}

}
