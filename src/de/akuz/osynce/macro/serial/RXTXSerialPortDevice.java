package de.akuz.osynce.macro.serial;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import de.akuz.osynce.macro.serial.interfaces.Command;
import de.akuz.osynce.macro.serial.interfaces.SerialPortDevice;
import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.PacketListener;
import de.akuz.osynce.macro.serial.packet.PacketException;
import de.akuz.osynce.macro.serial.packet.ProviderManager;

public class RXTXSerialPortDevice implements SerialPortDevice, SerialPortEventListener{
	
	private String portName;
	
	private SerialPort port;
	
	private final static String identifier = "O-Synce Macro PC-Link";
	private final static int timeout = 5000;
	
	private final static int baudrate = 9600;
	private final static int dataBits = SerialPort.DATABITS_8;
	private final static int stopBits = SerialPort.STOPBITS_1;
	private final static int parity = SerialPort.PARITY_NONE;
	
	private PacketListener listener;
	
	public RXTXSerialPortDevice(String portName){
		this.portName = portName;
	}

	@Override
	public void open() throws DeviceException{
		try {
			CommPortIdentifier portId = 
				CommPortIdentifier.getPortIdentifier(portName);
			port = (SerialPort)portId.open(identifier, timeout);
			port.setSerialPortParams(baudrate, dataBits, stopBits, parity);
			//port.notifyOnDataAvailable(true);
			//port.addEventListener(this);
		} catch (NoSuchPortException e) {
			throw new DeviceException(e);
		} catch (PortInUseException e) {
			throw new DeviceException(e);
		} catch (UnsupportedCommOperationException e) {
			throw new DeviceException(e);
		}
	}

	@Override
	public void close() {
		port.close();
	}
	
	/**
	 * This method reads all available bytes from the serial port and
	 * parses them into a packet. The parsing is handled by a PacketProvider
	 * which is chosen according to the first byte received.
	 * @return
	 * @throws IOException
	 */
	private Packet readPacketBytes() throws IOException{
		if(listener != null){
			listener.packetStarted(null);
		}
		int count = 0;
		Packet packet = null;
		int read = 0;
		while((read = port.getInputStream().read())>-1){
			byte readByte = (byte)read;
			if(count == 0){
				packet = 
					ProviderManager.getInstance()
					.getEmptyPacket(readByte);
			} else {
				packet.addReceivedByte(readByte);
			}
			count++;
		}
		if(listener != null){
			listener.packetReceived(packet);
		}
		return packet;
	}
	
	/**
	 * Returns a list of names of available ports on this system
	 * @return list of port names
	 */
	public static List<String> getAvailablePortNames(){
		List<String> portNames = new LinkedList<String>();
		@SuppressWarnings("rawtypes")
		Enumeration ports = CommPortIdentifier.getPortIdentifiers();
		while(ports.hasMoreElements()){
			portNames.add(((CommPortIdentifier)ports.nextElement()).getName());
		}
		return Collections.unmodifiableList(portNames);
	}

	@Override
	public Packet sendCommand(Command command) throws PacketException {
		try {
			port.getOutputStream().write(command.getBytes());
			int availableBytes = 0;
			while(availableBytes==0){
				availableBytes = port.getInputStream().available();
			}
			return readPacketBytes();
		} catch (IOException e) {
			throw new PacketException(e);
		}
	}

	@Override
	public void sendCommand(Command command, PacketListener listener)
			throws PacketException {
		
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		/*System.out.println("SerialPortEvent received");
		if(event.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			try {
				readPacketBytes();
			} catch (IOException e) {
				if(listener!=null){
					listener.exceptionOccured(new PacketException(e));
				}
			}
		}*/
		
	}

}
