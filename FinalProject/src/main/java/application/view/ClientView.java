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

import application.controller.ClientController;
import application.model.Container;
import application.model.facades.AdminApp;
import application.model.tables.Session;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private ClientController controller;
	private JTable tblInventory;
	private JLabel lblSession;

	public ClientView(ClientController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home");
		setPreferredSize(new Dimension(800, 600));

		// buttons
		JButton btnRegisterJourney = new JButton("Register new journey");
		btnRegisterJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addJourney();
			}
		});
		JButton btnUpdateInfo = new JButton("Update information");
		btnUpdateInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateInfoPopup();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}

		});

		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnRegisterJourney);
		toolbar.add(btnUpdateInfo);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		toolbar.add(btnLogout);
		add(toolbar, BorderLayout.NORTH);

		// table
		tblInventory = new JTable();
		tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Container container = controller.getContainer(tblInventory.getSelectedRow());
				controller.changePage(container);
			}
		});
		
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
