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

public class FindJourneyPopup extends JFrame {

	private static final long serialVersionUID = 989075482041187452L;
	private AdminController controller;

	public FindJourneyPopup(AdminController controller) {
		this.controller = controller;
		initGUI();

	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Search containers");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel nameLabel = new JLabel("Company name");
		JLabel contentLabel = new JLabel("Content");
		JTextField nameTxt = new JTextField(15);
		JTextField contentTxt = new JTextField(15);
		JButton btnSearch = new JButton("Search");

		contentTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.changeTable(nameTxt.getText());
				
			}

		});

		add(nameLabel, GridBagLayoutUtils.constraint(1, 0, 5, "left"));
		add(nameTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(contentLabel, GridBagLayoutUtils.constraint(1, 2, 5, "left"));
		add(contentTxt, GridBagLayoutUtils.constraint(1, 3, 5));
		add(btnSearch, GridBagLayoutUtils.constraint(1, 4, 5));

		pack();
		setLocationRelativeTo(null);

	}
	public void showError() {
		JOptionPane.showMessageDialog(this, "Fill in all text fields to create a client", "Register client error", JOptionPane.ERROR_MESSAGE);
	}

}
