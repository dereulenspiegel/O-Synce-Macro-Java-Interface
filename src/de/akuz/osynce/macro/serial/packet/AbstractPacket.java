package de.akuz.osynce.macro.serial.packet;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.Payload;
import de.akuz.osynce.macro.utils.Utils;

public abstract class AbstractPacket implements Packet {
	
	protected Commands command;
	protected Payload payload;
	protected byte checksum;
	
	protected int counter = 0;
	
	public AbstractPacket(Commands command){
		this.command = command;
	}

	@Override
	public byte[] getBytes() {
		byte[] allBytes = new byte[payload.getLength()+2];
		allBytes[0] = command.toByte();
		System.arraycopy(payload.getBytes(), 0, 
				allBytes, 1, payload.getLength());
		if(checksum == 0){
			checksum = calculateChecksum();
		}
		allBytes[allBytes.length-1] = checksum;
		return allBytes;
	}

	@Override
	public Commands getCommand() {
		return command;
	}
	
	/**
	 * Calculates the checksum of a packet. The checksum is simply the sum
	 * of digits of the sum of all bytes of the packet except the checksum.
	 * @return
	 */
	protected byte calculateChecksum(){
		byte[] packet = getBytes();
		int sum = 0;
		for(int i = 0;i<packet.length-1;i++){
			sum = sum + Utils.byteToInt(packet[i]);
		}
		int checksum = 0;
		while(sum > 10){
			checksum = checksum + (sum % 10);
			sum = sum / 10;
		}
		checksum = checksum + sum;
		return (byte)checksum;
	}

	@Override
	public boolean check() {
		if(checksum == calculateChecksum()){
			return true;
		}
		return false;
	}

	@Override
	public void setPayload(Payload payload) {
		this.payload = payload;
		checksum = calculateChecksum();
	}

	@Override
	public void addReceivedByte(byte b) {
		if(counter > 0){
			this.payload.addByte(this.checksum);
		}
		this.checksum = b;
		counter++;
		
	}

}
