package application.controller;

import application.model.Container;
import application.model.facades.AdminApp;
import application.model.facades.JourneyApp;
import application.model.tables.*;
import application.popup.AddJourneyPopup;
import application.popup.UpdateInfoPopup;
import application.view.*;

public class ClientController {

	private ClientTable clientModel;	
	private Session sessionModel;
	private ClientView view;
	private AddJourneyPopup journeyPopup;
	private UpdateInfoPopup updateInfoPopup;
	
	public ClientController(ClientTable inventory, Session session) {
		this.clientModel = inventory;
		this.sessionModel = session;
	}

	public void setView(ClientView view) {
		this.view = view;
		this.view.setTableModel(clientModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void logout() {
		ApplicationController app = new ApplicationController();
		app.login();
		view.setVisible(false);
		
	}

	public void addJourney() {
		journeyPopup = new AddJourneyPopup(this);
		journeyPopup.setVisible(true);
		
	}

	public void updateInfo() {
		updateInfoPopup = new UpdateInfoPopup();
		updateInfoPopup.updateInfoPopup();
		updateInfoPopup.setVisible(true);
	}
	
	public void changePage(int containerIndex) {
		String clientName = sessionModel.getUsername();
		Container container = AdminApp.getInstance().getClientContainersByName(clientName).get(containerIndex);
		
		view.setVisible(false);
		sessionModel.getApplication().clientManager2(this.sessionModel);	
	}
	
	public void verifyNewJourney(String origin, String destination, String content) {
		if (origin.equals("") || 
			destination.equals("") || 
			content.equals("")|| 
			origin.equals(destination)) {
			journeyPopup.showError();
		} else {
			JourneyApp.getInstance().newJourney(sessionModel.getUsername(), origin, destination, content);
			clientModel.addJourney();
			journeyPopup.setVisible(false);
			//view.resizeTable();
		}		
	}
}
