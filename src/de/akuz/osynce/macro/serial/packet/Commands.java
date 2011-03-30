package de.akuz.osynce.macro.serial.packet;

import java.util.HashMap;
import java.util.Map;

import de.akuz.osynce.macro.utils.Utils;

/**
 * Enum with all commands send from PC to computer
 * @author Till Klocke
 *
 */
public enum Commands {
	
	//Commands send from PC to computer 
	/**
	 * Acknowledge received data
	 */
	ACKNOWLEDGE((byte)0x0A),
	/**
	 * Request the number of trainings
	 */
	NUMBER_OF_TRAINING_REQUESTS((byte)0x06),
	/**
	 * Request details of a training
	 */
	TRAINING_DETAIL_REQUEST((byte)0x09),
	/**
	 * Erase all records on computer
	 */
	ERASE_ALL_RECORDS((byte)0x0B),
	/**
	 * Set personal data in computer
	 */
	PERSONAL_DATA_PACKET((byte)0x0C),
	//Commands send from computer to PC
	/**
	 * Packet with the trainings count
	 */
	NUMBER_OF_TRAININGS((byte)0x86),
	/**
	 * Packet with details about a specific training
	 */
	TRAINING_DETAIL((byte)0x89),
	/**
	 * Packet which acknowledges that all data is erased in computer
	 */
	ERASE_DONE((byte)0x8B),
	/**
	 * Packet which acknowledges that personal data is received by computer
	 */
	PERSONAL_DATA_RECEIVED((byte)0x8C);
	
	private final static Map<Byte,Commands> commandMap = 
		new HashMap<Byte,Commands>();
	
	static{
		commandMap.put(Commands.ACKNOWLEDGE.toByte(), Commands.ACKNOWLEDGE);
		commandMap.put(Commands.ERASE_ALL_RECORDS.toByte(),
				Commands.ERASE_ALL_RECORDS);
		commandMap.put(Commands.ERASE_DONE.toByte(), Commands.ERASE_DONE);
		commandMap.put(Commands.NUMBER_OF_TRAINING_REQUESTS.toByte(), 
				Commands.NUMBER_OF_TRAINING_REQUESTS);
		commandMap.put(Commands.NUMBER_OF_TRAININGS.toByte(), 
				Commands.NUMBER_OF_TRAININGS);
		commandMap.put(Commands.PERSONAL_DATA_PACKET.toByte(), 
				Commands.PERSONAL_DATA_PACKET);
		commandMap.put(Commands.PERSONAL_DATA_RECEIVED.toByte(), 
				Commands.PERSONAL_DATA_RECEIVED);
		commandMap.put(Commands.TRAINING_DETAIL.toByte(), 
				Commands.TRAINING_DETAIL);
		commandMap.put(Commands.TRAINING_DETAIL_REQUEST.toByte(), 
				Commands.TRAINING_DETAIL_REQUEST);
	}
	
	private byte commandByte;
	
	Commands(byte bite){
		this.commandByte = bite;
	}
	
	/**
	 * Get the byte representing this command
	 * @return
	 */
	public byte toByte(){
		return commandByte;
	}
	
	public static Commands fromByte(byte b){
		if(!commandMap.containsKey(b)){
			System.out.println("Getting unknown byte: "+Integer.toHexString(Utils.byteToInt(b)));
		}
		return commandMap.get(b);
	}

}
