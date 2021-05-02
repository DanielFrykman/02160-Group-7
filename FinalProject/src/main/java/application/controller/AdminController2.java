package application.controller;

import application.model.Container;
import application.model.facades.AdminApp;
import application.model.tables.*;
import application.view.*;

public class AdminController2 {

	private Admin2Table adminModel;
	private Session sessionModel;
	private AdminView2 view;
	private Container container;

	
	public AdminController2(Admin2Table inventory, Session session) {
		this.adminModel = inventory;
		this.sessionModel = session;
	}



	public void setView(AdminView2 view) {
		this.view = view;
		this.view.setTableModel(adminModel);
		this.view.setSession(sessionModel);
	}
	
	public void changePage() {
		view.setVisible(false);
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

}