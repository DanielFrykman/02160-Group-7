package application.model.tables;

import javax.swing.table.AbstractTableModel;
import application.model.*;
import application.model.facades.AdminApp;
import application.model.facades.JourneyApp;


public class ClientTable extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	Session session;
	String clientname = null;
	int rows = 0;

	AdminApp adminApp = AdminApp.getInstance();
	JourneyApp journeyApp = JourneyApp.getInstance();

	public ClientTable(Session session) {
		this.session = session;
	}

	public void overrideClientName(String newClient) {
		clientname = newClient;
		rows = adminApp.searchClientByName(clientname).getClientsContainers().size() + adminApp.getViewerContainers(clientname).size();
	}
	public void addJourney() {	
		fireTableDataChanged(); // notify the views that data changed
	}

	@Override
	public int getColumnCount() {
		return 6; 
	}

	@Override
	public int getRowCount() {
		if(rows == 0) return adminApp.searchClientByName(session.getUsername()).getClientsContainers().size() + adminApp.getViewerContainers(session.getUsername()).size();
		return rows;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(clientname==null) clientname = session.getUsername();
		if(rowIndex < adminApp.getClientContainersByName(clientname).size()) {
			if (columnIndex == 0) {
				return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getOwner().getName();
			} else if (columnIndex == 1) {
				if(adminApp.getContainer(rowIndex).getLatestJourney().getViewer() instanceof Client) return adminApp.getContainer(rowIndex).getLatestJourney().getViewer().getName();
			} else if (columnIndex == 2) {
				return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getOrigin();
			} else if (columnIndex == 3) {
				return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getDestination();
			} else if (columnIndex == 4) {
				return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getContent();
			} else if (columnIndex == 5) {
				return journeyApp.getLatestJourneyByClientName(clientname, rowIndex).getJourneyID().toString();
			}
			return null;
		}
		else  {
			if (columnIndex == 0) {
				return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getOwner().getName();
			} else if (columnIndex == 1) {
				if(adminApp.getContainer(rowIndex).getLatestJourney().getViewer() instanceof Client) return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getViewer().getName();
			} else if (columnIndex == 2) {
				return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getOrigin();
			} else if (columnIndex == 3) {
				return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getDestination();
			} else if (columnIndex == 4) {
				return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getContent();
			} else if (columnIndex == 5) {
				return adminApp.getViewerContainers(clientname).get(rowIndex).getLatestJourney().getJourneyID().toString();
			}
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {

		if (column == 0) {
			return "Owner";
		} else if (column == 1) {
			return "Viewer";
		} else if (column == 2) {
			return "Origin";
		} else if (column == 3) {
			return "Destination";
		} else if (column == 4) {
			return "Content";
		} else if (column == 5) {
			return "Journey ID";
		} 
		return null;
	}
}
