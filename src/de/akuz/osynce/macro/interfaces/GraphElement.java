package de.akuz.osynce.macro.interfaces;

/**
 * This interface how the data of a single graph element is accessed
 * @author Till Klocke
 *
 */
public interface GraphElement {
	
	/**
	 * Returns the temperature at this time 
	 * @return temperature in degrees celcsius
	 */
	public float getTemperature();
	
	/**
	 * Returns the altitude at this time
	 * @return altitude in meters
	 */
	public int getAltitude();
	
	/**
	 * Returns the gradient at this time
	 * @return gradient in percent
	 */
	public int getGradient();
	
	/**
	 * Returns the cadence at this time
	 * @return
	 */
	public int getCadence();
	
	/**
	 * Returns the speed at this timt
	 * @return speed in km/h
	 */
	public float getSpeed();
	
	/**
	 * Returns the heart rate at this time
	 * @return heart rate in beats per minute
	 */
	public int getHeartRate();
	
	/**
	 * Returns the measured power at this time
	 * @return power in Watt
	 */
	public int getPower();
	
	/**
	 * Returns the interval in which graph data is captured
	 * @return interval in seconds
	 */
	public int getDataRate();
	
	/**
	 * Determine whether this data was captured with bike 2.
	 * @return true if data was captured with bike 2
	 */
	public boolean isBike2();

}
