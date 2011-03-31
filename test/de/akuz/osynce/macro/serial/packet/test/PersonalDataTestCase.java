package de.akuz.osynce.macro.serial.packet.test;


import org.junit.After;
import org.junit.Before;

import de.akuz.osynce.macro.serial.packet.SetPersonalData;
import de.akuz.osynce.macro.serial.payloads.PersonalData;

public class PersonalDataTestCase {
	
	private SetPersonalData packet;
	private PersonalData payload;
	
	private final boolean format24h = true;
	private final int bike1Odo = 90000;
	private final int bik2Odo = 5000;
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
	}

	@After
	public void tearDown() throws Exception {
	}

}
