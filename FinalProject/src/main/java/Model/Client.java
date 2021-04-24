package Model;
import java.util.ArrayList;

import java.util.UUID; 

public class Client {

	private ArrayList<Container> containers = new ArrayList<Container>();

	public ArrayList<Container> getContainers() {
		return containers;
	}

	public Container getContainer(int index) {

		return containers.get(index);

	}

	public void newContainer(String origin) {

		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID(), false);
		containers.add(newContainer);

	}

	public void newContainer(String origin, String destination) {

		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID(), true);
		newJourney(newContainer,destination);
		containers.add(newContainer);

	}

	public boolean newJourneyChecker(String origin, String destination) {
		if(origin.equals(destination)) return false;
		if(origin.equals(" ")) return false;
		if(destination.equals(" ")) return false;
		return true;
	}

	public boolean newJourney(Container container, String origin, String destination) {

		if(!newJourneyChecker(origin, destination)) return false;
		if(container.isOnJourney()) return false;

		Journey newjourney = new Journey(origin, destination, new Log(new ArrayList<SensorData>()), UUID.randomUUID());
		container.addJourney(newjourney);
		container.setOnJourney(true);

		return true;

	}

	public boolean newJourney(Container container, String destination) {

		if(newJourney(container,container.getOrigin(),destination)) return true;
		return false;

	}

	public boolean endJourney(Container container) {

		if(!container.isOnJourney()) return false;

		container.setOrigin(container.getLatestJourney().getDestination());
		container.setOnJourney(false); 
		return true;

	}

	public void newSensordata(Container container, Float temp) {

		SensorData newSensorData = new SensorData(temp);
		container.getLatestJourney().getLog().addSensorData(newSensorData);
	}

	public Log getLog (Journey journey) {

		return journey.getLog();

	}

	public Log getLatestLog(Container container) {

		return container.getLatestJourney().getLog();

	}

	public SensorData getLatestSensorData(Container container) {

		return container.getLatestJourney().getLog().getLatestSensorData();

	}

	public Journey getLatestJourney(Container container) {

		return container.getLatestJourney();

	}

}
