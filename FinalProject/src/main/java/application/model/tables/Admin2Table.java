package application.model.tables;


import javax.swing.table.AbstractTableModel;

import application.model.Container;
import application.model.facades.AdminApp;
import application.model.facades.JourneyApp;

public class Admin2Table extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;

	AdminApp adminApp = AdminApp.getInstance();
	Container container; 
	JourneyApp journeyApp = JourneyApp.getInstance();

	public void setContainer(Container container) {
		this.container = container;
	}

	public void addProduct(String name) {
		fireTableDataChanged(); // notify the views that data changed
	}

	public void removeProduct(String name) {
		fireTableDataChanged(); // notify the views that data changed
	}


	// methods below to extend table model

	@Override
	public int getColumnCount() {
		return 7; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return journeyApp.getLatestJourney(container).getLog().getHistory().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return container.getLatestJourney().getJourneyID().toString();
		} else if (columnIndex == 1) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getTimeStamp();
		} else if (columnIndex == 2) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getPosition();
		} else if (columnIndex == 3) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getTemp();
		} else if (columnIndex == 4) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getHumidity();
		} else if (columnIndex == 5) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getPressure();
		} else if (columnIndex == 6) {
			if(container.isOnJourney()) return "Journey ongoing";
			return "In port";
		}

		return null;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Journey ID";
		} else if (column == 1) {
			return "Date"; 
		} else if (column == 2) {
			return "Position"; 
		} else if (column == 3) {
			return "Temperature"; 
		} else if (column == 4) {
			return "Humidity";
		} else if (column == 5) {
			return "Pressure";
		} else if (column == 6) {
			return "Journey status";
		}		

		return null;
	}
}