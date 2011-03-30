package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;

public class NumberOfTrainingsProvider implements PacketProvider {

	@Override
	public Packet parse(byte[] array) {
		if(array[0] == Commands.NUMBER_OF_TRAININGS.toByte()){
			Packet packet = new NumberOfTrainingsPacket();
			for(int i=1;i<array.length;i++){
				packet.addReceivedByte(array[i]);
			}
			return packet;
		}
		return null;
	}

	@Override
	public Packet getEmptyPacket(byte command) {
		NumberOfTrainingsPacket packet = new NumberOfTrainingsPacket();
		packet.addReceivedByte(command);
		return packet;
	}

}
