package de.akuz.osynce.macro.serial.interfaces;

import java.io.Serializable;

import de.akuz.osynce.macro.serial.packet.Commands;

/**
 * Class which represents data packets exchanged between computer and
 * PC and vice versa
 * @author Till Klocke
 *
 */
public interface Packet extends Serializable {
	
	/**
	 * Adds a received packet to the packet. The command byte should
	 * not be a value for this method.
	 * @param b
	 */
	public void addReceivedByte(byte b);
	/**
	 * Check the integrity of this packet
	 * @return true if packet is not corrupted
	 */
	public boolean check();
	/**
	 * Get all bytes to be written or read from connection
	 * @return byte array
	 */
	public byte[] getBytes();
	
	public byte getChecksum();
	
	/**
	 * Get the command of this packet
	 * @return
	 */
	public Commands getCommand();
	
	public Payload getPayload();
	
	public void setPayload(Payload payload);

}
