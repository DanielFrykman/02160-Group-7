package application.model.tables;
import javax.swing.table.AbstractTableModel;

import application.model.Container;

public class Client2Table extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	private Container container;

	public Client2Table() {

	}

	public void addData() {
		fireTableDataChanged(); // notify the views that data changed
	}

	// methods below to extend table model

	@Override
	public int getColumnCount() {
		return 5; 
	}

	@Override
	public int getRowCount() {
		return container.getLatestJourney().getLog().getHistory().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getTimeStamp();
		} else if (columnIndex == 1) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getPosition();
		} else if (columnIndex == 2) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getTemp();
		} else if (columnIndex == 3) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getHumidity();
		} else if (columnIndex == 4) {
			return container.getLatestJourney().getLog().getHistory().get(rowIndex).getPressure();
		} 
		return null;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Date";
		} else if (column == 1) {
			return "Position";
		} else if (column == 2) {
			return "Temperature";
		} else if (column == 3) {
			return "Humidity";
		} else if (column == 4) {
			return "Pressure";
		} 
		return null;
	}

	public void setContainer(Container container) {
		this.container=container;
	}
}
