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
		Packet packet = provider.getEmptyPacket(Commands.TRAINING_DETAIL.toByte());
		Assert.assertNotNull(packet);
		Assert.assertEquals(Commands.TRAINING_DETAIL, packet.getCommand());
		Assert.assertTrue(packet instanceof GenericPacket);
		for(int i=1;i<rawData.length;i++){
			packet.addReceivedByte(rawData[i]);
		}
		Assert.assertArrayEquals(rawData, packet.getBytes());
	}
	
	 @Test
	 public void testParse(){
		 Packet packet = provider.parse(rawData);
		 Assert.assertNotNull(packet);
		 Assert.assertTrue(packet instanceof GenericPacket);
		 Assert.assertTrue(packet.check());
		 Assert.assertEquals((byte)0x02, 
				 packet.getBytes()[1]);
		 Assert.assertEquals((byte)0xa5, 
				 packet.getBytes()[250]);
		 Assert.assertArrayEquals(rawData, packet.getBytes());
		 Assert.assertEquals(Commands.TRAINING_DETAIL, packet.getCommand());
	 }

}
