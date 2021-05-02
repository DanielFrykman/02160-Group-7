package application.controller;


import application.model.facades.AdminApp;
import application.model.tables.*;
import application.view.LoginView;

public class LoginController {

	private ApplicationController application;
	private Session session;
	private LoginView view;

	public LoginController(ApplicationController application) {
		this.application = application;
		this.session = new Session(application);
		this.view = new LoginView(this);
	}

	public void validateCredentials(String username) {
		User user = new User();
		user.setUsername(username);

		if (username.equals("admin")) {
			session.setUser(user);
			view.setVisible(false);
			application.adminManager(session);

		} else if (AdminApp.getInstance().checkClient(username)) {
			session.setUser(user);
			view.setVisible(false);
			application.clientManager(session);

		} else {
			view.showError();
		}
	}

	public void display() {
		view.setVisible(true);
	}
}
