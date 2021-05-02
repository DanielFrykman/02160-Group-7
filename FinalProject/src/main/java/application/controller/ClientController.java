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
	private String clientName;

	
	AdminApp adminApp = AdminApp.getInstance();
	public ClientController(ClientTable inventory, Session session) {
		this.clientModel = new ClientTable(session);
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
	
	public Container getContainer(int index) {
		if(index<0) return adminApp.getContainer(index+1); //why is this necessary ¯\_(ツ)_/¯ 
		return adminApp.getContainer(index);
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

	public void updateInfoPopup() {
		updateInfoPopup = new UpdateInfoPopup(this);
		updateInfoPopup.setVisible(true);
	}

	public void updateClientInfo(String name, String address, String refrencePerson, String email) {
		clientName = sessionModel.getUsername();
	
		if(!address.equals("")) adminApp.updateClientAddress(clientName, address);
		if(!refrencePerson.equals("")) adminApp.updateClientRefrencePerson(clientName, refrencePerson);
		if(!email.equals("")) adminApp.updateClientEmail(clientName, email);
		if(!name.equals("")) {
			adminApp.updateClientName(clientName, name);
			sessionModel.setUsername(name);
		}
		view.setSession(sessionModel);
		updateInfoPopup.setVisible(false);
	}

	public void changePage(Container container) {
		clientName = sessionModel.getUsername();
		view.setVisible(false);
		sessionModel.getApplication().clientManager2(this.sessionModel, container);	
	}

	public void verifyNewJourney(String origin, String destination, String content) {
		if (origin.equals("") || 
				destination.equals("") || 
				content.equals("")|| 
				origin.equals(destination)) {
			journeyPopup.showError();
		} else {
			JourneyApp.getInstance().newJourney(sessionModel.getUsername(), origin, destination, content);
			journeyPopup.setVisible(false);
			clientModel.addJourney();
			
		}		
	}
}
