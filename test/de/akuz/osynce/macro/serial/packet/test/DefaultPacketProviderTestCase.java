package de.akuz.osynce.macro.serial.packet.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.DefaultPacketProvider;
import de.akuz.osynce.macro.serial.packet.GenericPacket;

public class DefaultPacketProviderTestCase {
	
	private DefaultPacketProvider provider;
	
	private byte[] rawData = RawData.trainingDetail1;

	@Before
	public void setUp() throws Exception {
		provider = new DefaultPacketProvider();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetEmptyPacket(){
		Packet packet = provider.getEmptyPacket(Commands.ACKNOWLEDGE.toByte());
		Assert.assertNotNull(packet);
		Assert.assertEquals(Commands.ACKNOWLEDGE, packet.getCommand());
		Assert.assertTrue(packet instanceof GenericPacket);
	}
	
	 @Test
	 public void testParse(){
		 Packet packet = provider.parse(rawData);
		 Assert.assertNotNull(packet);
		 Assert.assertTrue(packet instanceof GenericPacket);
		 Assert.assertEquals(260, packet.getBytes().length);
		 Assert.assertArrayEquals(rawData, packet.getBytes());
		 Assert.assertEquals(Commands.TRAINING_DETAIL, packet.getCommand());
	 }

}
