package de.akuz.osynce.macro.serial.payload.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.SetPersonalData;
import de.akuz.osynce.macro.serial.payloads.PersonalData;

public class PersonalDataTestCase {
	
	private SetPersonalData packet;
	private PersonalData payload;
	
	private final boolean format24h = true;
	private final int bike1Odo = 90000;
	private final int bike2Odo = 5000;
	private final int bike1Ws = 2100;
	private final int bike2Ws = 2114;
	private final boolean bike2 = false;
	private final int dataRate = 20;
	private final boolean female = false;
	private final int homeAlti = 146;
	private final int lowerHeartRateLimit = 135;
	private final int upperHeartRateLimit = 165;
	private final int rtcDay = 29;
	private final int rtcMonth = 03;
	private final int rtcYear = 11;
	private final int rtcMin = 59;
	private final int rtcHour = 8;
	private final boolean speedScaleMpH = false;
	private final int stopwatchDistance = 5;
	private final int stopwatchMode = 0;
	private final int stopwatchHour = 1;
	private final int stopwatchMinute = 30;
	private final boolean temperatureScaleFahrenheit = false;
	private final int weight = 150;
	private final boolean weightScaleKg = true;
	

	@Before
	public void setUp() throws Exception {
		payload = new PersonalData();
		payload.set24hFormat(format24h);
		payload.setBike1ODO(bike1Odo);
		payload.setBike1WS(bike1Ws);
		payload.setBike2(bike2);
		payload.setBike2ODO(bike2Odo);
		payload.setBike2WS(bike2Ws);
		payload.setDataRate(dataRate);
		payload.setFemale(female);
		payload.setHomeAlti(homeAlti);
		payload.setUpperHeartRateLimit(upperHeartRateLimit);
		payload.setLowerHeartRateLimit(lowerHeartRateLimit);
		payload.setRTCDay(rtcDay);
		payload.setRTChour(rtcHour);
		payload.setRTCmin(rtcMin);
		payload.setRTCMonth(rtcMonth);
		payload.setRTCYear(rtcYear);
		payload.setSpeedScaleMpH(speedScaleMpH);
		payload.setStopwatchDistance(stopwatchDistance);
		payload.setStopwatchMode(stopwatchMode);
		payload.setStopwatchTimeHour(stopwatchHour);
		payload.setStopwatchTimeMinute(stopwatchMinute);
		payload.setWeight(weight);
		payload.setWeightScaleToKg(weightScaleKg);
		payload.setTemperatureScaleToFahrenheit(temperatureScaleFahrenheit);
		
		packet = new SetPersonalData(payload);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		int expectedLength = 30;
		Assert.assertEquals(expectedLength, packet.getBytes().length);
	}
	
	@Test
	public void testGetUpperHeartRateLimit(){
		Assert.assertEquals(upperHeartRateLimit, 
				payload.getUpperHeartRateLimit());
	}
	
	@Test
	public void testGetLowerHeartRateLimit(){
		Assert.assertEquals(lowerHeartRateLimit, 
				payload.getLowerHeartRateLimit());
	}
	
	@Test
	public void testSet24hFormat(){
		payload.set24hFormat(true);
		payload.set24hFormat(false);
	}
	
	@Test
	public void testSetBike1Odo(){
		boolean exceptionThrown = false;
		try{
			payload.setBike1ODO(9999999);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(this.bike1Odo, payload.getBike1Odo());
	}
	
	@Test
	public void testSetBike2Odo(){
		boolean exceptionThrown = false;
		try{
			payload.setBike2ODO(9999999);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(this.bike2Odo, payload.getBike2Odo());
	}
	
	@Test
	public void testSetBike1WS(){
		boolean exceptionThrown = false;
		try{
			payload.setBike1WS(4000);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(this.bike1Ws, payload.getBike1WS());
	}
	
	@Test
	public void testSetBike2WS(){
		boolean exceptionThrown = false;
		try{
			payload.setBike2WS(4000);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(this.bike2Ws, payload.getBike2WS());
	}
	
	@Test
	public void testSetWeight(){
		boolean exceptionThrown = false;
		try{
			payload.setWeight(486);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		exceptionThrown = false;
		try{
			payload.setWeight(20);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		Assert.assertEquals(this.weight, payload.getWeight());
	}
	
	@Test
	public void testSetHomeAlti(){
		boolean exceptionThrown = false;
		try{
			payload.setHomeAlti(6001);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		Assert.assertEquals(homeAlti, payload.getHomeAltitude());
	}
	
	@Test
	public void testSetRTCMin(){
		boolean exceptionThrown = false;
		try{
			payload.setRTCmin(60);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(rtcMin, payload.getRTCMin());
	}
	
	@Test
	public void testSetRTCHour(){
		boolean exceptionThrown = false;
		try{
			payload.setRTChour(60);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(rtcHour, payload.getRTCHour());
	}
	
	@Test
	public void testSetRTCDay(){
		boolean exceptionThrown = false;
		try{
			payload.setRTCDay(60);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(rtcDay, payload.getRTCDay());
	}
	
	@Test
	public void testSetRTCMonth(){
		boolean exceptionThrown = false;
		try{
			payload.setRTCMonth(60);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(rtcMonth, payload.getRTCMonth());
	}
	
	@Test
	public void testSetRTCYear(){
		boolean exceptionThrown = false;
		try{
			payload.setRTCYear(100);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(rtcYear, payload.getRTCYear());
	}
	
	@Test 
	public void testSetSpeedScale(){
		payload.setSpeedScaleMpH(true);
		Assert.assertTrue(payload.isSpeedScaleMph());
		payload.setSpeedScaleMpH(false);
		Assert.assertFalse(payload.isSpeedScaleMph());
	}
	
	@Test
	public void testSetStopwatchDistance(){
		boolean exceptionThrown = false;
		try{
			payload.setStopwatchDistance(1000);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(stopwatchDistance, payload.getStopwatchDistance());
	}
	
	@Test
	public void testSetStopwatchTime(){
		boolean exceptionThrown = false;
		try{
			payload.setStopwatchTimeMinute(1000);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		exceptionThrown = false;
		try{
			payload.setStopwatchTimeHour(1000);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		Assert.assertEquals(this.stopwatchHour, payload.getStopwatchTimeHour());
		Assert.assertEquals(this.stopwatchMinute, 
				payload.getStopwatchTimeMinute());
	}
	
	@Test
	public void testSetStopwatchMode(){
		boolean exceptionThrown = false;
		try{
			payload.setStopwatchMode(3);
		} catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		Assert.assertEquals(this.stopwatchMode, payload.getStopwatchMode());
	}
	
	@Test
	public void testSetTemperatureScale(){
		payload.setTemperatureScaleToFahrenheit(false);
		Assert.assertFalse(payload.isTemperatureScaleFahrenheit());
		payload.setTemperatureScaleToFahrenheit(true);
		Assert.assertTrue(payload.isTemperatureScaleFahrenheit());
	}
	
	@Test
	public void testSetWeightScale(){
		payload.setWeightScaleToKg(false);
		Assert.assertFalse(payload.isWeightScaleKg());
		payload.setWeightScaleToKg(true);
		Assert.assertTrue(payload.isWeightScaleKg());
	}
	
	@Test
	public void testSetTimeFormat(){
		payload.set24hFormat(false);
		Assert.assertFalse(payload.isTime24hFormat());
		payload.set24hFormat(true);
		Assert.assertTrue(payload.isTime24hFormat());
	}
	
	@Test
	public void testSetGender(){
		payload.setFemale(false);
		Assert.assertFalse(payload.isFemale());
		payload.setFemale(true);
		Assert.assertTrue(payload.isFemale());
	}
	
	@Test
	public void testSetBike2(){
		payload.setBike2(false);
		Assert.assertFalse(payload.isBike2());
		payload.setBike2(true);
		Assert.assertTrue(payload.isBike2());
	}

}
