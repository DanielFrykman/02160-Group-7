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

import application.controller.ClientController;
import application.utils.GridBagLayoutUtils;

public class AddJourneyPopup extends JFrame {

	private static final long serialVersionUID = 989075482041187452L;
	private ClientController controller;

	public AddJourneyPopup(ClientController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add new journey");
		setResizable(false);
		setPreferredSize(new Dimension(300, 400));
		setLayout(new GridBagLayout());

		JLabel originLabel = new JLabel("Origin");
		JLabel destinationLabel = new JLabel("Destination");
		JLabel contentLabel = new JLabel("Content");
		JTextField originTxt = new JTextField(15);
		JTextField destinationTxt = new JTextField(15);
		JTextField contentTxt = new JTextField(15);
		JButton btnCreate = new JButton("Create");

		contentTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					controller.verifyNewJourney(originTxt.getText(), destinationTxt.getText(), contentTxt.getText());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.verifyNewJourney(originTxt.getText(), destinationTxt.getText(), contentTxt.getText());
			}

		});

		add(originLabel, GridBagLayoutUtils.constraint(1, 0, 5, "left"));
		add(originTxt, GridBagLayoutUtils.constraint(1, 1, 5));
		add(destinationLabel, GridBagLayoutUtils.constraint(1, 2, 5, "left"));
		add(destinationTxt, GridBagLayoutUtils.constraint(1, 3, 5));
		add(contentLabel, GridBagLayoutUtils.constraint(1, 4, 5, "left"));
		add(contentTxt, GridBagLayoutUtils.constraint(1, 5, 5));
		add(btnCreate, GridBagLayoutUtils.constraint(1, 6, 5));

		pack();
		setLocationRelativeTo(null);

	}
	public void showError() {
		JOptionPane.showMessageDialog(this, "Fill in all fields / Need different origin and destination", "New journey error", JOptionPane.ERROR_MESSAGE);
	}

}
