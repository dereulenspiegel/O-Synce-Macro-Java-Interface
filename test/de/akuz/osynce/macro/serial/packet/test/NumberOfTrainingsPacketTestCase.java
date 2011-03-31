package de.akuz.osynce.macro.serial.packet.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsPacket;

public class NumberOfTrainingsPacketTestCase {
	
	private byte[] rawData = RawData.numberOfTrainings;
	
	private NumberOfTrainingsPacket packet;
	
	@Before
	public void setUp() throws Exception {
		packet = new NumberOfTrainingsPacket();
		for(int i=0;i<rawData.length;i++){
			packet.addReceivedByte(rawData[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	
	}
	
	@Test
	public void testNumberOfReceivedTrainings(){
		Assert.assertEquals(4, packet.getListOfTrainings().size());
	}
	
	@Test
	public void testPacketLength(){
		Assert.assertEquals(31, packet.getBytes().length);
	}
	
	@Test
	public void testArraysAreTheSame(){
		Assert.assertArrayEquals(rawData, packet.getBytes());
	}
	
	@Test
	public void testDates() throws ParseException{
		SimpleDateFormat dateFormat = 
			new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		Date expectedDate = dateFormat.parse("17:53:21 29.03.2011");
		Assert.assertEquals(expectedDate, 
				packet.getListOfTrainings().get(0).getTrainingStartDate());
		expectedDate = dateFormat.parse("17:55:03 29.03.2011");
		Assert.assertEquals(expectedDate, 
				packet.getListOfTrainings().get(1).getTrainingStartDate());
		expectedDate = dateFormat.parse("18:35:59 29.03.2011");
		Assert.assertEquals(expectedDate, 
				packet.getListOfTrainings().get(2).getTrainingStartDate());
		expectedDate = dateFormat.parse("13:02:01 30.03.2011");
	}

}
