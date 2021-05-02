package application.model.facades;

import application.model.*;

public class DataApp {

	private static DataApp instance;
	private DataApp() {}

	public static DataApp getInstance() {
		if(instance== null) {
			instance= new DataApp();
		}
		return instance;
	}
	
	LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();

	public void newSensorDataAll(Container container, Float temp, String position, String humidity) {
		containerManager.newSensordata(container, temp, position, humidity);
	}
	
	public void newSensorDataAll(Container container, Float temp, String position, String humidity, String pressure) {
		containerManager.newSensordata(container, temp, position, humidity, pressure);
	}

	public void newSensorDataTemp(Container container, Float temp) {
		newSensorDataAll(container, temp, null, null);
	}

	public void newSensorDataPosition(Container container, String position) {
		newSensorDataAll(container, null, position, null);
	}

	public void newSensorDataHumidity(Container container, String humidity) {
		newSensorDataAll(container, null, null, humidity);
	}

	public void newSensorDataTempPosition(Container container, Float temp, String position) {
		newSensorDataAll(container, temp, position, null);
	}

	public void newSensorDataTempHumidity(Container container, Float temp, String humidity) {
		newSensorDataAll(container, temp, null, humidity);
	}

	public void newSensorDataPositionHumidity(Container container, String position, String humidity) {
		newSensorDataAll(container, null, position, humidity);
	}
	
	public void newSensorDataPressure(Container container, String pressure) {
		newSensorDataAll(container, null, null, null, pressure);
	}

	public Log getLog(Journey journey) {
		return journey.getLog();
	}

	public Log getLatestLog(Container container) {
		return containerManager.getLatestLog(container);
	}

	public SensorData getLatestSensorData(Container container) {
		return containerManager.getLatestSensorData(container);
	}
	
}
