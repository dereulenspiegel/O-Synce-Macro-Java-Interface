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
		
		int oldLength = payload.getLength();
		payload.writeByteToData(newByte, payload.getLength());
		Assert.assertEquals(oldLength+1, payload.getLength());
		Assert.assertEquals(newByte, 
				payload.getByteFromPosition(payload.getLength()-1));
		
		byte[] array = new byte[4];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		payload.writeBytesToData(array, 130, 4);
		
		byte[] readArray = payload.getBytesFromPosition(130, 4);
		Assert.assertEquals(array[0], readArray[3]);
		Assert.assertEquals(array[1], readArray[2]);
		Assert.assertEquals(array[2], readArray[1]);
		Assert.assertEquals(array[3], readArray[0]);
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(258, payload.getLength());
	}
	

}
