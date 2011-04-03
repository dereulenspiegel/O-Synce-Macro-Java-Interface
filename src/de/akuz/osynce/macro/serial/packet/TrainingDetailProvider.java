package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;

public class TrainingDetailProvider implements PacketProvider {

	@Override
	public Packet parse(byte[] array) {
		if(array[0] == Commands.TRAINING_DETAIL.toByte()){
			Packet packet = new TrainingDetailPacket();
			for(int i=0; i<array.length;i++){
				packet.addReceivedByte(array[i]);
			}
			return packet;
		}
		return null;
	}

	@Override
	public Packet getEmptyPacket(byte command) {
		Packet packet = new TrainingDetailPacket();
		packet.addReceivedByte(command);
		return packet;
	}

}
