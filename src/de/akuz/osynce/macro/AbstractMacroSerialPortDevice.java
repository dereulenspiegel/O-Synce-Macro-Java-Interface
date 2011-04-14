package de.akuz.osynce.macro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.akuz.osynce.macro.interfaces.Macro;
import de.akuz.osynce.macro.interfaces.PersonalData;
import de.akuz.osynce.macro.interfaces.Training;
import de.akuz.osynce.macro.serial.DeviceException;
import de.akuz.osynce.macro.serial.interfaces.Packet;
import de.akuz.osynce.macro.serial.interfaces.SerialPortDevice;
import de.akuz.osynce.macro.serial.packet.Acknowledge;
import de.akuz.osynce.macro.serial.packet.Commands;
import de.akuz.osynce.macro.serial.packet.EraseAllDonePacket;
import de.akuz.osynce.macro.serial.packet.EraseAllDoneProvider;
import de.akuz.osynce.macro.serial.packet.EraseAllRecords;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsPacket;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsProvider;
import de.akuz.osynce.macro.serial.packet.NumberOfTrainingsRequest;
import de.akuz.osynce.macro.serial.packet.PacketException;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedPacket;
import de.akuz.osynce.macro.serial.packet.PersonalDataReceivedProvider;
import de.akuz.osynce.macro.serial.packet.ProviderManager;
import de.akuz.osynce.macro.serial.packet.SetPersonalData;
import de.akuz.osynce.macro.serial.packet.TrainingDetailPacket;
import de.akuz.osynce.macro.serial.packet.TrainingDetailProvider;
import de.akuz.osynce.macro.serial.packet.TrainingDetailRequest;
import de.akuz.osynce.macro.serial.payloads.PersonalDataPayload;
import de.akuz.osynce.macro.serial.payloads.TrainingDetailPayload;

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
	
	protected final static int SLEEP=10;
	
	protected SerialPortDevice device;
	protected String portName;
	
	/**
	 * This is the name of the property to specifiy the serial port
	 * which will be used.
	 */
	public final static String PROPERTY_PORTNAME = "portname";

	@Override
	public List<Training> getTrainings() throws CommunicationException {
		int count = getTrainingCount();
		List<Training> trainings = new ArrayList<Training>(count);
		try {
			device.open(portName);
			for(int i=0;i<count;i++){
				List<TrainingDetailPacket> packets = getTraining(i);
				for(TrainingDetailPacket packet : packets){
					TrainingDetailPayload payload =
						(TrainingDetailPayload)packet.getPayload();
					if(payload.getSummary() != null && 
							!payload.getSummary().isLap()){
						TrainingImpl t = new TrainingImpl(payload);
						trainings.add(t);
					} else {
						((TrainingImpl)trainings.get(trainings.size()-1)).addReceivedTraining(payload);
					}
				}
			}
		} catch (DeviceException e) {
			throw new CommunicationException(e);
		} finally {
			device.close();
		}
		return Collections.unmodifiableList(trainings);
	}
	
	private List<TrainingDetailPacket> getTraining(int number) throws CommunicationException{
		TrainingDetailRequest request = new TrainingDetailRequest(number);
		List<TrainingDetailPacket> packets = 
			new LinkedList<TrainingDetailPacket>();
		int pageNumber = 0;
		try {
			Packet result = device.sendCommand(request);
			while(pageNumber != TrainingDetailPayload.lastPage && result != null){
				pageNumber = 
					((TrainingDetailPayload)result.getPayload()).getPageNumber();
				if(result instanceof TrainingDetailPacket && result.check()){
					packets.add((TrainingDetailPacket)result);
					try {
						Thread.sleep(SLEEP);
					} catch (InterruptedException e) {
						// Ignore
						e.printStackTrace();
					}
					
				} else {
					throw new CommunicationException("Packet isn't read properly");
				}
				result = 
					device.sendCommand(new Acknowledge(result.getCommand()));
			}
		} catch (PacketException e) {
			throw new CommunicationException(e);
		}
		
		return Collections.unmodifiableList(packets);
	}
	
	/**
	 * This method returns the number of laps stored on the
	 * macro device. Note that this will not return the number of trainings
	 * sessions but the number of all laps stored on this device.
	 * @return the number of laps on the device
	 * @throws CommunicationException
	 */
	public int getTrainingCount() throws CommunicationException{
		int trainings = -1;
		try {
			device.open(portName);
			
			NumberOfTrainingsRequest command = new NumberOfTrainingsRequest();
			Packet result = device.sendCommand(command);
			if(result.check()){
				try {
					Thread.sleep(SLEEP);
				} catch (InterruptedException e) {
					// Ignore
				}
				Acknowledge response = new Acknowledge(result.getCommand());
				device.sendCommand(response);
				NumberOfTrainingsPacket packet = 
					(NumberOfTrainingsPacket)result;
				trainings = packet.getListOfTrainings().size();
			}
		} catch (DeviceException e) {
			throw new CommunicationException(e);
		} catch (PacketException e) {
			throw new CommunicationException(e);
		} finally {
			device.close();
		}
		return trainings;
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
