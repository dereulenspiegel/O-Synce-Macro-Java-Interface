package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;
import de.akuz.osynce.macro.serial.payloads.GenericPayload;

/**
 * This class creates GenericPackets with a GenericPayload from a
 * byte array
 * @author Till Klocke
 *
 */
public class DefaultPacketProvider implements PacketProvider {

	@Override
	public Packet parse(byte[] array) {
		Commands command = Commands.fromByte(array[0]);
		GenericPacket packet = new GenericPacket();
		packet.command = command;
		GenericPayload payload = new GenericPayload();
		for(int i=1;i<array.length-1;i++){
			payload.addByte(array[i]);
		}
		packet.checksum = array[array.length-1];
		return packet;
	}

	@Override
	public Packet getEmptyPacket(Commands command) {
		return new GenericPacket(new byte[]{command.toByte()});
	}

}
