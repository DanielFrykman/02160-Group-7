package application.model;

import java.util.ArrayList;
import java.util.UUID;

public class LogisticCompanyJourneyManager {
	
	// --- singleton---------------
	private static LogisticCompanyJourneyManager instance;
	private LogisticCompanyJourneyManager() {}

	public static LogisticCompanyJourneyManager getInstance() {
		if(instance== null) {
			instance= new LogisticCompanyJourneyManager();
		}
		return instance;
	}
	// --- singleton---------------

	private LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();

	public LogisticCompanyContainerManager containerManager() {
		return containerManager;
	}

	public Container newJourney(String origin, String destination, String contend, Client owner) {
		if(!newJourneyChecker(origin, destination)) return null;

		Journey newjourney = new Journey(origin, destination, new Log(new ArrayList<SensorData>()), contend, UUID.randomUUID(), owner);

		Container container = containerManager.getContainerByOrigin(origin);
		container.addJourney(newjourney);
		container.setOnJourney(true);

		return container;
	}

	private boolean newJourneyChecker(String origin, String destination) {
		if(origin.equals(destination)) return false;
		if(origin.equals(" ")) return false;
		if(destination.equals(" ")) return false;
		return true;
	}

	public boolean endJourney(Container container) {
		if (container.isOnJourney()) {
			String destinationPlaceholder = container.getLatestJourney().getDestination();
			container.setOrigin(destinationPlaceholder);
			container.setOnJourney(false);
			return true;
		}
		return false;
	}

}
