package application.model.facades;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import application.model.*;

public class AdminApp extends AbstractTableModel {


	private static AdminApp instance;
	private AdminApp() {}

	public static AdminApp getInstance() {
		if(instance== null) {
			instance= new AdminApp();
		}
		return instance;
	}

	LogisticCompanyClientManager admin = LogisticCompanyClientManager.getInstance();
	LogisticCompanyJourneyManager journeyManager = LogisticCompanyJourneyManager.getInstance();
	LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();
	
	public LogisticCompanyClientManager getAdmin() {
		return admin;
	}

	public void createClient(String clientName, String address, String referencePerson, String email) {
		admin.newClient(clientName, address, referencePerson, email);
		fireTableDataChanged();
	}

	public Client searchClientByName(String clintName){
		return admin.getClientByName(clintName);
	}

	public Client searchClientByMail(String email) {
		return  admin.getClientByEmail(email);
	}

	public Client getClient(int index) {
		return admin.getClinets().get(index);
	}

	public ArrayList<Client> getClients(){
		return admin.getClinets();
	}

	public ArrayList<Container> getClientContainersByName(String clientName){
		return searchClientByName(clientName).getClientsContainers();
	}

	public ArrayList<Container> getClientContainersByEmail(String email){
		return searchClientByMail(email).getClientsContainers();
	}

	public void updateClientName(String currentClientName, String newClientName) {
		admin.updateClientName(currentClientName, newClientName);
	}

	public void updateClientAddress(String currentClientName, String address) {
		admin.updateClientAddress(currentClientName, address);
	}

	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		admin.updateClientRefrencePerson(currentClientName, refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		admin.updateClientEmail(currentClientName, email);
	}

	public void deleteClient(int i) {
		ArrayList<Container> clientsContainers = new ArrayList<Container>();
		clientsContainers = admin.getClinets().get(i).getClientsContainers();
		for(int j = 0; j<clientsContainers.size(); j++) {
			journeyManager.endJourney(clientsContainers.get(j));
		}
		admin.getClinets().remove(i);
	}

	public void addViewer(Container container, String owner,String viewer) {
		admin.addViewer(owner, viewer);
		admin.shareContainer(container, viewer);
	}

	public ArrayList<Container> getViewerContainers(String client) {
		return admin.getClientByName(client).getViewerContainers();

	}

	public ArrayList<Container> getAllContainers() {
		return containerManager.getList();
	}

	public Container getContainer(int index) {
		return getAllContainers().get(index);
	}

	public void resetApp() {
		admin.getClinets().clear();
		containerManager.getList().clear();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return getClients().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) return getClient(rowIndex).getName();
		if(columnIndex == 1) return getClient(rowIndex).getEmail();
		if(columnIndex == 2) return getClient(rowIndex).getAddress();
		if(columnIndex == 3) return getClient(rowIndex).getReferencePerson();
		return " ";
	}
	@Override
	public String getColumnName(int column) {
		if(column==0) return "Company name";
		if(column==1) return "Email";
		if(column==2) return "Address";
		if(column==3) return "Reference person";
		return " ";
	}
}

