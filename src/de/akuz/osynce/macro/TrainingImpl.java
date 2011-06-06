package de.akuz.osynce.macro;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import de.akuz.osynce.macro.interfaces.GraphElement;
import de.akuz.osynce.macro.interfaces.Training;
import de.akuz.osynce.macro.serial.packet.TrainingDetailPacket;
import de.akuz.osynce.macro.serial.payloads.TrainingDetailPayload;

/**
 * Simple implementation of the training interface. This implementation
 * can be used in combination with the TrainingDetailPayload.
 * @author Till Klocke
 *
 */
public class TrainingImpl implements Training {
	
	private List<Training> laps = new LinkedList<Training>();
	private List<GraphElement> elements = new LinkedList<GraphElement>();
	
	private Date startDate;
	private int loZoneTime;
	private int hiZoneTime;
	private int inZoneTime;
	private int averageHeartRate;
	private float averageSpeed;
	private int averageAscent;
	private int averageDecline;
	private int altitudeGain;
	private int altitudeLoss;
	private int kCals;
	private float fatBurn;
	private int averageCadence;
	private int distance;
	private int trainingDuration;
	private boolean isLap;
	
	/**
	 * This constructor needs a valid TrainingDetailPayload as parameter.
	 * This payload must be the start of a training or a lap and therefore must
	 * contain a summary
	 * @param payload
	 */
	public TrainingImpl(TrainingDetailPayload payload){
		if(payload.getSummary() == null){
			throw new IllegalArgumentException("This is not the beginning " +
					"of a new training or lap");
		}
		
		try {
			startDate = payload.getSummary().getSectionStartTime();
		} catch (ParseException e) {
			startDate = null;
		}
		loZoneTime = payload.getSummary().getLoZoneTime();
		hiZoneTime = payload.getSummary().getHiZoneTime();
		inZoneTime = payload.getSummary().getInZoneTime();
		averageHeartRate = payload.getSummary().getAverageHeartRate();
		averageSpeed = payload.getSummary().getAverageSpeed();
		averageAscent = payload.getSummary().getPositiveAverageGradient();
		averageDecline = payload.getSummary().getNegativeAverageGradient();
		altitudeGain = payload.getSummary().getAltitudeGain();
		altitudeLoss = payload.getSummary().getAltitudeLoss();
		kCals = payload.getSummary().getBurnedEnergy();
		fatBurn = payload.getSummary().getBurnedFat();
		averageCadence = payload.getSummary().getAverageCadence();
		distance = payload.getSummary().getTripDistance();
		trainingDuration = payload.getSummary().getTrainingDuration();
		isLap = payload.getSummary().isLap();
		
		elements.addAll(payload.getGraphData());
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public int getLoZoneTime() {
		return loZoneTime;
	}

	@Override
	public int getHiZoneTime() {
		return hiZoneTime;
	}

	@Override
	public int getInZoneTime() {
		return inZoneTime;
	}

	@Override
	public int getAverageHeartRate() {
		return averageHeartRate;
	}

	@Override
	public float getAverageSpeed() {
		return averageSpeed;
	}

	@Override
	public int getAverageAscent() {
		return averageAscent;
	}

	@Override
	public int getAverageDecline() {
		return averageDecline;
	}

	@Override
	public int getAltimeterGain() {
		return altitudeGain;
	}

	@Override
	public int getAltimeterLoss() {
		return altitudeLoss;
	}

	@Override
	public int getKCals() {
		return kCals;
	}

	@Override
	public float getFatBurn() {
		return fatBurn;
	}

	@Override
	public int getAverageCadence() {
		return averageCadence;
	}

	@Override
	public int getTripDistance() {
		return distance;
	}

	@Override
	public int getTrainingDuration() {
		return trainingDuration;
	}

	@Override
	public boolean isLap() {
		return isLap;
	}

	@Override
	public List<GraphElement> getAllGraphElements() {
		List<GraphElement> list = new LinkedList<GraphElement>();
		list.addAll(elements);
		for(Training t : laps){
			list.addAll(t.getGraphElements());
		}
		return Collections.unmodifiableList(list);
	}

	@Override
	public List<Training> getLaps() {
		return Collections.unmodifiableList(laps);
	}
	
	/**
	 * Add the data contained in antoher payload to this training.
	 * Since most trainings won't fit inside a single TrainingDetailPayload
	 * you can add subsequent payloads here. If you add a payload with
	 * a summary a new lap will be added and all following payloads
	 * will be added to this lap. Please note that it is not allowed for laps
	 * to have sub laps.
	 * @param payload TrainingDetailPayload to be added
	 */
	public void addReceivedTrainingPayload(TrainingDetailPayload payload){
		if(isLap() && payload.getSummary() != null){
			throw new IllegalArgumentException("Laps can't have sub laps");
		}
		if(payload.getSummary() == null && laps.size() == 0){
			elements.addAll(payload.getGraphData());
		} else if(payload.getSummary() != null && !isLap()){
			Training temp = new TrainingImpl(payload);
			laps.add(temp);
		} else if(payload.getSummary() == null && laps.size() > 0){
			TrainingImpl t = (TrainingImpl)laps.get(laps.size()-1);
			t.addReceivedTrainingPayload(payload);
		}
	}
	
	public void addLap(Training lap){
		if(lap == null){
			throw new IllegalArgumentException("laps can't be NULL");
		}
		laps.add(lap);
	}
	
	public void addReceivedTrainingPacket(TrainingDetailPacket packet){
		addReceivedTrainingPayload((TrainingDetailPayload)packet.getPayload());
	}

	@Override
	public List<GraphElement> getGraphElements() {
		return Collections.unmodifiableList(elements);
	}

}
