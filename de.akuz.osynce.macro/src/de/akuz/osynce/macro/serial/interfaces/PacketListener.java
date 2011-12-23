package de.akuz.osynce.macro.serial.interfaces;

import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.PacketException;

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
	 * Signals the reception of the payload. 
	 * @param currentCount received number of bytes
	 * @param totalCount total number of bytes, or -1 if totalCount is unknown
	 */
	public void receivingPayload(int currentCount, int totalCount);
	
	/**
	 * This method gets calles when an exception occurs while a packet
	 * is received
	 * @param e
	 */
	public void exceptionOccured(PacketException e);

}
