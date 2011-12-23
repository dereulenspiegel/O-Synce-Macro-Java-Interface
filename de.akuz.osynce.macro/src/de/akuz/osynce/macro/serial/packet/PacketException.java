package de.akuz.osynce.macro.serial.packet;

public class PacketException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3442577897920666718L;
	
	public PacketException(String message){
		super(message);
	}
	
	public PacketException(Throwable reason){
		super(reason);
	}

}
