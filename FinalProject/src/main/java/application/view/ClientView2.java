package application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import application.controller.ClientController2;
import application.model.tables.Session;

public class ClientView2 extends JFrame {

	private static final long serialVersionUID = 989175282041187452L;
	private ClientController2 controller;
	private JTable tblInventory;
	private JLabel lblSession;

	public ClientView2(ClientController2 controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client View 2");
		setPreferredSize(new Dimension(800, 600));

		JButton btnAddViewer = new JButton("Add viewer");
		btnAddViewer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addViewer();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.goBack();
			}
		});

		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnAddViewer);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		toolbar.add(btnBack);
		add(toolbar, BorderLayout.NORTH);

		// table
		tblInventory = new JTable();
		tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
		
			}
		});
		tblInventory.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		add(new JScrollPane(tblInventory), BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
	}



	public void setTableModel(TableModel model) {
		tblInventory.setModel(model);

	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + "Client" + ")</i></html>");
	}

}
