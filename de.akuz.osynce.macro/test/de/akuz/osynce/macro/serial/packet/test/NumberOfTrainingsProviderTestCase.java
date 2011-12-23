package de.akuz.osynce.macro.serial.packet.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsPacket;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsProvider;

public class NumberOfTrainingsProviderTestCase {
	
	private byte[] rawData = RawData.numberOfTrainings;
	
	private NumberOfTrainingsProvider provider;

	@Before
	public void setUp() throws Exception {
		provider = new NumberOfTrainingsProvider();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() {
		Packet packet = provider.parse(rawData);
		Assert.assertNotNull(packet);
		Assert.assertTrue(packet instanceof NumberOfTrainingsPacket);
		assertArrayEquals(rawData,packet.getBytes());
	}

	@Test
	public void testGetEmptyPacket() {
		Packet packet = 
			provider.getEmptyPacket(Commands.NUMBER_OF_TRAININGS.toByte());
		Assert.assertNotNull(packet);
		Assert.assertTrue(packet instanceof NumberOfTrainingsPacket);
	}

}
