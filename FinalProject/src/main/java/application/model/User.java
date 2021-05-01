package application.model;

public abstract class User {

	@SuppressWarnings("unused")
	private boolean isAdmin;
	protected String name;
	
	public User(boolean isAdmin, String name) {
		super();
		this.isAdmin = isAdmin;
		this.name = name;
	}

	public abstract void setName(String name);
	
	public abstract String getName();

	public abstract boolean isAdmin();
	
}
