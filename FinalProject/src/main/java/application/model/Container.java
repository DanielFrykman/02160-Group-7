package application.model;
import java.util.UUID; 
import java.util.ArrayList;

public class Container {
	
	private ArrayList<Journey> journeys;
	private String origin;
	private UUID id;
	private boolean onJourney;

	public Container(ArrayList<Journey> journeys, String origin, UUID id, boolean onJourney) {
		super();
		this.journeys = journeys;
		this.origin = origin;
		this.id = id; 
		this.onJourney = onJourney;
	}

	public boolean isOnJourney() {
		return onJourney;
	}

	public void setOnJourney(boolean onJourney) {
		this.onJourney = onJourney;
	}

	public ArrayList<Journey> getJourneys() {
		return journeys;
	}
	
	public Journey getLatestJourney() {
		return this.journeys.get(this.journeys.size()-1);
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getOrigin() {
		return origin;
	}

	public UUID getId() {
		return id;
	}

	public void addJourney(Journey newJourney) {
		journeys.add(newJourney);
	}
	
}
