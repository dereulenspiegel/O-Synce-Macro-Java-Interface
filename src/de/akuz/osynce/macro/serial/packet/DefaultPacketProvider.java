package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;

/**
 * This class creates GenericPackets with a GenericPayload from a
 * byte array
 * @author Till Klocke
 *
 */
public class DefaultPacketProvider implements PacketProvider {

	@Override
	public Packet parse(byte[] array) {
		GenericPacket packet = new GenericPacket();
		for(int i=0;i<array.length-1;i++){
			packet.addReceivedByte(array[i]);
		}
		return packet;
	}

	@Override
	public Packet getEmptyPacket(byte command) {
		return new GenericPacket(new byte[]{command});
	}
}
