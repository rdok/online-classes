package me.dokollari.cmanager.swings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame
{

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try {
					MainFrame window = new MainFrame();

					Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					JFrame frame = window.frame;
					window.frame.setBounds(100, 100, 708, 415);
					// frame location
					frame.setLocation(screenSize.width / 2 - frame.getSize().width
							/ 2, screenSize.height / 2 - frame.getSize().height / 2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		// frame location
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
				screenSize.height / 2 - frame.getSize().height / 2);

		final JPanel panelBackground = new JPanel();
		panelBackground.setForeground(new Color(51, 51, 51));
		panelBackground.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent arg0) {
				int lastComponent = panelBackground.getComponentCount() - 1;
				int panelWidth = panelBackground.getWidth();
				int panelHeight = panelBackground.getHeight();

				panelBackground.getComponent(lastComponent).setSize(panelWidth,
						panelHeight);

				for (int i = 0; i < panelBackground.getComponentCount() - 1; i++) {
					Component component = panelBackground.getComponent(i);
					component.setLocation(panelBackground.getWidth() / 3,
							component.getY());
				}

			}
		});
		frame.getContentPane().add(panelBackground);

		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/button_login.png")));
		btnLogIn.setBounds(252, 239, 250, 40);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setBounds(252, 182, 250, 35);
		txtPassword.setText("Password");
		txtPassword.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(252, 128, 250, 35);
		txtUsername.setText("Username");
		txtUsername.setColumns(10);

		JLabel lblBackground = new JLabel("background");
		lblBackground.setBounds(0, 0, 700, 391);
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/background.jpg")));
		panelBackground.setLayout(null);
		panelBackground.add(txtUsername);
		panelBackground.add(txtPassword);
		panelBackground.add(btnLogIn);

		final JLabel lblLogin = new JLabel("Log In");
		lblLogin.setForeground(new Color(51, 51, 51));
		lblLogin.setBounds(252, 103, 250, 14);
		panelBackground.add(lblLogin);
		panelBackground.add(lblBackground);

		frame.pack();
		btnLogIn.requestFocusInWindow();
	}
}
