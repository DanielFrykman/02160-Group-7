package application.model;

import java.util.ArrayList;

public class Manager<T> {
	private ArrayList<T> list = new ArrayList<T>();
	
	public ArrayList<T> getList() {
		return this.list;
	}
	
	public T getItem(int i) {
		return list.get(i);
	}

	
	
}
