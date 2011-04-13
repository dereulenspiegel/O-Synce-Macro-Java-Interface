package de.akuz.osynce.macro;

import java.util.List;

import de.akuz.osynce.macro.interfaces.Macro;
import de.akuz.osynce.macro.interfaces.PersonalData;
import de.akuz.osynce.macro.interfaces.Training;
import de.akuz.osynce.macro.serial.DeviceException;
import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.SerialPortDevice;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.EraseAllDonePacket;
import de.akuz.osynce.macro.serial.packet.EraseAllDoneProvider;
import de.akuz.osynce.macro.serial.packet.EraseAllRecords;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsProvider;
import de.akuz.osynce.macro.serial.packet.PacketException;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedPacket;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedProvider;
import de.akuz.osynce.macro.serial.packet.ProviderManager;
import de.akuz.osynce.macro.serial.packet.SetPersonalData;
import de.akuz.osynce.macro.serial.packet.TrainingDetailProvider;
import de.akuz.osynce.macro.serial.payloads.PersonalDataPayload;

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
		pm.registerPacketProvider(Commands.PERSONAL_DATA_RECEIVED.toByte(), 
				new PersonalDataReceivedProvider());
	}
	
	protected SerialPortDevice device;
	protected String portName;
	
	public final static String PROPERTY_PORTNAME = "portname";

	@Override
	public List<Training> getTrainings() throws CommunicationException {
		try {
			device.open(portName);
			
		} catch (DeviceException e) {
			throw new CommunicationException(e);
		} finally {
			device.close();
		}
		return null;
	}

	@Override
	public boolean setPersonalData(PersonalData data)
			throws CommunicationException {
		SetPersonalData packet = 
			new SetPersonalData(getPersonalDataPayload(data));
		try {
			device.open(this.portName);
			Packet result = device.sendCommand(packet);
			if(result instanceof PersonalDataReceivedPacket &&
					result.check()){
				device.close();
				return true;
			}
		} catch (PacketException e) {
			throw new CommunicationException(e);
		} catch (DeviceException e) {
			throw new CommunicationException(e);
		} finally{
			device.close();
		}
		return false;

	}
	
	private PersonalDataPayload getPersonalDataPayload(PersonalData data){
		if(data instanceof PersonalDataPayload){
			return (PersonalDataPayload)data;
		}
		PersonalDataPayload payload = new PersonalDataPayload();
		
		//TODO:
		
		return payload;
	}

	@Override
	public boolean erase() throws CommunicationException {
		EraseAllRecords packet = new EraseAllRecords();
		try {
			device.open(portName);
			Packet result = device.sendCommand(packet);
			if(result instanceof EraseAllDonePacket && result.check()){
				device.close();
				return true;
			}
		} catch (PacketException e) {
			throw new CommunicationException(e);
		} catch (DeviceException e) {
			throw new CommunicationException(e);
		} finally {
			device.close();
		}
		return false;
	}

}
