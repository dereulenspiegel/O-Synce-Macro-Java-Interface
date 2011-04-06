package de.akuz.osynce.macro.serial.packet.test;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.DefaultPacketProvider;
import de.akuz.osynce.macro.serial.packet.GenericPacket;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsPacket;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsProvider;
import de.akuz.osynce.macro.serial.packet.ProviderManager;
import de.akuz.osynce.macro.serial.packet.ProviderManager.PacketProvider;
import de.akuz.osynce.macro.serial.packet.TrainingDetailProvider;

public class ProviderManagerTestCase {
	
	private ProviderManager pm;

	@Before
	public void setUp() throws Exception {
		pm = ProviderManager.getInstance();
		pm.registerPacketProvider(Commands.NUMBER_OF_TRAININGS.toByte(), 
				new NumberOfTrainingsProvider());
		pm.registerPacketProvider(Commands.TRAINING_DETAIL.toByte(), 
				new TrainingDetailProvider());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetMatchingProvider(){
		PacketProvider pp = 
			pm.getProvider(Commands.NUMBER_OF_TRAININGS.toByte());
		Assert.assertNotNull(pp);
		Assert.assertTrue(pp instanceof NumberOfTrainingsProvider);
		
		pp = pm.getProvider((byte)0x00);
		Assert.assertNotNull(pp);
		Assert.assertTrue(pp instanceof DefaultPacketProvider);
	}
	
	@Test
	public void getEmptyPacket(){
		Packet p = pm.getEmptyPacket((byte)0x00);
		Assert.assertNotNull(p);
		Assert.assertTrue(p instanceof GenericPacket);
		
		p = pm.getEmptyPacket(Commands.NUMBER_OF_TRAININGS.toByte());
		Assert.assertNotNull(p);
		Assert.assertTrue(p instanceof NumberOfTrainingsPacket);
	}

}
