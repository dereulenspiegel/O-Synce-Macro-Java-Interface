package de.akuz.osynce.macro.serial.packet.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.GenericPacket;

public class GenericPacketTestCase {
	
	private byte[] rawData = RawData.trainingDetail0;
	private GenericPacket packet;

	@Before
	public void setUp() throws Exception {
		packet = new GenericPacket();
		for(int i=0;i<rawData.length;i++){
			packet.addReceivedByte(rawData[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(rawData.length, packet.getBytes().length);
	}
	
	@Test
	public void testCommandByte(){
		Assert.assertEquals(rawData[0], packet.getCommand().toByte());
	}
	
	@Test
	public void testArraysAreTheSame(){
		Assert.assertArrayEquals(rawData, packet.getBytes());
	}
	
	@Test
	public void testChecksum(){
		Assert.assertEquals(rawData[rawData.length-1],
				packet.getCalculatedChecksum());
		Assert.assertTrue(packet.check());
	}
}
