package application.model;

import java.util.ArrayList;
import java.util.UUID;


public class LogisticCompanyClientManager extends Manager<Client> {
	
	// --- singleton---------------
	private static LogisticCompanyClientManager instance;
	private LogisticCompanyClientManager() {}

	public static LogisticCompanyClientManager getInstance() {
		if(instance== null) {
			instance= new LogisticCompanyClientManager();
		}
		return instance;
	}
	// --- singleton---------------
	
//	private ArrayList<Client> clients = new ArrayList<Client>();

	public void newClient(String clientName, String address, String referencePerson, String email) {
		Client client = new Client(clientName, address, referencePerson, email, UUID.randomUUID());
		getList().add(client);
	}
	
	public ArrayList<Client> getClinets() {
		return getList();
	}

	public Client getClientByName(String client) {
		Client placeholder = null;

		for(int i = 0; i < getList().size(); i++) {
			if(getList().get(i).getName().equals(client)) placeholder = getList().get(i);
		}
		return placeholder;
	}

	public Client getClientByEmail(String email) {
		Client placeholder = null;

		for(int i = 0; i < getList().size(); i++) {
			if(getList().get(i).getEmail().equals(email)) placeholder = getList().get(i);
		}
		return placeholder;
	}

	public boolean addContainerToClient(String clientName, Container container) {
		Client client = null;
		for(int i = 0; i<getList().size(); i++) {
			if(getList().get(i).getName().equals(clientName)) client = getList().get(i);
		}
		if(client==null) return false;
		client.addContainer(container);
		return true;
	}

	public void deleteClient(int i) {
		getList().remove(i);
	}

	public void updateClientName(String currentClientName, String newClientName) {
		getClientByName(currentClientName).setName(newClientName);
	}

	public void updateClientAddress(String currentClientName, String address) {
		getClientByName(currentClientName).setAddress(address);
	}

	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		getClientByName(currentClientName).setReferencePerson(refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		getClientByName(currentClientName).setEmail(email);
	}

	public void addViewer(String owner, String viewer) {
		getClientByName(owner).addViewer(getClientByName(viewer));
	}
	
	public void shareContainer(Container container, String viewer) {
		getClientByName(viewer).addViewerContainers(container);
	}

}
