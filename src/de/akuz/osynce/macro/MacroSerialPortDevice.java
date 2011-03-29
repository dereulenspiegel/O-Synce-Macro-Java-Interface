package de.akuz.osynce.macro;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import de.akuz.osynce.macro.serial.interfaces.Command;
import de.akuz.osynce.macro.serial.interfaces.DeviceException;
import de.akuz.osynce.macro.serial.interfaces.MacroDevice;
import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.PacketListener;
import de.akuz.osynce.macro.serial.packet.Acknowledge;
import de.akuz.osynce.macro.serial.packet.PacketException;
import de.akuz.osynce.macro.serial.packet.ProviderManager;

public class MacroSerialPortDevice implements MacroDevice, SerialPortEventListener{
	
	private String portName;
	
	private SerialPort port;
	
	private Packet currentPacket = null;
	
	private boolean dataReady = false;
	
	private final static String identifier = "O-Synce Macro PC-Link";
	private final static int timeout = 5000;
	
	private final static int baudrate = 9600;
	private final static int dataBits = SerialPort.DATABITS_8;
	private final static int stopBits = SerialPort.STOPBITS_1;
	private final static int parity = SerialPort.PARITY_NONE;
	
	private final static long defaultReadTimeout = 5000;
	
	private PacketListener listener;
	
	public MacroSerialPortDevice(String portName){
		this.portName = portName;
	}
	
	public Packet sendCommand(Command command, long timeout) throws PacketException{
		try {
			port.getOutputStream().write(command.getBytes());
			long start = System.nanoTime();
			boolean timeOut = false;
			while(!dataReady && !timeOut){
				if((System.nanoTime()-start)>(timeout*1000000)){
					timeOut = true;
				}
			}
			if(timeOut){
				throw new PacketException("Read operation timed out");
			}
			currentPacket = readPacketBytes();
			if(currentPacket == null){
				throw new PacketException("Couldn't read packet in time");
			}
			if(currentPacket.check()){
				Packet retVal = currentPacket;
				currentPacket = null;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// Ignore
				}
				port.getOutputStream().write(
						new Acknowledge(retVal.getCommand()).getBytes());
				return retVal;
			} else {
				throw new PacketException("Checksum doesn't match");
			}
		} catch (IOException e) {
			throw new PacketException(e);
		}
	}

	@Override
	public Packet sendCommand(Command command) throws PacketException{
		return sendCommand(command,defaultReadTimeout);
	}

	@Override
	public void sendCommand(final Command command, 
			final PacketListener listener) throws PacketException{
		this.listener = listener;
		new Thread(new Runnable(){

			@Override
			public void run(){
				try {
					port.getOutputStream().write(command.getBytes());
					long start = System.nanoTime();
					boolean timeOut = false;
					while(!dataReady && !timeOut){
						if((System.nanoTime()-start)>(timeout*1000000)){
							timeOut = true;
						}
					}
					
					if(timeOut){
						listener.exceptionOccured(
								new PacketException("Read operation timed out"));
					} else {
						readPacketBytes();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// Ignore, nothing should happen
						}
						port.getOutputStream().write(
								new Acknowledge(
										currentPacket.getCommand()).getBytes());
						currentPacket = null;
					}
				} catch (IOException e) {
					listener.exceptionOccured(new PacketException(e));
				}
			}
			
		}).start();	

	}

	@Override
	public void open() throws DeviceException{
		try {
			CommPortIdentifier portId = 
				CommPortIdentifier.getPortIdentifier(portName);
			port = (SerialPort)portId.open(identifier, timeout);
			port.setSerialPortParams(baudrate, dataBits, stopBits, parity);
			port.addEventListener(this);
		} catch (NoSuchPortException e) {
			throw new DeviceException(e);
		} catch (PortInUseException e) {
			throw new DeviceException(e);
		} catch (UnsupportedCommOperationException e) {
			throw new DeviceException(e);
		} catch (TooManyListenersException e) {
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
		byte[] buffer = new byte[256];
		byte[] array = new byte[1024];
		if(listener != null){
			listener.packetStarted(null);
		}
		int count = 0;
		int bytes = 1;
		while(port.getInputStream().available()>0 && bytes > 0){
			bytes = 0;
			if(listener != null){
				listener.receivingPayload(count, -1);
			}
			bytes = port.getInputStream().read(buffer);
			if(count + bytes > array.length){
				byte[] temp = new byte[count+bytes];
				System.arraycopy(array, 0, temp, 0, array.length);
				array = temp;
			}
			System.arraycopy(buffer, 0, array, count, bytes);
			count = count + bytes;
			
		}
		dataReady = false;
		Packet packet = ProviderManager.getInstance().parsePacket(array);
		currentPacket = packet;
		if(listener != null){
			listener.packetReceived(packet);
		}
		return packet;
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		if(event.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			dataReady = true;
		}
		
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

}
