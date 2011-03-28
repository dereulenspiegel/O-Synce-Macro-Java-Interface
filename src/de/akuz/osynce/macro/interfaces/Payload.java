package de.akuz.osynce.macro.interfaces;

public interface Payload {
	
	public byte[] getBytes();
	public int getLength();
	public void addByte(byte b);

}
