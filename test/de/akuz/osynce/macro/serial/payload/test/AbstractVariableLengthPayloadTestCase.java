package de.akuz.osynce.macro.serial.payload.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.test.RawData;
import de.akuz.osynce.macro.serial.payloads.AbstractVariableLengthPayload;

public class AbstractVariableLengthPayloadTestCase {
	
	private AbstractVariableLengthPayload payload;
	
	private byte[] rawData = RawData.trainingDetail0;

	@Before
	public void setUp() throws Exception {
		payload = new AbstractVariableLengthPayload(){
			
		};
		
		for(int i=1;i<rawData.length-1;i++){
			payload.addByte(rawData[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetByteFromPosition(){
		byte readByte = payload.getByteFromPosition(129);
		Assert.assertEquals((byte)0x88, readByte);
	}
	
	@Test
	public void testGetBytesFromPosition(){
		byte[] readBytes = payload.getBytesFromPosition(172, 2);
		Assert.assertEquals((byte)0x07, readBytes[0]);
		Assert.assertEquals((byte)0x0E, readBytes[1]);
	}
	
	@Test
	public void testInsertBytoIntoList(){
		byte newByte = (byte)0xFF;
		payload.writeByteToData(newByte, 143);
		Assert.assertEquals(newByte, payload.getByteFromPosition(143));
		
		payload.writeByteToData(newByte, 270);
		Assert.assertEquals(271, payload.getLength());
		Assert.assertEquals(newByte, payload.getByteFromPosition(270));
	}
	

}
