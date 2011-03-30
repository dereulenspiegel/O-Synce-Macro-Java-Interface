package de.akuz.osynce.macro.serial.payload.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.payloads.GenericPayload;

public class GenericPayloadTestCase {
	
	private byte[] rawData = new byte[8];
	private GenericPayload payload;

	@Before
	public void setUp() throws Exception {
		rawData[0] = (byte)0x01;
		rawData[1] = (byte)0x02;
		rawData[2] = (byte)0x03;
		rawData[3] = (byte)0x04;
		rawData[4] = (byte)0x05;
		rawData[5] = (byte)0x06;
		rawData[6] = (byte)0x07;
		rawData[7] = (byte)0x08;
		
		payload = new GenericPayload();
		for(int i=0; i<rawData.length;i++){
			payload.addByte(rawData[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(rawData.length, payload.getBytes().length);
		Assert.assertEquals(rawData.length, payload.getLength());
	}
	
	@Test
	public void testArraysAreTheSame(){
		Assert.assertArrayEquals(rawData, payload.getBytes());
	}

}
