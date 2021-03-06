package application.controller;

import application.model.Container;
import application.model.tables.*;
import application.view.*;


public class ApplicationController {

	private LoginController loginController;

	public void adminManager(Session session) {
		
		AdminView adminView = new AdminView(session.getAdminController());
		session.getAdminController().setView(adminView);
		session.getAdminController().display();
	}
	
	public void adminManager2(Session session, Container container) {
		session.getAdminController2().setContainer(container);
		AdminView2 adminView2 = new AdminView2(session.getAdminController2());
		session.getAdminController2().setView(adminView2);
		session.getAdminController2().display();
	}
	
	public void clientManager(Session session) {
		ClientView clientView = new ClientView(session.getClientController());
		session.getClientController().setView(clientView);
		session.getClientController().display();
	}
	
	public void clientManager2(Session session, Container container) {
		session.getClientController2().setContainer(container);
		ClientView2 clientView2 = new ClientView2(session.getClientController2());
		session.getClientController2().setView(clientView2);
		session.getClientController2().display();
	}
	
	
	public void login() {		
		loginController = new LoginController(this);
		loginController.display();
	}
	
	public void logout() {	
		this.loginController.display();
	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}
}
