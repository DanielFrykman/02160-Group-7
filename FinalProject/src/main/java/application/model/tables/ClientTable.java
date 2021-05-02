package application.model.tables;
import javax.swing.table.AbstractTableModel;

import application.model.facades.AdminApp;
import application.model.facades.JourneyApp;



public class ClientTable extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	Session session;
	
	AdminApp adminApp = AdminApp.getInstance();
	JourneyApp journeyApp = JourneyApp.getInstance();
	
	public ClientTable(Session session) {
		this.session = session;
	}
	
	public void addJourney() {	
		fireTableDataChanged(); // notify the views that data changed
	}
	
	// methods below to extend table model
	
	@Override
	public int getColumnCount() {
		return 5; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return adminApp.searchClientByName(session.getUsername()).getClientsContainers().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String clientname = session.getUsername();
		if (columnIndex == 0) {
			return adminApp.getViewerOfContainer(adminApp.getClientContainersByName(clientname).get(columnIndex));
		} else if (columnIndex == 1) {
			return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getOrigin();
		} else if (columnIndex == 2) {
			return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getDestination();
		} else if (columnIndex == 3) {
			return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getContent();
		} else if (columnIndex == 4) {
			return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getJourneyID().toString();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {

		if (column == 0) {
			return "Viewer";
		} else if (column == 1) {
			return "Origin";
		} else if (column == 2) {
			return "Destination";
		} else if (column == 3) {
			return "Content";
		} else if (column == 4) {
			return "Journey ID";
		} 
		return null;
	}
}
