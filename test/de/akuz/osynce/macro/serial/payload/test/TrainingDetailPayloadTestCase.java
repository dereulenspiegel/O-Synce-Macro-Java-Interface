package de.akuz.osynce.macro.serial.payload.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

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
	
	@Test
	public void testGetSummary(){
		Assert.assertNotNull(payload.getSummary());
		Assert.assertNull(payload2.getSummary());
	}
	
	@Test
	public void testGetAltitudeGain(){
		Assert.assertEquals(261, payload.getSummary().getAltitudeGain());
	}
	
	@Test
	public void testGetAltitudeLoss(){
		Assert.assertEquals(219, payload.getSummary().getAltitudeLoss());
	}
	
	@Test
	public void testGetBurnedEnergy(){
		Assert.assertEquals(0, payload.getSummary().getBurnedEnergy());
	}
	
	@Test
	public void testGetBurnedFat(){
		Assert.assertEquals(0.0f, payload.getSummary().getBurnedFat());
	}
	
	@Test
	public void testGetAverageCadence(){
		Assert.assertEquals(0, payload.getSummary().getAverageCadence());
	}
	
	@Test
	public void testGetTripDistance(){
		Assert.assertEquals(35999306, payload.getSummary().getTripDistance());
	}
	
	@Test
	public void testGetTrainingDuration(){
		Assert.assertEquals(23460, payload.getSummary().getTrainingDuration());
	}
	
	@Test
	public void testGetAveragePower(){
		Assert.assertEquals(0, payload.getSummary().getAveragePower());
	}
	
	@Test
	public void testIsLap(){
		Assert.assertFalse(payload.getSummary().isLap());
	}
	
	@Test
	public void testGetAverageSpeed(){
		Assert.assertEquals(5.5f, payload.getSummary().getAverageSpeed());
	}
	
	@Test
	public void testGetAverageHeartRate(){
		Assert.assertEquals(0, payload.getSummary().getAverageHeartRate());
	}
	
	@Test
	public void testGetLoZoneTime(){
		Assert.assertEquals(0, payload.getSummary().getLoZoneTime());
	}
	
	@Test
	public void testGetHiZoneTime(){
		Assert.assertEquals(0, payload.getSummary().getHiZoneTime());
	}
	
	@Test
	public void testInZoneTime(){
		Assert.assertEquals(0, payload.getSummary().getInZoneTime());
	}
	
	@Test
	public void testGetPositiveAverageGradient(){
		Assert.assertEquals(3, 
				payload.getSummary().getPositiveAverageGradient());
	}
	
	@Test
	public void testGetNegativeAverageGradient(){
		Assert.assertEquals(3, 
				payload.getSummary().getNegativeAverageGradient());
	}
	
	@Test
	public void testGetSectionStartTime() throws ParseException{
		Date time = payload.getSummary().getSectionStartTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		Assert.assertEquals(cal.get(Calendar.SECOND), 21);
		Assert.assertEquals(cal.get(Calendar.MINUTE), 29);
		Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 12);
		Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 2);
		Assert.assertEquals(cal.get(Calendar.MONTH)+1, 4);
		Assert.assertEquals(cal.get(Calendar.YEAR)-2000, 11);
	}
	
	@Test
	public void testGetAltitude(){
		Assert.assertEquals(269, payload.getGraphData().get(0).getAltitude());
	}
	
	@Test
	public void testGetCadence(){
		Assert.assertEquals(0, payload.getGraphData().get(0).getCadence());
	}
	
	@Test
	public void testGetDataRate(){
		Assert.assertEquals(5, payload.getGraphData().get(0).getDataRate());
	}
	
	@Test
	public void testGetHeartRate(){
		Assert.assertEquals(0, payload.getGraphData().get(0).getHeartRate());
	}
	
	@Test
	public void testGetPower(){
		Assert.assertEquals(0, payload.getGraphData().get(0).getPower());
	}
	
	@Test
	public void testGetTemperature(){
		Assert.assertEquals(18.1f, payload.getGraphData().get(0).getTemperature());
	}
	
	@Test
	public void testGetSpeed(){
		Assert.assertEquals(0.0f, payload.getGraphData().get(0).getSpeed());
	}
	
	@Test
	public void testGetGradient(){
		Assert.assertEquals(0, payload.getGraphData().get(0).getGradient());
	}
	
	@Test
	public void testIsBike2(){
		Assert.assertFalse(payload.getGraphData().get(0).isBike2());
	}

}
