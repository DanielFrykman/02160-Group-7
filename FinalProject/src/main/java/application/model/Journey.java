package application.model;
import java.util.UUID;

public class Journey {

	private String destination;
	private String origin;
	private Log log;
	private String content;
	private Client owner;
	private Client viewer = null;
	
	private UUID journeyID;
	
	public Journey(String origin, String destination, Log log, String contend, UUID journeyID, Client owner) {
		super();
		this.destination = destination;
		this.origin = origin;
		this.log = log;
		this.content = contend;
		this.journeyID = journeyID;
		this.owner = owner;
	}
	
	public Log getLog() {
		return log;
	}

	public String getDestination() {
		return destination;
	}

	public String getOrigin() {
		return origin;
	}


	public UUID getJourneyID() {
		return journeyID;
	}

	public String getContent() {
		return content;
	}

	public Client getOwner() {
		return owner;
	}
	
	public Client getViewer() {
		return viewer;
	}

	public void setViewer(Client viewer) {
		this.viewer = viewer;
	}
	
}
