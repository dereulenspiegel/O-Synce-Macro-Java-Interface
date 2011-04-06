package de.akuz.osynce.macro.serial.packet.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsRequest;

public class NumberOfTrainingsRequestTestCase {
	
	private NumberOfTrainingsRequest packet;

	@Before
	public void setUp() throws Exception {
		packet = new NumberOfTrainingsRequest();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(3,packet.getBytes().length);
	}
	
	@Test
	public void testCommandByte(){
		Assert.assertEquals(Commands.NUMBER_OF_TRAINING_REQUESTS, 
				packet.getCommand());
	}

}
