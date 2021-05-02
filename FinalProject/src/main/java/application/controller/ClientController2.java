package application.controller;

import javax.swing.JOptionPane;

import application.model.facades.AdminApp;
import application.model.tables.*;
import application.view.*;

public class ClientController2 {

	private Client2Table clientModel;
	private Session sessionModel;
	private ClientView2 view;	
	AdminApp adminApp = AdminApp.getInstance();

	public ClientController2(Client2Table inventory, Session session) {
		this.clientModel = inventory;
		this.sessionModel = session;
	}

	public void setView(ClientView2 view) {
		this.view = view;
		this.view.setTableModel(clientModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}


	public void goBack() {
		ApplicationController application = new ApplicationController();
		view.setVisible(false);
		application.clientManager(this.sessionModel);	
	}

	public void addViewer() {
		String newViewer = JOptionPane.showInputDialog(view, "Name", "Add Viewer", JOptionPane.CLOSED_OPTION);
//		if (adminApp.checkClient(newViewer)) {
//			adminApp.addViewer(null, newViewer, newViewer);
//		} 

	}

}
