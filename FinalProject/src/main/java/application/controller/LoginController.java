package application.controller;

import application.model.*;
import application.model.facades.*;
import application.view.*;

public class LoginController {

	private ApplicationController application;
	private Session session;
	private LoginView view;
	private AdminApp adminApp = AdminApp.getInstance();


	public LoginController(ApplicationController application) {
		this.application = application;
		this.session = new Session();
		this.view = new LoginView(this);
	}

	public void validateCredentials(String username) {
		for(int i = 0; i<adminApp.getClients().size(); i++) {
			if(username.equals(adminApp.getClient(i).getName())) {
				session.setUser(adminApp.getClient(i)); 
				view.setVisible(false);
				application.manageInventory(session);
			}
		}
		if(username.equals("admin")) {
			session.setAdmin();
			view.setVisible(false);
			application.manageInventory(session);

		} else {
			view.showError();
		}
	}

	public void display() {
		view.setVisible(true);
	}
}
