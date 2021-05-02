package application.controller;

import application.model.Container;
import application.model.facades.AdminApp;
import application.model.tables.*;
import application.popup.*;
import application.view.*;

public class AdminController {

	private AdminTable adminModel;
	private Session sessionModel;
	private AdminView view;
	private RegisterClientPopup clientPopup;
	private FindJourneyPopup journeyPopup;
	
	AdminApp adminApp = AdminApp.getInstance();
	
	public AdminController(AdminTable inventory, Session session) {
		this.adminModel = inventory;
		this.sessionModel = session;
	}

	public void registerClient() {
		clientPopup = new RegisterClientPopup(this);
		clientPopup.setVisible(true);
	}
	
	public void searchJourney() {
		journeyPopup = new FindJourneyPopup(this);
		journeyPopup.setVisible(true);
	}

	public void setView(AdminView view) {
		this.view = view;
		this.view.setTableModel(adminModel);
		this.view.setSession(sessionModel);
	}
	
	public void changePage(Container container) {
		view.setVisible(false);
		sessionModel.getApplication().adminManager2(this.sessionModel, container);	
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void changeTable(String name) {
		ClientTable table = new ClientTable(sessionModel);	
		table.overrideClientName(name);
		table.fireTableDataChanged();
		this.view.setTableModel(table);
		table.fireTableStructureChanged();
		journeyPopup.setVisible(false);
	}

	public void logout() {
		ApplicationController app = new ApplicationController();
		app.login();
		view.setVisible(false);		
	}

	public void verifyNewClient(String name, String address, String referencePerson, String email) {
		if (name.equals("") || 
				address.equals("") || 
				referencePerson.equals("")|| 
				email.equals("")) {
				clientPopup.showError();
			} else 
				AdminApp.getInstance().createClient(name, address, referencePerson, email);				
				clientPopup.setVisible(false);
	}

	public Container getContainer(int index) {
		if(index<0) return adminApp.getContainer(index+1); //why is this necessary ¯\_(ツ)_/¯ 
		return adminApp.getContainer(index);
	}
}