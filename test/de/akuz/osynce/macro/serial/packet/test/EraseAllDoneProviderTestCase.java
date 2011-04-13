package de.akuz.osynce.macro.serial.packet.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.EraseAllDonePacket;
import de.akuz.osynce.macro.serial.packet.EraseAllDoneProvider;

public class EraseAllDoneProviderTestCase {
	
	private EraseAllDoneProvider provider;

	@Before
	public void setUp() throws Exception {
		provider = new EraseAllDoneProvider();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testParse(){
		byte[] rawData = new byte[3];
		rawData[0] = (byte)0x8B;
		rawData[1] = (byte)0x00;
		rawData[2] = (byte)0x8B;
		
		Packet packet = provider.parse(rawData);
		Assert.assertTrue(packet instanceof EraseAllDonePacket);
		Assert.assertTrue(packet.check());
	}
	
	@Test
	public void testGetEmptyPacket(){
		Packet packet = provider.getEmptyPacket((byte)0x8B);
		Assert.assertTrue(packet instanceof EraseAllDonePacket);
	}

}
