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
	
	public static byte[] trainingDetail0 = new byte[260];
	static{
		trainingDetail0[0] = (byte)0x89;
		trainingDetail0[1] = (byte)0x1;
		trainingDetail0[2] = (byte)0x0;
		trainingDetail0[3] = (byte)0x10;
		trainingDetail0[4] = (byte)0x0;
		trainingDetail0[5] = (byte)0x0;
		trainingDetail0[6] = (byte)0x0;
		trainingDetail0[7] = (byte)0x0;
		trainingDetail0[8] = (byte)0x0;
		trainingDetail0[9] = (byte)0x0;
		trainingDetail0[10] = (byte)0x0;
		trainingDetail0[11] = (byte)0x0;
		trainingDetail0[12] = (byte)0x0;
		trainingDetail0[13] = (byte)0x0;
		trainingDetail0[14] = (byte)0x0;
		trainingDetail0[15] = (byte)0x0;
		trainingDetail0[16] = (byte)0x0;
		trainingDetail0[17] = (byte)0x37;
		trainingDetail0[18] = (byte)0x0;
		trainingDetail0[19] = (byte)0x3;
		trainingDetail0[20] = (byte)0x0;
		trainingDetail0[21] = (byte)0x3;
		trainingDetail0[22] = (byte)0x0;
		trainingDetail0[23] = (byte)0x5;
		trainingDetail0[24] = (byte)0x1;
		trainingDetail0[25] = (byte)0xdb;
		trainingDetail0[26] = (byte)0x0;
		trainingDetail0[27] = (byte)0x0;
		trainingDetail0[28] = (byte)0x0;
		trainingDetail0[29] = (byte)0x0;
		trainingDetail0[30] = (byte)0x0;
		trainingDetail0[31] = (byte)0x0;
		trainingDetail0[32] = (byte)0x4a;
		trainingDetail0[33] = (byte)0x4e;
		trainingDetail0[34] = (byte)0x25;
		trainingDetail0[35] = (byte)0x2;
		trainingDetail0[36] = (byte)0x0;
		trainingDetail0[37] = (byte)0x31;
		trainingDetail0[38] = (byte)0x6;
		trainingDetail0[39] = (byte)0x0;
		trainingDetail0[40] = (byte)0x0;
		trainingDetail0[41] = (byte)0x0;
		trainingDetail0[42] = (byte)0x0;
		trainingDetail0[43] = (byte)0x1;
		trainingDetail0[44] = (byte)0x0;
		trainingDetail0[45] = (byte)0x0;
		trainingDetail0[46] = (byte)0x0;
		trainingDetail0[47] = (byte)0x0;
		trainingDetail0[48] = (byte)0x0;
		trainingDetail0[49] = (byte)0x0;
		trainingDetail0[50] = (byte)0x0;
		trainingDetail0[51] = (byte)0x0;
		trainingDetail0[52] = (byte)0x0;
		trainingDetail0[53] = (byte)0x0;
		trainingDetail0[54] = (byte)0x0;
		trainingDetail0[55] = (byte)0x0;
		trainingDetail0[56] = (byte)0x0;
		trainingDetail0[57] = (byte)0x0;
		trainingDetail0[58] = (byte)0x0;
		trainingDetail0[59] = (byte)0x0;
		trainingDetail0[60] = (byte)0x0;
		trainingDetail0[61] = (byte)0x0;
		trainingDetail0[62] = (byte)0x0;
		trainingDetail0[63] = (byte)0x0;
		trainingDetail0[64] = (byte)0x21;
		trainingDetail0[65] = (byte)0x29;
		trainingDetail0[66] = (byte)0x12;
		trainingDetail0[67] = (byte)0x2;
		trainingDetail0[68] = (byte)0x4;
		trainingDetail0[69] = (byte)0x11;
		trainingDetail0[70] = (byte)0x0;
		trainingDetail0[71] = (byte)0x0;
		trainingDetail0[72] = (byte)0x0;
		trainingDetail0[73] = (byte)0x0;
		trainingDetail0[74] = (byte)0x0;
		trainingDetail0[75] = (byte)0x4;
		trainingDetail0[76] = (byte)0x12;
		trainingDetail0[77] = (byte)0x7;
		trainingDetail0[78] = (byte)0xd;
		trainingDetail0[79] = (byte)0x1;
		trainingDetail0[80] = (byte)0x0;
		trainingDetail0[81] = (byte)0x0;
		trainingDetail0[82] = (byte)0x0;
		trainingDetail0[83] = (byte)0x0;
		trainingDetail0[84] = (byte)0x0;
		trainingDetail0[85] = (byte)0x0;
		trainingDetail0[86] = (byte)0x0;
		trainingDetail0[87] = (byte)0x0;
		trainingDetail0[88] = (byte)0x12;
		trainingDetail0[89] = (byte)0x7;
		trainingDetail0[90] = (byte)0xd;
		trainingDetail0[91] = (byte)0x1;
		trainingDetail0[92] = (byte)0x0;
		trainingDetail0[93] = (byte)0x0;
		trainingDetail0[94] = (byte)0x51;
		trainingDetail0[95] = (byte)0x0;
		trainingDetail0[96] = (byte)0x0;
		trainingDetail0[97] = (byte)0x0;
		trainingDetail0[98] = (byte)0x0;
		trainingDetail0[99] = (byte)0x0;
		trainingDetail0[100] = (byte)0x12;
		trainingDetail0[101] = (byte)0x7;
		trainingDetail0[102] = (byte)0xd;
		trainingDetail0[103] = (byte)0x1;
		trainingDetail0[104] = (byte)0x0;
		trainingDetail0[105] = (byte)0x0;
		trainingDetail0[106] = (byte)0x3e;
		trainingDetail0[107] = (byte)0x0;
		trainingDetail0[108] = (byte)0x0;
		trainingDetail0[109] = (byte)0x0;
		trainingDetail0[110] = (byte)0x0;
		trainingDetail0[111] = (byte)0x0;
		trainingDetail0[112] = (byte)0x12;
		trainingDetail0[113] = (byte)0x7;
		trainingDetail0[114] = (byte)0xd;
		trainingDetail0[115] = (byte)0x1;
		trainingDetail0[116] = (byte)0x0;
		trainingDetail0[117] = (byte)0x0;
		trainingDetail0[118] = (byte)0x80;
		trainingDetail0[119] = (byte)0x0;
		trainingDetail0[120] = (byte)0x0;
		trainingDetail0[121] = (byte)0x0;
		trainingDetail0[122] = (byte)0x0;
		trainingDetail0[123] = (byte)0x0;
		trainingDetail0[124] = (byte)0x12;
		trainingDetail0[125] = (byte)0x7;
		trainingDetail0[126] = (byte)0xc;
		trainingDetail0[127] = (byte)0x1;
		trainingDetail0[128] = (byte)0x0;
		trainingDetail0[129] = (byte)0x0;
		trainingDetail0[130] = (byte)0x88;
		trainingDetail0[131] = (byte)0x0;
		trainingDetail0[132] = (byte)0x0;
		trainingDetail0[133] = (byte)0x0;
		trainingDetail0[134] = (byte)0x0;
		trainingDetail0[135] = (byte)0x0;
		trainingDetail0[136] = (byte)0xd;
		trainingDetail0[137] = (byte)0x7;
		trainingDetail0[138] = (byte)0xc;
		trainingDetail0[139] = (byte)0x1;
		trainingDetail0[140] = (byte)0x0;
		trainingDetail0[141] = (byte)0x0;
		trainingDetail0[142] = (byte)0x6f;
		trainingDetail0[143] = (byte)0x0;
		trainingDetail0[144] = (byte)0x0;
		trainingDetail0[145] = (byte)0x0;
		trainingDetail0[146] = (byte)0x0;
		trainingDetail0[147] = (byte)0x0;
		trainingDetail0[148] = (byte)0x17;
		trainingDetail0[149] = (byte)0x7;
		trainingDetail0[150] = (byte)0xd;
		trainingDetail0[151] = (byte)0x1;
		trainingDetail0[152] = (byte)0x0;
		trainingDetail0[153] = (byte)0x0;
		trainingDetail0[154] = (byte)0x90;
		trainingDetail0[155] = (byte)0x0;
		trainingDetail0[156] = (byte)0x0;
		trainingDetail0[157] = (byte)0x0;
		trainingDetail0[158] = (byte)0x0;
		trainingDetail0[159] = (byte)0x0;
		trainingDetail0[160] = (byte)0x1c;
		trainingDetail0[161] = (byte)0x7;
		trainingDetail0[162] = (byte)0xe;
		trainingDetail0[163] = (byte)0x1;
		trainingDetail0[164] = (byte)0x0;
		trainingDetail0[165] = (byte)0x0;
		trainingDetail0[166] = (byte)0x9e;
		trainingDetail0[167] = (byte)0x0;
		trainingDetail0[168] = (byte)0x0;
		trainingDetail0[169] = (byte)0x0;
		trainingDetail0[170] = (byte)0x0;
		trainingDetail0[171] = (byte)0x0;
		trainingDetail0[172] = (byte)0x1c;
		trainingDetail0[173] = (byte)0x7;
		trainingDetail0[174] = (byte)0xe;
		trainingDetail0[175] = (byte)0x1;
		trainingDetail0[176] = (byte)0x0;
		trainingDetail0[177] = (byte)0x0;
		trainingDetail0[178] = (byte)0xa9;
		trainingDetail0[179] = (byte)0x0;
		trainingDetail0[180] = (byte)0x0;
		trainingDetail0[181] = (byte)0x0;
		trainingDetail0[182] = (byte)0x0;
		trainingDetail0[183] = (byte)0x0;
		trainingDetail0[184] = (byte)0x21;
		trainingDetail0[185] = (byte)0x7;
		trainingDetail0[186] = (byte)0xe;
		trainingDetail0[187] = (byte)0x1;
		trainingDetail0[188] = (byte)0x0;
		trainingDetail0[189] = (byte)0x0;
		trainingDetail0[190] = (byte)0xaf;
		trainingDetail0[191] = (byte)0x0;
		trainingDetail0[192] = (byte)0x0;
		trainingDetail0[193] = (byte)0x0;
		trainingDetail0[194] = (byte)0x0;
		trainingDetail0[195] = (byte)0x0;
		trainingDetail0[196] = (byte)0x26;
		trainingDetail0[197] = (byte)0x7;
		trainingDetail0[198] = (byte)0xe;
		trainingDetail0[199] = (byte)0x1;
		trainingDetail0[200] = (byte)0x0;
		trainingDetail0[201] = (byte)0x0;
		trainingDetail0[202] = (byte)0xb4;
		trainingDetail0[203] = (byte)0x0;
		trainingDetail0[204] = (byte)0x0;
		trainingDetail0[205] = (byte)0x0;
		trainingDetail0[206] = (byte)0x0;
		trainingDetail0[207] = (byte)0x0;
		trainingDetail0[208] = (byte)0x3a;
		trainingDetail0[209] = (byte)0x7;
		trainingDetail0[210] = (byte)0xe;
		trainingDetail0[211] = (byte)0x1;
		trainingDetail0[212] = (byte)0x0;
		trainingDetail0[213] = (byte)0x0;
		trainingDetail0[214] = (byte)0xaf;
		trainingDetail0[215] = (byte)0x0;
		trainingDetail0[216] = (byte)0x0;
		trainingDetail0[217] = (byte)0x0;
		trainingDetail0[218] = (byte)0x0;
		trainingDetail0[219] = (byte)0x0;
		trainingDetail0[220] = (byte)0x3a;
		trainingDetail0[221] = (byte)0x7;
		trainingDetail0[222] = (byte)0xe;
		trainingDetail0[223] = (byte)0x1;
		trainingDetail0[224] = (byte)0x0;
		trainingDetail0[225] = (byte)0x0;
		trainingDetail0[226] = (byte)0xaf;
		trainingDetail0[227] = (byte)0x0;
		trainingDetail0[228] = (byte)0x0;
		trainingDetail0[229] = (byte)0x0;
		trainingDetail0[230] = (byte)0x0;
		trainingDetail0[231] = (byte)0x0;
		trainingDetail0[232] = (byte)0x3f;
		trainingDetail0[233] = (byte)0x7;
		trainingDetail0[234] = (byte)0xe;
		trainingDetail0[235] = (byte)0x1;
		trainingDetail0[236] = (byte)0x0;
		trainingDetail0[237] = (byte)0x0;
		trainingDetail0[238] = (byte)0x97;
		trainingDetail0[239] = (byte)0x0;
		trainingDetail0[240] = (byte)0x0;
		trainingDetail0[241] = (byte)0x0;
		trainingDetail0[242] = (byte)0x0;
		trainingDetail0[243] = (byte)0x0;
		trainingDetail0[244] = (byte)0x44;
		trainingDetail0[245] = (byte)0x7;
		trainingDetail0[246] = (byte)0xd;
		trainingDetail0[247] = (byte)0x1;
		trainingDetail0[248] = (byte)0x0;
		trainingDetail0[249] = (byte)0x0;
		trainingDetail0[250] = (byte)0xba;
		trainingDetail0[251] = (byte)0x0;
		trainingDetail0[252] = (byte)0x0;
		trainingDetail0[253] = (byte)0x0;
		trainingDetail0[254] = (byte)0x0;
		trainingDetail0[255] = (byte)0x0;
		trainingDetail0[256] = (byte)0x0;
		trainingDetail0[257] = (byte)0x0;
		trainingDetail0[258] = (byte)0x0;
		trainingDetail0[259] = (byte)0x49;
	}
	
	public static byte[] trainingDetail1 = new byte[260];
	static{
		trainingDetail1[0] = (byte)0x89;
		trainingDetail1[1] = (byte)0x2;
		trainingDetail1[2] = (byte)0x0;
		trainingDetail1[3] = (byte)0x15;
		trainingDetail1[4] = (byte)0x53;
		trainingDetail1[5] = (byte)0x7;
		trainingDetail1[6] = (byte)0xc;
		trainingDetail1[7] = (byte)0x1;
		trainingDetail1[8] = (byte)0x0;
		trainingDetail1[9] = (byte)0x0;
		trainingDetail1[10] = (byte)0xc1;
		trainingDetail1[11] = (byte)0x0;
		trainingDetail1[12] = (byte)0x0;
		trainingDetail1[13] = (byte)0x0;
		trainingDetail1[14] = (byte)0x0;
		trainingDetail1[15] = (byte)0x0;
		trainingDetail1[16] = (byte)0x5d;
		trainingDetail1[17] = (byte)0x7;
		trainingDetail1[18] = (byte)0xc;
		trainingDetail1[19] = (byte)0x1;
		trainingDetail1[20] = (byte)0x0;
		trainingDetail1[21] = (byte)0x0;
		trainingDetail1[22] = (byte)0xb9;
		trainingDetail1[23] = (byte)0x0;
		trainingDetail1[24] = (byte)0x0;
		trainingDetail1[25] = (byte)0x0;
		trainingDetail1[26] = (byte)0x0;
		trainingDetail1[27] = (byte)0x0;
		trainingDetail1[28] = (byte)0x62;
		trainingDetail1[29] = (byte)0x7;
		trainingDetail1[30] = (byte)0xd;
		trainingDetail1[31] = (byte)0x1;
		trainingDetail1[32] = (byte)0x0;
		trainingDetail1[33] = (byte)0x0;
		trainingDetail1[34] = (byte)0xac;
		trainingDetail1[35] = (byte)0x0;
		trainingDetail1[36] = (byte)0x0;
		trainingDetail1[37] = (byte)0x0;
		trainingDetail1[38] = (byte)0x0;
		trainingDetail1[39] = (byte)0x0;
		trainingDetail1[40] = (byte)0x67;
		trainingDetail1[41] = (byte)0x7;
		trainingDetail1[42] = (byte)0xe;
		trainingDetail1[43] = (byte)0x1;
		trainingDetail1[44] = (byte)0x0;
		trainingDetail1[45] = (byte)0x0;
		trainingDetail1[46] = (byte)0x88;
		trainingDetail1[47] = (byte)0x0;
		trainingDetail1[48] = (byte)0x0;
		trainingDetail1[49] = (byte)0x0;
		trainingDetail1[50] = (byte)0x0;
		trainingDetail1[51] = (byte)0x0;
		trainingDetail1[52] = (byte)0x76;
		trainingDetail1[53] = (byte)0x7;
		trainingDetail1[54] = (byte)0xf;
		trainingDetail1[55] = (byte)0x1;
		trainingDetail1[56] = (byte)0x1;
		trainingDetail1[57] = (byte)0x0;
		trainingDetail1[58] = (byte)0x76;
		trainingDetail1[59] = (byte)0x0;
		trainingDetail1[60] = (byte)0x0;
		trainingDetail1[61] = (byte)0x0;
		trainingDetail1[62] = (byte)0x0;
		trainingDetail1[63] = (byte)0x0;
		trainingDetail1[64] = (byte)0x7b;
		trainingDetail1[65] = (byte)0x7;
		trainingDetail1[66] = (byte)0x10;
		trainingDetail1[67] = (byte)0x1;
		trainingDetail1[68] = (byte)0x2;
		trainingDetail1[69] = (byte)0x0;
		trainingDetail1[70] = (byte)0xa4;
		trainingDetail1[71] = (byte)0x0;
		trainingDetail1[72] = (byte)0x0;
		trainingDetail1[73] = (byte)0x0;
		trainingDetail1[74] = (byte)0x0;
		trainingDetail1[75] = (byte)0x0;
		trainingDetail1[76] = (byte)0x80;
		trainingDetail1[77] = (byte)0x7;
		trainingDetail1[78] = (byte)0x10;
		trainingDetail1[79] = (byte)0x1;
		trainingDetail1[80] = (byte)0x2;
		trainingDetail1[81] = (byte)0x0;
		trainingDetail1[82] = (byte)0x9f;
		trainingDetail1[83] = (byte)0x0;
		trainingDetail1[84] = (byte)0x0;
		trainingDetail1[85] = (byte)0x0;
		trainingDetail1[86] = (byte)0x0;
		trainingDetail1[87] = (byte)0x0;
		trainingDetail1[88] = (byte)0x80;
		trainingDetail1[89] = (byte)0x7;
		trainingDetail1[90] = (byte)0x10;
		trainingDetail1[91] = (byte)0x1;
		trainingDetail1[92] = (byte)0x2;
		trainingDetail1[93] = (byte)0x0;
		trainingDetail1[94] = (byte)0xa7;
		trainingDetail1[95] = (byte)0x0;
		trainingDetail1[96] = (byte)0x0;
		trainingDetail1[97] = (byte)0x0;
		trainingDetail1[98] = (byte)0x0;
		trainingDetail1[99] = (byte)0x0;
		trainingDetail1[100] = (byte)0x94;
		trainingDetail1[101] = (byte)0x7;
		trainingDetail1[102] = (byte)0x11;
		trainingDetail1[103] = (byte)0x1;
		trainingDetail1[104] = (byte)0x0;
		trainingDetail1[105] = (byte)0x0;
		trainingDetail1[106] = (byte)0xa5;
		trainingDetail1[107] = (byte)0x0;
		trainingDetail1[108] = (byte)0x0;
		trainingDetail1[109] = (byte)0x0;
		trainingDetail1[110] = (byte)0x0;
		trainingDetail1[111] = (byte)0x0;
		trainingDetail1[112] = (byte)0x99;
		trainingDetail1[113] = (byte)0x7;
		trainingDetail1[114] = (byte)0x11;
		trainingDetail1[115] = (byte)0x1;
		trainingDetail1[116] = (byte)0x1;
		trainingDetail1[117] = (byte)0x0;
		trainingDetail1[118] = (byte)0xa5;
		trainingDetail1[119] = (byte)0x0;
		trainingDetail1[120] = (byte)0x0;
		trainingDetail1[121] = (byte)0x0;
		trainingDetail1[122] = (byte)0x0;
		trainingDetail1[123] = (byte)0x0;
		trainingDetail1[124] = (byte)0x9e;
		trainingDetail1[125] = (byte)0x7;
		trainingDetail1[126] = (byte)0x12;
		trainingDetail1[127] = (byte)0x1;
		trainingDetail1[128] = (byte)0x2;
		trainingDetail1[129] = (byte)0x0;
		trainingDetail1[130] = (byte)0x9f;
		trainingDetail1[131] = (byte)0x0;
		trainingDetail1[132] = (byte)0x0;
		trainingDetail1[133] = (byte)0x0;
		trainingDetail1[134] = (byte)0x0;
		trainingDetail1[135] = (byte)0x0;
		trainingDetail1[136] = (byte)0x9e;
		trainingDetail1[137] = (byte)0x7;
		trainingDetail1[138] = (byte)0x13;
		trainingDetail1[139] = (byte)0x1;
		trainingDetail1[140] = (byte)0x3;
		trainingDetail1[141] = (byte)0x0;
		trainingDetail1[142] = (byte)0x9f;
		trainingDetail1[143] = (byte)0x0;
		trainingDetail1[144] = (byte)0x0;
		trainingDetail1[145] = (byte)0x0;
		trainingDetail1[146] = (byte)0x0;
		trainingDetail1[147] = (byte)0x0;
		trainingDetail1[148] = (byte)0xa8;
		trainingDetail1[149] = (byte)0x7;
		trainingDetail1[150] = (byte)0x14;
		trainingDetail1[151] = (byte)0x1;
		trainingDetail1[152] = (byte)0x3;
		trainingDetail1[153] = (byte)0x0;
		trainingDetail1[154] = (byte)0x9c;
		trainingDetail1[155] = (byte)0x0;
		trainingDetail1[156] = (byte)0x0;
		trainingDetail1[157] = (byte)0x0;
		trainingDetail1[158] = (byte)0x0;
		trainingDetail1[159] = (byte)0x0;
		trainingDetail1[160] = (byte)0xb2;
		trainingDetail1[161] = (byte)0x7;
		trainingDetail1[162] = (byte)0x15;
		trainingDetail1[163] = (byte)0x1;
		trainingDetail1[164] = (byte)0x3;
		trainingDetail1[165] = (byte)0x0;
		trainingDetail1[166] = (byte)0x79;
		trainingDetail1[167] = (byte)0x0;
		trainingDetail1[168] = (byte)0x0;
		trainingDetail1[169] = (byte)0x0;
		trainingDetail1[170] = (byte)0x0;
		trainingDetail1[171] = (byte)0x0;
		trainingDetail1[172] = (byte)0xb7;
		trainingDetail1[173] = (byte)0x7;
		trainingDetail1[174] = (byte)0x16;
		trainingDetail1[175] = (byte)0x1;
		trainingDetail1[176] = (byte)0x3;
		trainingDetail1[177] = (byte)0x0;
		trainingDetail1[178] = (byte)0x98;
		trainingDetail1[179] = (byte)0x0;
		trainingDetail1[180] = (byte)0x0;
		trainingDetail1[181] = (byte)0x0;
		trainingDetail1[182] = (byte)0x0;
		trainingDetail1[183] = (byte)0x0;
		trainingDetail1[184] = (byte)0xbc;
		trainingDetail1[185] = (byte)0x7;
		trainingDetail1[186] = (byte)0x16;
		trainingDetail1[187] = (byte)0x1;
		trainingDetail1[188] = (byte)0x3;
		trainingDetail1[189] = (byte)0x0;
		trainingDetail1[190] = (byte)0xa1;
		trainingDetail1[191] = (byte)0x0;
		trainingDetail1[192] = (byte)0x0;
		trainingDetail1[193] = (byte)0x0;
		trainingDetail1[194] = (byte)0x0;
		trainingDetail1[195] = (byte)0x0;
		trainingDetail1[196] = (byte)0xcb;
		trainingDetail1[197] = (byte)0x7;
		trainingDetail1[198] = (byte)0x16;
		trainingDetail1[199] = (byte)0x1;
		trainingDetail1[200] = (byte)0x1;
		trainingDetail1[201] = (byte)0x0;
		trainingDetail1[202] = (byte)0xa5;
		trainingDetail1[203] = (byte)0x0;
		trainingDetail1[204] = (byte)0x0;
		trainingDetail1[205] = (byte)0x0;
		trainingDetail1[206] = (byte)0x0;
		trainingDetail1[207] = (byte)0x0;
		trainingDetail1[208] = (byte)0xd0;
		trainingDetail1[209] = (byte)0x7;
		trainingDetail1[210] = (byte)0x16;
		trainingDetail1[211] = (byte)0x1;
		trainingDetail1[212] = (byte)0x1;
		trainingDetail1[213] = (byte)0x0;
		trainingDetail1[214] = (byte)0xa4;
		trainingDetail1[215] = (byte)0x0;
		trainingDetail1[216] = (byte)0x0;
		trainingDetail1[217] = (byte)0x0;
		trainingDetail1[218] = (byte)0x0;
		trainingDetail1[219] = (byte)0x0;
		trainingDetail1[220] = (byte)0xd5;
		trainingDetail1[221] = (byte)0x7;
		trainingDetail1[222] = (byte)0x16;
		trainingDetail1[223] = (byte)0x1;
		trainingDetail1[224] = (byte)0x0;
		trainingDetail1[225] = (byte)0x0;
		trainingDetail1[226] = (byte)0xaa;
		trainingDetail1[227] = (byte)0x0;
		trainingDetail1[228] = (byte)0x0;
		trainingDetail1[229] = (byte)0x0;
		trainingDetail1[230] = (byte)0x0;
		trainingDetail1[231] = (byte)0x0;
		trainingDetail1[232] = (byte)0xd5;
		trainingDetail1[233] = (byte)0x7;
		trainingDetail1[234] = (byte)0x16;
		trainingDetail1[235] = (byte)0x1;
		trainingDetail1[236] = (byte)0x0;
		trainingDetail1[237] = (byte)0x0;
		trainingDetail1[238] = (byte)0xab;
		trainingDetail1[239] = (byte)0x0;
		trainingDetail1[240] = (byte)0x0;
		trainingDetail1[241] = (byte)0x0;
		trainingDetail1[242] = (byte)0x0;
		trainingDetail1[243] = (byte)0x0;
		trainingDetail1[244] = (byte)0xe9;
		trainingDetail1[245] = (byte)0x7;
		trainingDetail1[246] = (byte)0x16;
		trainingDetail1[247] = (byte)0x1;
		trainingDetail1[248] = (byte)0x0;
		trainingDetail1[249] = (byte)0x0;
		trainingDetail1[250] = (byte)0xa5;
		trainingDetail1[251] = (byte)0x0;
		trainingDetail1[252] = (byte)0x0;
		trainingDetail1[253] = (byte)0x0;
		trainingDetail1[254] = (byte)0x0;
		trainingDetail1[255] = (byte)0x0;
		trainingDetail1[256] = (byte)0x0;
		trainingDetail1[257] = (byte)0x0;
		trainingDetail1[258] = (byte)0x0;
		trainingDetail1[259] = (byte)0xd4;
	}

}
