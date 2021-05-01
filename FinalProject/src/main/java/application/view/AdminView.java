package application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import application.controller.AdminController;
import application.model.facades.*;

public class AdminView extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private AdminController controller;
	private JTable tblInventory;
	private JLabel lblSession;
	private NewClientView newClientView;
	
	public AdminView(AdminController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Manager");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons
		JButton btnRegister = new JButton("Register new client");
	    btnRegister.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						newClientView = new NewClientView(); 
					}
				});
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btnGet = new JButton("Get client information");

		
		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JToolBar toolbar = new JToolBar();
		toolbar.add(btnRegister);
		toolbar.add(btnGet);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		add(toolbar, BorderLayout.NORTH);
		
		// table
		tblInventory = new JTable();
		tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				
//			}
//		});
		add(new JScrollPane(tblInventory), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setTableModel(TableModel model) {
		tblInventory.setModel(AdminApp.getInstance());
		
	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
}
