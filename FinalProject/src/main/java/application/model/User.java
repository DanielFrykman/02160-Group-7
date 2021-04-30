package application.model;

public class User {

	private boolean isAdmin;
	protected String name;
	
	public User(boolean isAdmin, String name) {
		super();
		this.isAdmin = isAdmin;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
