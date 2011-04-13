package de.akuz.osynce.macro.interfaces;

import java.util.Date;
import java.util.List;

/**
 * This interface defines how training data can be accessed
 * @author Till Klocke
 *
 */
public interface Training {
	
	/**
	 * Returns the date and time when the training started
	 * @return
	 */
	public Date getStartDate();
	
	/**
	 * Returns the time seconds the user was below his minimal heart rate limit
	 * @return time in seconds below lower heart rate limit
	 */
	public int getLoZoneTime();
	
	/**
	 * Returns the time the user was above his maximal heart rate limit
	 * @return time in seconds above upper heart rate limit
	 */
	public int getHiZoneTime();
	
	/**
	 * Returns the time the user was between his upper and lower
	 * heart rate limit
	 * @return time in seconds inside the heart rate zone
	 */
	public int getInZoneTime();
	
	/**
	 * Returns the average heart rate in beats per minute
	 * @return the average heart rate
	 */
	public int getAverageHeartRate();
	
	/**
	 * Returns the average speed during this training in km/h
	 * @return average speed in km/h
	 */
	public float getAverageSpeed();
	
	/**
	 * Returns the average ascent of this training 
	 * @return the average ascent in percent
	 */
	public int getAverageAscent();
	
	/**
	 * Returns the average decline of this training
	 * @return the average decline in percent
	 */
	public int getAverageDecline();
	
	/**
	 * Returns the gain of altitude during this training
	 * @return gain of altitude in meters
	 */
	public int getAltimeterGain();
	
	/**
	 * Returns the loss of altitude during this training
	 * @return loss of altitude in meters
	 */
	public int getAltimeterLoss();
	
	/**
	 * Returns the estimated burnt amount of energy
	 * @return burnt amount of energy in kilo calories
	 */
	public int getKCals();
	
	/**
	 * Returns the estimated amount of burned fat
	 * @return amount of burnt fat in kg;
	 */
	public float getFatBurn();
	
	/**
	 * Returns the average cadence during this training
	 * @return average cadence
	 */
	public int getAverageCadence();
	
	/**
	 * Returns the trip distance.
	 * @return trip distance in mm
	 */
	public int getTripDistance();
	
	/**
	 * Returns the ATM time as java date
	 * @return ATM time as java date
	 */
	public int getTrainingDuration();
	
	/**
	 * Check if this a complete new record a lap of a training
	 * @return true if this is only a lap
	 */
	public boolean isLap();
	
	/**
	 * Returns a list of all measure points of this training including
	 * all laps. This list
	 * can be used to print a graph or for advanced statistics.
	 * @return chronological ordered list of measure points
	 */
	public List<GraphElement> getAllGraphElements();
	
	public List<GraphElement> getGraphElements();
	
	public List<Training> getLaps();
}
