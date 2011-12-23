package de.akuz.osynce.macro.serial.packet.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.EraseAllRecords;

public class EraseAllRecordsTestCase {
	
	private EraseAllRecords packet;

	@Before
	public void setUp() throws Exception {
		packet = new EraseAllRecords();
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
		Assert.assertEquals(Commands.ERASE_ALL_RECORDS, packet.getCommand());
	}
	
	@Test
	public void testChecksum(){
		Assert.assertTrue(packet.check());
	}

}
