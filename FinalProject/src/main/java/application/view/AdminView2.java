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
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import application.controller.AdminController2;
import application.model.tables.Session;

public class AdminView2 extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private AdminController2 controller;
	private JTable tblInventory;
	private JLabel lblSession;

	public AdminView2(AdminController2 controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home");
		setPreferredSize(new Dimension(800, 600));

		// buttons
		JButton btnAddData = new JButton("Add data");
		btnAddData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addDataPopup();		
			}		
		});
				
				
		JButton btnRemoveData = new JButton("Remove data");
		btnRemoveData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}		
		});
		
		JButton btnEndJourney = new JButton("End journey");
		btnEndJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.endJourney();		
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
		toolbar.add(btnAddData);
		toolbar.add(btnRemoveData);
		toolbar.add(btnEndJourney);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		toolbar.add(btnBack);
		add(toolbar, BorderLayout.NORTH);

		// table
		tblInventory = new JTable();
		tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(tblInventory), BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
	}

	public void setTableModel(TableModel model) {
		tblInventory.setModel(model);
	}


	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + "Admin" + ")</i></html>");
	}
}
