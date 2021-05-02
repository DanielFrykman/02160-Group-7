package application.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class LogisticCompanyContainerManager extends Manager<Container> {
	
	// --- singleton---------------
	private static LogisticCompanyContainerManager instance;
	private LogisticCompanyContainerManager() {}

	public static LogisticCompanyContainerManager getInstance() {
		if(instance== null) {
			instance= new LogisticCompanyContainerManager();
		}
		return instance;
	}
	// --- singleton---------------
	
//	private ArrayList<Container> containers = new ArrayList<Container>();
//
//	public ArrayList<Container> getContainers() {
//		return containers;
//	}
	
	private void createContainer(String origin) {
		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID(), false);
		getList().add(newContainer);
	}

	public Container getContainerByOrigin(String origin) {
		for(int i = 0; i<getList().size(); i++) {
			if(!getList().get(i).isOnJourney()) {
				if(getList().get(i).getOrigin().equals(origin)) {
					return getList().get(i);
				}
			}
		}
		createContainer(origin);
		return getContainerByOrigin(origin);
	}
	
	public void newSensordata(Container container, Float temp, String position, String humidity, String pressure) {
		SensorData newSensorData = new SensorData(temp, position, humidity, new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()),pressure);
		container.getLatestJourney().getLog().addSensorData(newSensorData);
	}
	public void newSensordata(Container container, Float temp, String position, String humidity) {
		SensorData newSensorData = new SensorData(temp, position, humidity, new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
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

