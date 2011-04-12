package de.akuz.osynce.macro.serial.interfaces;

import de.akuz.osynce.macro.serial.DeviceException;
import de.akuz.osynce.macro.serial.packet.PacketException;

/**
 * This is in interface to enforce unified packet based communication with
 * serial port devices.
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
	public void open(String portname) throws DeviceException;
	/**
	 * Closes the device and releases claimed resources
	 */
	public void close();
	
	/**
	 * Adds a PacketListener to monitor all communication operations
	 * @param listener The PacketListener to add
	 */
	public void addPacketListener(PacketListener listener);
	
	/**
	 * Removes a PacketListener from this SerialPortDevice
	 * @param listener The PacketListener to be removed
	 */
	public void removePacketListener(PacketListener listener);

}
