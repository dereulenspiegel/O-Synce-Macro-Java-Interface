package de.akuz.osynce.macro.interfaces;

import java.util.List;
import java.util.Map;

import de.akuz.osynce.macro.CommunicationException;

/**
 * This interface defines how Macro devices are accessed. This interface 
 * should be agnostic to the way the communication between device and pc
 * is handled
 * @author Till Klocke
 *
 */
public interface Macro {
	
	/**
	 * Returns a list of trainings stored on the device
	 * @return unmodifiable list of trainings
	 * @throws CommunicationException in case an exception occurs
	 */
	public List<Training> getTrainings() throws CommunicationException;
	
	/**
	 * Configure the device.
	 * @throws CommunicationException in case an exception occurs
	 */
	public void setPersonalData(PersonalData data) throws CommunicationException;
	
	/**
	 * Wipe all stored trainings from the device
	 * @return true if erase was successful
	 * @throws CommunicationException in case an exception occurs
	 */
	public boolean erase() throws CommunicationException;
	
	/**
	 * Since we can't enforce a constructor via interface, we offer here
	 * a method to give implementing classes some properties to. See
	 * the implementing classes what properties they do expect
	 * @param properties
	 */
	public void init(Map<String, String> properties);

}
