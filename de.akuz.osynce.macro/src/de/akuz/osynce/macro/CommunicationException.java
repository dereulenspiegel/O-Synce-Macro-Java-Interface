package de.akuz.osynce.macro;

/**
 * This exception is thrown if communication with the macro device
 * is interfered. It should contain the reason.
 * @author Till Klocke
 *
 */
public class CommunicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5606940136171740424L;

	public CommunicationException() {
		super();
	}

	public CommunicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommunicationException(String arg0) {
		super(arg0);
	}

	public CommunicationException(Throwable arg0) {
		super(arg0);
	}

}
