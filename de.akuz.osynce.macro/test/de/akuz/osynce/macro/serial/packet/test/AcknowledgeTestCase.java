package de.akuz.osynce.macro.serial.packet.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.Acknowledge;
import de.akuz.osynce.macro.serial.packet.Commands;

public class AcknowledgeTestCase {
	
	private Acknowledge ack;

	@Before
	public void setUp() throws Exception {
		ack = new Acknowledge(Commands.NUMBER_OF_TRAININGS);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testPayload(){
		Assert.assertEquals(Commands.NUMBER_OF_TRAININGS.toByte(),
				ack.getBytes()[1]);
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(3, ack.getBytes().length);
	}
	
	@Test
	public void testChecksum(){
		Assert.assertEquals((byte)144, ack.getChecksum());
		Assert.assertTrue(ack.check());
	}

}
