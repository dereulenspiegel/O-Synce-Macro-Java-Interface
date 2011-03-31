package de.akuz.osynce.macro.serial.packet.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.GenericPacket;

public class GenericPacketTestCase {
	
	private byte[] rawData = RawData.numberOfTrainings;
	private GenericPacket packet;

	@Before
	public void setUp() throws Exception {
		packet = new GenericPacket(new byte[]{rawData[0]});
		for(int i=1;i<rawData.length;i++){
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
		Assert.assertEquals(rawData[30],packet.getCalculatedChecksum());
	}
}
