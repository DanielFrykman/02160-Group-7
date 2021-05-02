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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import application.controller.AdminController;
import application.utils.GridBagLayoutUtils;

public class RegisterClientPopup extends JFrame {

	private static final long serialVersionUID = 989075482041187452L;
	private AdminController controller;

	public RegisterClientPopup(AdminController controller) {
		this.controller = controller;
		initGUI();

	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Register new client");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel nameLabel = new JLabel("Company name");
		JLabel addressLabel = new JLabel("Company Address");
		JLabel referenceLabel = new JLabel("Reference person");
		JLabel emailLabel = new JLabel("Email address");
		JTextField nameTxt = new JTextField(15);
		JTextField addressTxt = new JTextField(15);
		JTextField referenceTxt = new JTextField(15);
		JTextField emailTxt = new JTextField(15);
		JButton btnRegister = new JButton("Register");

		emailTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					controller.verifyNewClient(nameTxt.getText(), addressTxt.getText(), referenceTxt.getText(), emailTxt.getText());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.verifyNewClient(nameTxt.getText(), addressTxt.getText(), referenceTxt.getText(), emailTxt.getText());
			}

		});

		add(nameLabel, GridBagLayoutUtils.constraint(1, 0, 5, "left"));
		add(nameTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(addressLabel, GridBagLayoutUtils.constraint(1, 2, 5, "left"));
		add(addressTxt, GridBagLayoutUtils.constraint(1, 3, 5));
		add(referenceLabel, GridBagLayoutUtils.constraint(1, 4, 5, "left"));
		add(referenceTxt, GridBagLayoutUtils.constraint(1, 5, 5));
		add(emailLabel, GridBagLayoutUtils.constraint(1, 6, 5, "left"));
		add(emailTxt, GridBagLayoutUtils.constraint(1, 7, 5));
		add(btnRegister, GridBagLayoutUtils.constraint(1, 8, 5));

		pack();
		setLocationRelativeTo(null);

	}
	public void showError() {
		JOptionPane.showMessageDialog(this, "Fill in all text fields to create a client", "Register client error", JOptionPane.ERROR_MESSAGE);
	}

}
