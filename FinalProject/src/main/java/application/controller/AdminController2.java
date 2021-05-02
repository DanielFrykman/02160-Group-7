package application.controller;

import application.model.Container;
import application.model.facades.*;
import application.model.tables.*;
import application.popup.*;
import application.view.*;

public class AdminController2 {

	private Admin2Table adminModel;
	private Session sessionModel;
	private AdminView2 view;
	private Container container;
	private AddDataPopup addDataPopup;
	DataApp dataApp = DataApp.getInstance();
	JourneyApp journeyApp = JourneyApp.getInstance();


	public AdminController2(Admin2Table inventory, Session session) {
		this.adminModel = inventory;
		this.sessionModel = session;
	}

	public boolean checkInput(String input) {
		boolean check = true;
		if(input == null) return false;
		try {
			Float d = Float.parseFloat(input);
		}
		catch(Exception e) {
			check = false;
		}
		return check;
	}

	public void endJourney() {
		journeyApp.endJourney(container, container.getLatestJourney().getOwner().getName());
	}

	public void setView(AdminView2 view) {
		this.view = view;
		adminModel.setContainer(container);
		this.view.setTableModel(adminModel);
		this.view.setSession(sessionModel);
	}

	public void addData(String pos, String temp, String hum, String pres) {
		if(!checkInput(temp)) temp=null;
		
		if(!pos.equals("") && !temp.equals("") && !hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), pos, hum, pres);
		}
		if(pos.equals("") && !temp.equals("") && !hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), null, hum, pres);
		}
		if(!pos.equals("") && temp.equals("") && !hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, null, pos, hum, pres);
		}
		if(!pos.equals("") && !temp.equals("") && hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), pos, null, pres);
		}
		if(!pos.equals("") && !temp.equals("") && !hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), pos, hum, null);
		}

		if(pos.equals("") && temp.equals("") && !hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, null, null, hum, pres);
		}
		if(pos.equals("") && !temp.equals("") && hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), null, null, pres);
		}
		if(pos.equals("") && !temp.equals("") && !hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), null, hum, null);
		}
		if(!pos.equals("") && temp.equals("") && hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, null, pos, null, pres);
		}
		if(!pos.equals("") && temp.equals("") && !hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, null, pos, hum, null);
		}
		if(!pos.equals("") && !temp.equals("") && hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), pos, null, null);
		}

		if(!pos.equals("") && temp.equals("") && hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, null, pos, null, null);
		}
		if(pos.equals("") && !temp.equals("") && hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, Float.parseFloat(temp), null, null, null);
		}
		if(pos.equals("") && temp.equals("") && !hum.equals("") && pres.equals("")) {
			dataApp.newSensorDataAll(container, null, null, hum, null);
		}
		if(pos.equals("") && temp.equals("") && hum.equals("") && !pres.equals("")) {
			dataApp.newSensorDataAll(container, null, null, null, pres);
		}

		addDataPopup.setVisible(false);
	}

	public void display() {
		view.setVisible(true);
	}

	public void goBack() {
		view.setVisible(false);
		sessionModel.getApplication().adminManager(sessionModel);
	}

	public void setContainer(Container container) {
		this.container = container;

	}

	public Container getContainer() {
		return container;
	}



	public void addDataPopup() {
		addDataPopup = new AddDataPopup(this);
		addDataPopup.setVisible(true);

	}

}