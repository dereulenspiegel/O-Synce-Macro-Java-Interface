package de.akuz.osynce.macro.serial.payload.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.serial.packet.test.RawData;
import de.akuz.osynce.macro.serial.payloads.TrainingDetailPayload;

public class TrainingDetailPayloadTestCase {
	
	/**
	 * Payload with start of training
	 */
	private TrainingDetailPayload payload;
	private byte[] rawData = RawData.trainingDetail0;
	
	/**
	 * Payload without summary
	 */
	private TrainingDetailPayload payload2;
	private byte[] rawData2 = RawData.trainingDetail1;

	@Before
	public void setUp() throws Exception {
		payload = new TrainingDetailPayload();
		for(int i=1; i<rawData.length-1;i++){
			payload.addByte(rawData[i]);
		}
		
		payload2 = new TrainingDetailPayload();
		for(int i=1; i<rawData2.length-1;i++){
			payload2.addByte(rawData2[i]);
		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPageNumber() {
		assertEquals(1,payload.getPageNumber());
		assertEquals(2,payload2.getPageNumber());
	}

	@Test
	public void testGetNumberOfData() {
		assertEquals(0x10,payload.getNumberOfData());
		assertEquals(0x15,payload2.getNumberOfData());
	}
	
	@Test
	public void testAmountOfGraphElements(){
		assertEquals(payload.getNumberOfData()-1, 
				payload.getGraphData().size());
		assertEquals(payload2.getNumberOfData(),
				payload2.getGraphData().size());
	}

}
