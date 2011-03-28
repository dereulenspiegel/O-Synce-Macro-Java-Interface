package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.interfaces.Packet;
import de.akuz.osynce.macro.packet.ProviderManager.PacketProvider;

public class NumberOfTrainingsProvider implements PacketProvider {
	
	static{
		ProviderManager.getInstance()
			.registerPacketProvider(Commands.NUMBER_OF_TRAININGS, 
					new NumberOfTrainingsProvider());
	}

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
	public Packet getEmptyPacket(Commands command) {
		return new NumberOfTrainingsPacket();
	}

}
