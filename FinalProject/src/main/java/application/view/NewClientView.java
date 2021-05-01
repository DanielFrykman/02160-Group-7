package application.view;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import application.controller.*;
import application.utils.GridBagLayoutUtils;


public class NewClientView extends JFrame {
	private boolean visibility = true;
	private JButton btnsubmit;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtReferencePerson;

	NewClientController controller = new NewClientController(this);

	public NewClientView() throws HeadlessException {
		super();
		initGUI();
	}

	private void initGUI() {
		setTitle("Register new client");
		setSize(400, 400);
		setResizable(false);
		setLayout(new GridBagLayout());

		txtName = new JTextField(15);
		txtEmail = new JTextField(15);
		txtAddress = new JTextField(15);
		txtReferencePerson = new JTextField(15);
		btnsubmit = new JButton("Submit");

		txtName.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					controller.submit(txtName.getText(), txtAddress.getText(), txtReferencePerson.getText(), txtEmail.getText());
				}			
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});


		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.submit(txtName.getText(), txtAddress.getText(), txtReferencePerson.getText(), txtEmail.getText());
			}
		});

		add(new JLabel("Company name:"), GridBagLayoutUtils.constraint(0, 0, 5));
		add(txtName, GridBagLayoutUtils.constraint(1, 0, 5));
		add(new JLabel("Email:"), GridBagLayoutUtils.constraint(0, 1, 5));
		add(txtEmail, GridBagLayoutUtils.constraint(1, 1, 5));
		add(new JLabel("Address:"), GridBagLayoutUtils.constraint(0, 2, 5));
		add(txtAddress, GridBagLayoutUtils.constraint(1, 2, 5));
		add(new JLabel("Refrence person:"), GridBagLayoutUtils.constraint(0, 3, 5));
		add(txtReferencePerson, GridBagLayoutUtils.constraint(1, 3, 5));
		add(btnsubmit, GridBagLayoutUtils.constraint(1, 4, 5));

		pack();
		setLocationRelativeTo(null);
		setVisible(visibility);
	}

	public void newClient() {
		initGUI();
	}

}
