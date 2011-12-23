package de.akuz.osynce.macro.serial.packet.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.TrainingDetailRequest;

public class TrainingDetailRequestTestCase {
	
	private TrainingDetailRequest packet;

	@Before
	public void setUp() throws Exception {
		packet = new TrainingDetailRequest(1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(3,packet.getBytes().length);
	}

}
