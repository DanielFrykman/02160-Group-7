package application.controller;



import application.model.facades.AdminApp;
import application.model.tables.*;
import application.popup.RegisterClientPopup;
import application.view.*;

public class AdminController {

	private AdminTable adminModel;
	private Session sessionModel;
	private AdminView view;
	private RegisterClientPopup clientPopup;
	
	
	public AdminController(AdminTable inventory, Session session) {
		this.adminModel = inventory;
		this.sessionModel = session;
	}

	public void registerClient() {
		clientPopup = new RegisterClientPopup(this);
		clientPopup.setVisible(true);
	}

	public void deleteItem(int selectedRow) {
		if (selectedRow >= 0) {
			String productName = (String) adminModel.getValueAt(selectedRow, 0);
			adminModel.removeProduct(productName);
		}
	}

	public void setView(AdminView view) {
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

}
