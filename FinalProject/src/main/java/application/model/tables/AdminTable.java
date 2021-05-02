package application.model.tables;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import application.model.facades.AdminApp;
import application.model.*;

public class AdminTable extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;

	AdminApp adminApp = AdminApp.getInstance();
	ArrayList<Container> containers = adminApp.getAllContainers();

	public void addProduct(String name) {

		fireTableDataChanged(); // notify the views that data changed
	}

	public void removeProduct(String name) {
		//		if (products.containsKey(name)) {
		//			int quantity = products.get(name) - 1;
		//			if (quantity == 0) {
		//				products.remove(name);
		//			} else {
		//				products.put(name,  quantity);
		//			}
		//		}
		fireTableDataChanged(); // notify the views that data changed
	}


	// methods below to extend table model

	@Override
	public int getColumnCount() {
		return 6; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return containers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return containers.get(rowIndex).getId().toString();
		} else if (columnIndex == 1) {
			return containers.get(rowIndex).getLatestJourney().getOrigin();
		} else if (columnIndex == 2) {
			return containers.get(rowIndex).getLatestJourney().getDestination();
		} else if (columnIndex == 3) {
			return containers.get(rowIndex).getLatestJourney().getContent();
		} else if (columnIndex == 4) {
			return containers.get(rowIndex).getLatestJourney().getJourneyID().toString();
		} else if (columnIndex == 5) {
			if(containers.get(rowIndex).isOnJourney()) return "Journey ongoing";
			return "Container in port";
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Container ID";
		} else if (column == 1) {
			return "Origin"; 
		} else if (column == 2) {
			return "Destination"; 
		} else if (column == 3) {
			return "Content"; 
		} else if (column == 4) {
			return "Journey ID";
		} else if (column == 5) {
			return "Travel status";
		}	
		return null;
	}
}
