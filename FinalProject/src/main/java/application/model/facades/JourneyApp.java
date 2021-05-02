package application.model.facades;

import application.model.*;

public class JourneyApp {
	
	private static JourneyApp instance;
	private JourneyApp() {}

	public static JourneyApp getInstance() {
		if(instance== null) {
			instance= new JourneyApp();
		}
		return instance;
	}
	
	LogisticCompanyClientManager clientManager = LogisticCompanyClientManager.getInstance();
	LogisticCompanyJourneyManager journeyManager = LogisticCompanyJourneyManager.getInstance();
	LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();
	
	public boolean newJourney(String clientName, String origin, String destination, String contend) {
		Container container = journeyManager.newJourney(origin, destination, contend, AdminApp.getInstance().searchClientByName(clientName));
		if (container==null) return false;
		clientManager.addContainerToClient(clientName, container);
		return true;
	}

	public boolean endJourney(Container container) {
		if(journeyManager.endJourney(container)) return true;
		return false;
	}
	
	public Journey getLatestJourney(Container container) {
		return containerManager.getLatestJourney(container);
	}
	
	public Journey getLatestJourneyByClientName(String name, int containerIndex) {
		return AdminApp.getInstance().searchClientByName(name).getClientsContainers().get(containerIndex).getLatestJourney();
	}
	
	

}
