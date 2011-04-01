package de.akuz.osynce.macro.serial.payload.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.test.RawData;
import de.akuz.osynce.macro.serial.payloads.TrainingDetailPayload;

public class TrainingDetailPayloadTestCase {
	
	private TrainingDetailPayload payload;
	private byte[] rawData = RawData.trainingDetail;

	@Before
	public void setUp() throws Exception {
		payload = new TrainingDetailPayload();
		for(int i=1; i<rawData.length-1;i++){
			payload.addByte(rawData[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPageNumber() {
		assertEquals(1,payload.getPageNumber());
	}

	@Test
	public void testGetNumberOfData() {
		assertEquals(8,payload.getNumberOfData());
	}

}
