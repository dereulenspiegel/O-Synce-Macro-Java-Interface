package de.akuz.osynce.macro.utils.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.akuz.osynce.macro.utils.Utils;

public class UtilsTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertIntToByteArray() {
		int i = 1;
		byte[] byteArray = Utils.convertIntToByteArray(i);
		Assert.assertEquals(byteArray[3],i);
		Assert.assertEquals(byteArray[2], 0);
		Assert.assertEquals(byteArray[1], 0);
		Assert.assertEquals(byteArray[0], 0);
		
		i = 0xFF;
		byteArray = Utils.convertIntToByteArray(i);
		Assert.assertEquals(byteArray[3], -1);
		Assert.assertEquals(byteArray[2], 0);
		Assert.assertEquals(byteArray[1], 0);
		Assert.assertEquals(byteArray[0], 0);
		
		i = 0xFF+1;
		byteArray = Utils.convertIntToByteArray(i);
		Assert.assertEquals(byteArray[3], 0);
		Assert.assertEquals(byteArray[2], 1);
		Assert.assertEquals(byteArray[1], 0);
		Assert.assertEquals(byteArray[0], 0);
	}

	@Test
	public void testConvertByteArrayToInt() {
		byte[] byteArray = new byte[4];
		
		byteArray[3] = 1;
		byteArray[2] = 0;
		byteArray[1] = 0;
		byteArray[0] = 0;
		Assert.assertEquals(1, Utils.convertByteArrayToInt(byteArray));
		
		byteArray[3] = -1;
		Assert.assertEquals(255, Utils.convertByteArrayToInt(byteArray));
		
		byteArray[2] = 1;
		Assert.assertEquals(255+256, Utils.convertByteArrayToInt(byteArray));
		
		byteArray = new byte[2];
		byteArray[0] = 0;
		byteArray[1] = 1;
		Assert.assertEquals(1, Utils.convertByteArrayToInt(byteArray));
	}
	
	@Test
	public void testByteToInt(){
		byte b = (byte)255;
		Assert.assertEquals(-1, b);
		Assert.assertEquals(255, Utils.byteToInt(b));
		Assert.assertEquals(1, Utils.byteToInt((byte)1));
		Assert.assertEquals(0, Utils.byteToInt((byte)0));
	}
	
	@Test
	public void testConvertingNegativeIntegers() {
		int altitude = -381;
		byte[] array = Utils.convertIntToByteArray(altitude);
		Assert.assertEquals(altitude, Utils.convertByteArrayToInt(array));
		
		altitude = -1;
		array = Utils.convertIntToByteArray(altitude);
		Assert.assertEquals(altitude, Utils.convertByteArrayToInt(array));
	}
	
	@Test
	public void testConvertIntToBCD() {
		int i = 0;
		Assert.assertEquals(i, Utils.convertIntToBCD(i));
		
		i = 1;
		Assert.assertEquals(i, Utils.convertIntToBCD(i));
		
		i = 9;
		Assert.assertEquals(i, Utils.convertIntToBCD(i));
	}
	
	@Test
	public void testConvertBCDToInt() {
		int i = 9;
		byte in = Utils.convertIntToBCD(i);
		Assert.assertEquals(i, Utils.convertBCDToInt(in));
		
		i = 12;
		in = Utils.convertIntToBCD(i);
		Assert.assertEquals(i, Utils.convertBCDToInt(in));
	}
	
	@Test
	public void testSumOfDigits(){
		int i = 833;
		int sumOfDigits = 14;
		Assert.assertEquals(sumOfDigits, Utils.sumOfDigits(i));
		
		i = 5;
		sumOfDigits = 5;
		Assert.assertEquals(sumOfDigits, Utils.sumOfDigits(i));
	}

}
