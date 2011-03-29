package de.akuz.osynce.macro.serial.interfaces;

public interface Payload {
	
	public byte[] getBytes();
	public int getLength();
	public void addByte(byte b);

}
