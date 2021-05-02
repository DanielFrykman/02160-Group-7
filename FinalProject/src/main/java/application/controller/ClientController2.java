package application.controller;

import javax.swing.JOptionPane;

import application.model.*;
import application.model.facades.AdminApp;
import application.model.tables.*;
import application.view.*;

public class ClientController2 {

	private Client2Table clientModel;
	private Session sessionModel;
	private ClientView2 view;	
	private Container container;
	AdminApp adminApp = AdminApp.getInstance();

	public ClientController2(Session session) {
		clientModel = new Client2Table();
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
		if (adminApp.checkClient(newViewer) && !sessionModel.getUsername().equals(newViewer)) {
			adminApp.addViewer(container, sessionModel.getUsername(), newViewer);
		} else {
			JOptionPane.showMessageDialog(view, "Client does not exist", "Cannot add viewer", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void removeViewer() {
		adminApp.removeViewer(container, sessionModel.getUsername());
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}



}
