package de.akuz.osynce.macro.interfaces;

import de.akuz.osynce.macro.packet.Commands;

/**
 * Class which represents data packets exchanged between computer and
 * PC and vice versa
 * @author Till Klocke
 *
 */
public interface Packet {
	
	/**
	 * Get all bytes to be written or read from connection
	 * @return byte array
	 */
	public byte[] getBytes();
	/**
	 * Get the command of this packet
	 * @return
	 */
	public Commands getCommand();
	/**
	 * Check the integrity of this packet
	 * @return true if packet is not corrupted
	 */
	public boolean check();
	
	public void setPayload(Payload payload);
	
	/**
	 * Adds a received packet to the packet. The command byte should
	 * not be a value for this method.
	 * @param b
	 */
	public void addReceivedByte(byte b);

}
