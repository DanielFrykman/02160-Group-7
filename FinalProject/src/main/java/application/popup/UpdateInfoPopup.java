package application.popup;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;


//import application.controller.ClientController;
import application.utils.GridBagLayoutUtils;

public class UpdateInfoPopup extends JFrame {

	private static final long serialVersionUID = 988075482041187452L;
	//private ClientController controller;

	public void updateInfoPopup() {		
	
		initGUI();

	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Update information");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel addressLabel = new JLabel("Address");
		JLabel refPersonLabel = new JLabel("Reference Person");
		JLabel emailLabel = new JLabel("Email address");
		JTextField addressTxt = new JTextField(15);
		JTextField refPersonTxt = new JTextField(15);
		JTextField emailTxt = new JTextField(15);
		JButton btnUpdate = new JButton("Update");

		add(addressLabel, GridBagLayoutUtils.constraint(1, 0, 5,"left"));
		add(addressTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(refPersonLabel, GridBagLayoutUtils.constraint(1, 2, 5,"left"));       
		add(refPersonTxt, GridBagLayoutUtils.constraint(1, 3, 5));      
		add(emailLabel, GridBagLayoutUtils.constraint(1, 4, 5,"left"));
		add(emailTxt, GridBagLayoutUtils.constraint(1, 5, 5)); 
		add(btnUpdate, GridBagLayoutUtils.constraint(1, 6, 5)); 

		pack();
		setLocationRelativeTo(null);
	
	}

}
