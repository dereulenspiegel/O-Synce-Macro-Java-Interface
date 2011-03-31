package de.akuz.osynce.macro.serial.packet.test;


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

}
