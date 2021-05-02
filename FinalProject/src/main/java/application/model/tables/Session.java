package application.model.tables;

import application.controller.*;


public final class Session {

	private AdminController adminController = new AdminController(new AdminTable(), this);
	private AdminController2 adminController2 = new AdminController2(new Admin2Table(), this);
	private ClientController clientController = new ClientController(new ClientTable(this), this);
	private ClientController2 clientController2 = new ClientController2(new Client2Table(), this);
	private ApplicationController application;
	
	
	private User user;
	
	public Session(ApplicationController application) {
		this.application = application;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return user.getUsername();
	}

	public AdminController getAdminController() {
		return adminController;
	}
	
	public AdminController2 getAdminController2() {
		return adminController2;
	}

	public ClientController getClientController() {
		return clientController;
	}
	
	public ClientController2 getClientController2() {
		return clientController2;
	}

	public ApplicationController getApplication() {
		return application;
	}

	public void setUsername(String name) {
		this.user.setUsername(name);
		
	}
	
}
