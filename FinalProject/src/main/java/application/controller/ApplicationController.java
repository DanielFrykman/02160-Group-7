package application.controller;

import application.model.Session;
import application.view.AdminView;

public class ApplicationController {
	
	private LoginController loginController;
	private AdminController inventoryController;
	
	public void manageInventory(Session session) {
		inventoryController = new AdminController(session);

		AdminView invView = new AdminView(inventoryController);
		inventoryController.setView(invView);
		inventoryController.display();
	}
	
	public void login() {
		loginController = new LoginController(this);
		loginController.display();
	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}
}
