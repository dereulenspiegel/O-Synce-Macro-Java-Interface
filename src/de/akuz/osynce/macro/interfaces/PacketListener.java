package de.akuz.osynce.macro.interfaces;

import de.akuz.osynce.macro.packet.Commands;
import de.akuz.osynce.macro.packet.PacketException;

/**
 * Listener which listens to data received from the computer
 * @author Till Klocke
 *
 */
public interface PacketListener {
	
	/**
	 * Singals that a data packet is completely received
	 * @param packet the received packet
	 */
	public void packetReceived(Packet packet);
	/**
	 * Signals that reception of the packet has begun 
	 * @param the command of the packet
	 */
	public void packetStarted(Commands command);
	/**
	 * Signals that the reception of the payload
	 * @param currentCount received number of bytes
	 * @param totalCount total number of bytes
	 */
	public void receivingPayload(int currentCount, int totalCount);
	
	public void exceptionOccured(PacketException e);

}
