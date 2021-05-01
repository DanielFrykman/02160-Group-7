package application.controller;

import application.view.*;
import application.model.facades.*;

public class NewClientController {

	private NewClientView view;
	AdminApp adminApp = AdminApp.getInstance();
	
	public NewClientController(NewClientView view) {
		super();
		this.view = view;
	}

	// TO DO: implient checks
	public void submit(String clientName, String address, String referencePerson, String email) {
		adminApp.createClient(clientName, address, referencePerson, email);
		view.setVisible(false);
		
	}
	
}
