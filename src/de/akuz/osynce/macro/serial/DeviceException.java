package de.akuz.osynce.macro.serial;

/**
 * This exception is thrown if the serial communication with a macro device
 * is interrupted.
 * @author Till Klocke
 *
 */
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
