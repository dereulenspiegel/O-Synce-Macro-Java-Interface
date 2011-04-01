package de.akuz.osynce.macro.serial.packet.test;

public class RawData {
	
	public static byte[] numberOfTrainings = new byte[31];	
	static{
		numberOfTrainings[0] = (byte)0x86;
		numberOfTrainings[1] = (byte)0x04;
		numberOfTrainings[2] = (byte)0x00;
		numberOfTrainings[3] = (byte)0x21;
		numberOfTrainings[4] = (byte)0x53;
		numberOfTrainings[5] = (byte)0x17;
		numberOfTrainings[6] = (byte)0x29;
		numberOfTrainings[7] = (byte)0x03;
		numberOfTrainings[8] = (byte)0x11;
		numberOfTrainings[9] = (byte)0x01;
		numberOfTrainings[10] = (byte)0x03;
		numberOfTrainings[11] = (byte)0x55;
		numberOfTrainings[12] = (byte)0x17;
		numberOfTrainings[13] = (byte)0x29;
		numberOfTrainings[14] = (byte)0x03;
		numberOfTrainings[15] = (byte)0x11;
		numberOfTrainings[16] = (byte)0x02;
		numberOfTrainings[17] = (byte)0x59;
		numberOfTrainings[18] = (byte)0x35;
		numberOfTrainings[19] = (byte)0x18;
		numberOfTrainings[20] = (byte)0x29;
		numberOfTrainings[21] = (byte)0x03;
		numberOfTrainings[22] = (byte)0x11;
		numberOfTrainings[23] = (byte)0x03;
		numberOfTrainings[24] = (byte)0x01;
		numberOfTrainings[25] = (byte)0x02;
		numberOfTrainings[26] = (byte)0x13;
		numberOfTrainings[27] = (byte)0x30;
		numberOfTrainings[28] = (byte)0x03;
		numberOfTrainings[29] = (byte)0x11;
		numberOfTrainings[30] = (byte)0x41;
	}
	
	public static byte[] trainingDetail = new byte[260];
	static{
		for(int i=0;i<trainingDetail.length;i++){
			trainingDetail[i] = 0;
		}
		trainingDetail[0] = (byte)0x89;
		trainingDetail[1] = (byte)0x01;
		trainingDetail[2] = (byte)0x00;
		trainingDetail[3] = (byte)0x08;
	}

}
