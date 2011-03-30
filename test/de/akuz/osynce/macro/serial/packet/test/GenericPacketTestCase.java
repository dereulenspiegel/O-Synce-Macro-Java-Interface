package de.akuz.osynce.macro.serial.packet.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.GenericPacket;

public class GenericPacketTestCase {
	
	private byte[] rawData = new byte[31];
	private GenericPacket packet;

	@Before
	public void setUp() throws Exception {
		rawData[0] = (byte)0x86;
		rawData[1] = (byte)0x04;
		rawData[2] = (byte)0x00;
		rawData[3] = (byte)0x21;
		rawData[4] = (byte)0x53;
		rawData[5] = (byte)0x17;
		rawData[6] = (byte)0x29;
		rawData[7] = (byte)0x03;
		rawData[8] = (byte)0x11;
		rawData[9] = (byte)0x01;
		rawData[10] = (byte)0x03;
		rawData[11] = (byte)0x55;
		rawData[12] = (byte)0x17;
		rawData[13] = (byte)0x29;
		rawData[14] = (byte)0x03;
		rawData[15] = (byte)0x11;
		rawData[16] = (byte)0x02;
		rawData[17] = (byte)0x59;
		rawData[18] = (byte)0x35;
		rawData[19] = (byte)0x18;
		rawData[20] = (byte)0x29;
		rawData[21] = (byte)0x03;
		rawData[22] = (byte)0x11;
		rawData[23] = (byte)0x03;
		rawData[24] = (byte)0x01;
		rawData[25] = (byte)0x02;
		rawData[26] = (byte)0x13;
		rawData[27] = (byte)0x30;
		rawData[28] = (byte)0x03;
		rawData[29] = (byte)0x11;
		rawData[30] = (byte)0x41;
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
