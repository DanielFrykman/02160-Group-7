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

import application.controller.AdminController2;
import application.controller.ClientController;
import application.utils.GridBagLayoutUtils;

public class AddDataPopup extends JFrame {

	private static final long serialVersionUID = 989075482041187452L;
	private AdminController2 controller;

	public AddDataPopup(AdminController2 adminController2) {
		this.controller = adminController2;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add new journey");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel positionLabel = new JLabel("Position");
		JLabel temperatureLabel = new JLabel("Temperature");
		JLabel humidityLabel = new JLabel("Humidity");
		JLabel pressureLabel = new JLabel("Pressure");
		JTextField positionTxt = new JTextField(15);
		JTextField temperatureTxt = new JTextField(15);
		JTextField humidityTxt = new JTextField(15);
		JTextField pressureTxt = new JTextField(15);
		JButton btnAdd = new JButton("Add");

		pressureTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					
					controller.addData(positionTxt.getText(),temperatureTxt.getText(),humidityTxt.getText(),pressureTxt.getText());
				
					
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					controller.addData(positionTxt.getText(), temperatureTxt.getText(), humidityTxt.getText(),
							pressureTxt.getText());
				
			}

		});

		add(positionLabel, GridBagLayoutUtils.constraint(1, 0, 5, "left"));
		add(positionTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(temperatureLabel, GridBagLayoutUtils.constraint(1, 2, 5, "left"));
		add(temperatureTxt, GridBagLayoutUtils.constraint(1, 3, 5));
		add(humidityLabel, GridBagLayoutUtils.constraint(1, 4, 5, "left"));
		add(humidityTxt, GridBagLayoutUtils.constraint(1, 5, 5));
		add(pressureLabel, GridBagLayoutUtils.constraint(1, 6, 5, "left"));
		add(pressureTxt, GridBagLayoutUtils.constraint(1, 7, 5));
		add(btnAdd, GridBagLayoutUtils.constraint(1, 8, 5));

		pack();
		setLocationRelativeTo(null);
		


	}

//	public void showError() {
//		JOptionPane.showMessageDialog(this, "Please fill in correct type of data", "Data input error", JOptionPane.ERROR_MESSAGE);
//	}
}
