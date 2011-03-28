package de.akuz.osynce.macro.packet;

import de.akuz.osynce.macro.interfaces.Command;

/**
 * Packet which acknowledges a packet received by PC
 * @author Till Klocke
 *
 */
public class Acknowledge extends AbstractPacket implements Command {
	
	/**
	 * Creates a new instance of Acknowledge. The command parameter
	 * is the received packet to be akcnowledged not the ACKNOWLEDGE
	 * command!
	 * @param command the command to be acknowledged
	 */
	public Acknowledge(Commands command){
		super(Commands.ACKNOWLEDGE);
		setPayload(new SimplePayload(command.toByte()));
	}
}
