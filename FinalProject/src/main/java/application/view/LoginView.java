package application.view;

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

import application.controller.LoginController;
import application.utils.GridBagLayoutUtils;

public class LoginView extends JFrame {


	private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnLogin;
	private JTextField txtLogin;
	private LoginController controller;

	public LoginView(LoginController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		setPreferredSize(new Dimension(800, 600));
		setLayout(new GridBagLayout());
		
		txtLogin = new JTextField(15);
		btnLogin = new JButton("Login");
		txtLogin.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	controller.validateCredentials(txtLogin.getText());
			     }			
			}

			@Override
			public void keyTyped(KeyEvent e) {
						
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.validateCredentials(txtLogin.getText());
			}
			
		});
		
		
		add(new JLabel("Username"), GridBagLayoutUtils.constraint(1, 0, 5,"left"));
		add(txtLogin, GridBagLayoutUtils.constraint(1, 1, 5));
		add(btnLogin, GridBagLayoutUtils.constraint(1, 2, 5));
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "This username does not exist in our system", "Login error", JOptionPane.ERROR_MESSAGE);
	}
}
