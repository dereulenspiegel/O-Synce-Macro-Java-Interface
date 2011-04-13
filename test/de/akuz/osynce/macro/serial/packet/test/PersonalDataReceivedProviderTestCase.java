package de.akuz.osynce.macro.serial.packet.test;


import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedPacket;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedProvider;

public class PersonalDataReceivedProviderTestCase {
	
	private PersonalDataReceivedProvider provider;

	@Before
	public void setUp() throws Exception {
		provider = new PersonalDataReceivedProvider();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testParse(){
		byte[] rawData = new byte[3];
		rawData[0] = Commands.PERSONAL_DATA_RECEIVED.toByte();
		rawData[1] = (byte)0x00;
		rawData[2] = Commands.PERSONAL_DATA_RECEIVED.toByte();
		
		Packet packet = provider.parse(rawData);
		Assert.assertTrue(packet instanceof PersonalDataReceivedPacket);
		Assert.assertArrayEquals(rawData, packet.getBytes());
		Assert.assertTrue(packet.check());
	}
	
	@Test
	public void testGetEmptyPacket(){
		Packet packet = 
			provider.getEmptyPacket(Commands.PERSONAL_DATA_RECEIVED.toByte()); 
		Assert.assertTrue(packet instanceof PersonalDataReceivedPacket);
	}

}
