package application.popup;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import application.controller.ClientController;
//import application.controller.ClientController;
import application.utils.GridBagLayoutUtils;

public class UpdateInfoPopup extends JFrame {

	private static final long serialVersionUID = 988075482041187452L;
	private ClientController controller;

	public UpdateInfoPopup(ClientController clientController) {
		this.controller = clientController;
		initGUI();
	}

	public void updateInfoPopup(ClientController controller) {		
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Update information");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel nameLabel = new JLabel("Company name");
		JLabel addressLabel = new JLabel("Address");
		JLabel refPersonLabel = new JLabel("Reference Person");
		JLabel emailLabel = new JLabel("Email address");
		JTextField nameTxt = new JTextField(15);
		JTextField addressTxt = new JTextField(15);
		JTextField refPersonTxt = new JTextField(15);
		JTextField emailTxt = new JTextField(15);
		JButton btnUpdate = new JButton("Update");
		
		emailTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					controller.updateClientInfo(nameTxt.getText(), addressTxt.getText(), refPersonTxt.getText(), emailTxt.getText());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateClientInfo(nameTxt.getText(), addressTxt.getText(),refPersonTxt.getText(), emailTxt.getText());
			}

		});

		add(nameLabel, GridBagLayoutUtils.constraint(1, 0, 5,"left"));
		add(nameTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(addressLabel, GridBagLayoutUtils.constraint(1, 2, 5,"left"));
		add(addressTxt, GridBagLayoutUtils.constraint(1, 3, 5));
		add(refPersonLabel, GridBagLayoutUtils.constraint(1, 4, 5,"left"));       
		add(refPersonTxt, GridBagLayoutUtils.constraint(1, 5, 5));      
		add(emailLabel, GridBagLayoutUtils.constraint(1, 6, 5,"left"));
		add(emailTxt, GridBagLayoutUtils.constraint(1, 7, 5)); 
		add(btnUpdate, GridBagLayoutUtils.constraint(1, 8, 5)); 

		pack();
		setLocationRelativeTo(null);
	
	}

}
