package application.model.facades;

import application.model.*;

public final class Session {

	private Client client;
	private String role;

	public void setUser(Client client) {
		this.client = client;
		this.role ="Client";
	}
	
	
	public String getRole() {
		return this.role;
	}

	public String getUsername() {
		if (role.equals("Admin")) return "Admin";
		return client.getName();
	}

	public void setAdmin() {
		this.role = "Admin";
		
	}
}
