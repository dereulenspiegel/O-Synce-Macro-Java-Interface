package de.akuz.osynce.macro.serial.packet.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.PacketException;

public class PacketExceptionTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPacketExceptionString() {
		String message = "Fail message";
		PacketException pe = new PacketException(message);
		Assert.assertEquals(message, pe.getMessage());
	}

	@Test
	public void testPacketExceptionThrowable() {
		IllegalArgumentException e = new IllegalArgumentException();
		PacketException pe = new PacketException(e);
		Assert.assertEquals(e, pe.getCause());
	}

}
