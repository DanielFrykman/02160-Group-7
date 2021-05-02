package application.model.facades;

import java.util.ArrayList;

import application.model.*;

public class AdminApp {

	private static AdminApp instance;
	private AdminApp() {}

	public static AdminApp getInstance() {
		if(instance== null) {
			instance= new AdminApp();
		}
		return instance;
	}

	LogisticCompanyClientManager clientManager = LogisticCompanyClientManager.getInstance();
	LogisticCompanyJourneyManager journeyManager = LogisticCompanyJourneyManager.getInstance();
	LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();

	public LogisticCompanyClientManager getAdmin() {
		return clientManager;
	}

	public void createClient(String clientName, String address, String referencePerson, String email) {
		clientManager.newClient(clientName, address, referencePerson, email);
	}

	public Client searchClientByName(String clientName){
		return clientManager.getClientByName(clientName);
	}

	public Client searchClientByMail(String email) {
		return  clientManager.getClientByEmail(email);
	}

	public Client getClient(int index) {
		return clientManager.getClinets().get(index);
	}

	public ArrayList<Client> getClients(){
		return clientManager.getClinets();
	}

	public ArrayList<Container> getClientContainersByName(String clientName){
		return searchClientByName(clientName).getClientsContainers();
	}

	public ArrayList<Container> getClientContainersByEmail(String email){
		return searchClientByMail(email).getClientsContainers();
	}

	public void updateClientName(String currentClientName, String newClientName) {
		clientManager.updateClientName(currentClientName, newClientName);
	}

	public void updateClientAddress(String currentClientName, String address) {
		clientManager.updateClientAddress(currentClientName, address);
	}

	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		clientManager.updateClientRefrencePerson(currentClientName, refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		clientManager.updateClientEmail(currentClientName, email);
	}

	public void deleteClient(int i) {
		ArrayList<Container> clientsContainers = new ArrayList<Container>();
		clientsContainers = clientManager.getClinets().get(i).getClientsContainers();
		for(int j = 0; j<clientsContainers.size(); j++) {
			journeyManager.endJourney(clientsContainers.get(j));
		}
		clientManager.getClinets().remove(i);
	}

	public void addViewer(Container container, String owner, String viewer) {
		clientManager.addViewer(owner, viewer);
		clientManager.shareContainer(container, viewer);
	}

	public boolean checkClient(String name) {
		for(int i = 0; i < getClients().size(); i++) {
			if(getClient(i).getName().equals(name)) return true;
		}
		return false;
	}

	public ArrayList<Container> getViewerContainers(String client) {
		return clientManager.getClientByName(client).getViewerContainers();

	}

	public Client getViewerOfContainer(Container container) {
		Client viewer = null;
		for(int i = 0; i < getClients().size(); i++) {
			ArrayList<Container> containers = clientManager.getClinets().get(i).getViewerContainers();
			for( int j = 0; j < containers.size(); i++) {
				if(containers.get(j).equals(container)) viewer = getClients().get(i);
			}
		}
		return viewer;
	}

	public ArrayList<Container> getAllContainers() {
		return containerManager.getList();
	}

	public Container getContainer(int index) {
		return getAllContainers().get(index);
	}

	public void resetApp() {
		clientManager.getClinets().clear();
		containerManager.getList().clear();
	}
}

