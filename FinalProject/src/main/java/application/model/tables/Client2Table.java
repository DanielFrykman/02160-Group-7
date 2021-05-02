package application.model.tables;
import javax.swing.table.AbstractTableModel;

public class Client2Table extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	private int rowCount;
	
	public Client2Table() {
		
	}
	
	public void addJourney() {
		
		//rowCount++;

		fireTableDataChanged(); // notify the views that data changed
	}
	
	// methods below to extend table model
	
	@Override
	public int getColumnCount() {
		return 6; 
	}

	@Override
	public int getRowCount() {
		return this.rowCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return "something";
		} else if (columnIndex == 1) {
			return "something";
		} else if (columnIndex == 2) {
			return "something";
		} else if (columnIndex == 3) {
			return "something";
		} else if (columnIndex == 4) {
			return "something";
		} else if (columnIndex == 5) {
			return "something";
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Owner";
		} else if (column == 1) {
			return "Viewer";
		} else if (column == 2) {
			return "Journey ID";
		} else if (column == 3) {
			return "Content";
		} else if (column == 4) {
			return "Origin";
		} else if (column == 5) {
			return "Destination";
		} 
		return null;
	}
}
