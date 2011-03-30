package de.akuz.osynce.macro.serial.interfaces;

import de.akuz.osynce.macro.serial.DeviceException;
import de.akuz.osynce.macro.serial.packet.PacketException;

/**
 * This is an interface to bicycle computer of the Macro series
 * from O-Synce
 * @author Till Klocke
 *
 */
public interface SerialPortDevice {
	
	/**
	 * Blocking method to send a command to the computer
	 * @param command The command to be send
	 * @return the data returned by the computer
	 */
	public Packet sendCommand(Command command) throws PacketException;
	/**
	 * Non-blocking method to send a command to the computer
	 * @param command The command to be send
	 * @param listener listener which listens to the result
	 */
	public void sendCommand(Command command, PacketListener listener) throws PacketException;
	/**
	 * Initializes the device and claims necessary resources;
	 */
	public void open() throws DeviceException;
	/**
	 * Closes the device and releases claimed resources
	 */
	public void close();

}
