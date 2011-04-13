package de.akuz.osynce.macro.serial.packet.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.EraseAllDonePacket;

public class EraseAllDonePacketTestCase {
	
	private EraseAllDonePacket packet;

	@Before
	public void setUp() throws Exception {
		packet = new EraseAllDonePacket();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLength(){
		Assert.assertEquals(3, packet.getBytes().length);
	}
	
	@Test
	public void testCommandByte(){
		Assert.assertEquals(Commands.ERASE_DONE, packet.getCommand());
	}

}
