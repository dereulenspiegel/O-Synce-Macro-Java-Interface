package de.akuz.osynce.macro;

import java.util.List;

import de.akuz.osynce.macro.interfaces.Macro;
import de.akuz.osynce.macro.interfaces.PersonalData;
import de.akuz.osynce.macro.interfaces.Training;
import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.SerialPortDevice;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.EraseAllDonePacket;
import de.akuz.osynce.macro.serial.packet.EraseAllDoneProvider;
import de.akuz.osynce.macro.serial.packet.EraseAllRecords;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsProvider;
import de.akuz.osynce.macro.serial.packet.PacketException;
import de.akuz.osynce.macro.serial.packet.ProviderManager;
import de.akuz.osynce.macro.serial.packet.TrainingDetailProvider;

/**
 * Abstract implementation of the Macro interface. This should be the
 * basis for all serial port based implementations.
 * It expects a property called "portname".
 * @author Till Klocke
 *
 */
public abstract class AbstractMacroSerialPortDevice implements Macro {
	
	/**
	 * Register all known PacketProvider
	 */
	static{
		ProviderManager pm = ProviderManager.getInstance();
		pm.registerPacketProvider(Commands.ERASE_DONE.toByte(), 
				new EraseAllDoneProvider());
		pm.registerPacketProvider(Commands.NUMBER_OF_TRAININGS.toByte(),
				new NumberOfTrainingsProvider());
		pm.registerPacketProvider(Commands.TRAINING_DETAIL.toByte(),
				new TrainingDetailProvider());
	}
	
	private SerialPortDevice device;

	@Override
	public List<Training> getTrainings() throws CommunicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPersonalData(PersonalData data)
			throws CommunicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean erase() throws CommunicationException {
		EraseAllRecords packet = new EraseAllRecords();
		try {
			Packet result = device.sendCommand(packet);
			if(result instanceof EraseAllDonePacket && result.check()){
				return true;
			}
		} catch (PacketException e) {
			throw new CommunicationException(e);
		}
		return false;
	}

}
