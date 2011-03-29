package de.akuz.osynce.macro.serial.interfaces;

public class DeviceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4837444754251885707L;

	public DeviceException(String message){
		super(message);
	}
	
	public DeviceException(Throwable reason){
		super(reason);
	}

}
