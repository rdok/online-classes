package me.dokollari.cmanager.swings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Riz
 * 
 */
public class MainFrame
{

	private static final String LOG_IN_MESSAGE_JLABEL = "Log In";
	private static final String USER_NAME_MESSAGE = "Username";
	private static final String PASSWORD_MESSAGE = "Password";
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private DB db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} // end catch
			}
		});
	} // end main method

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize(); // initialize UI
		db = new DB(); // initialize database.
	} // end constructor

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		// frame location
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
				screenSize.height / 2 - frame.getSize().height / 2);

		final JPanel panelBackgroundBack = new JPanel();
		panelBackgroundBack.setForeground(new Color(51, 51, 51));
		panelBackgroundBack.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent arg0) {
				Component firstComponent = panelBackgroundBack.getComponent(0);
				Component lastComponent = panelBackgroundBack
						.getComponent(panelBackgroundBack.getComponentCount() - 1);
				int panelWidth = panelBackgroundBack.getWidth();
				int panelHeight = panelBackgroundBack.getHeight();

				lastComponent.setSize(panelWidth, panelHeight);
				firstComponent.setLocation(
						(int) (panelBackgroundBack.getWidth() / 2 - firstComponent
								.getSize().getWidth() / 2),
						(int) (panelBackgroundBack.getHeight() / 2
								- firstComponent.getSize().getHeight() / 2));
				// for (int i = 0; i < panelBackground.getComponentCount() - 1; i++)
				// {
				// Component component = panelBackground.getComponent(i);
				// component.setLocation(
				// (int) (panelBackground.getWidth() / 2 - component
				// .getSize().getWidth() / 2), component.getY());
				// } // end for
			} // end method componentResized
		});
		frame.getContentPane().add(panelBackgroundBack);
		panelBackgroundBack.setLayout(null);

		JPanel panelBackgroundFront = new JPanel();
		panelBackgroundFront.setBounds(222, 62, 314, 277);
		panelBackgroundBack.add(panelBackgroundFront);

		JLabel lblBackgroundFront = new JLabel("Front Background");
		lblBackgroundFront.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackgroundFront.setBounds(0, 0, 314, 277);
		lblBackgroundFront.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/background_small.png")));

		txtUsername = new JTextField();
		txtUsername.setBounds(34, 72, 250, 35);
		txtUsername.setBorder(new MatteBorder(0, 5, 0, 0, (Color) null));
		txtUsername.setCaretColor(new Color(0, 153, 255));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) {
				String userName = txtUsername.getText();

				if (userName.equals(USER_NAME_MESSAGE)) {
					txtUsername.setBorder(new MatteBorder(0, 5, 0, 0,
							(Color) new Color(102, 204, 255)));
					txtUsername.setFont(new Font("Rockwell", Font.PLAIN, 13));
					txtUsername.setForeground(new Color(51, 51, 51));
					txtUsername.setText("");
				} // end if
			} // end method focusGainec

			@Override
			public void focusLost(FocusEvent arg0) {
				String userName = txtUsername.getText();

				if (userName.equals("")) {
					txtUsername.setBorder(new LineBorder(null));
					txtUsername.setText(USER_NAME_MESSAGE);
					txtUsername.setForeground(new Color(204, 204, 204));
					txtUsername.setFont(new Font("Rockwell", Font.ITALIC, 13));
				} // end if
			} // end method focusLost
		});
		txtUsername.setFont(new Font("Open Sans", Font.ITALIC, 13));
		txtUsername.setForeground(new Color(204, 204, 204));
		txtUsername.setText(USER_NAME_MESSAGE);
		txtUsername.setColumns(10);

		final JLabel lblLogin = new JLabel(LOG_IN_MESSAGE_JLABEL);
		lblLogin.setBounds(34, 43, 250, 18);
		lblLogin.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblLogin.setForeground(new Color(51, 51, 51));

		passwordField = new JPasswordField();
		passwordField.setBounds(34, 123, 250, 35);
		passwordField.setCaretColor(new Color(0, 153, 255));
		passwordField.setToolTipText("Your password.");
		passwordField.setText(PASSWORD_MESSAGE);
		passwordField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) {
				if (new String(passwordField.getPassword())
						.equals(PASSWORD_MESSAGE)) {
					passwordField.setBorder(new MatteBorder(0, 5, 0, 0,
							(Color) new Color(102, 204, 255)));
					passwordField.setText("");
				} // end if
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (new String(passwordField.getPassword()).equals("")) {
					passwordField.setText(PASSWORD_MESSAGE);
				} // end if
			}
		});
		passwordField.setFont(new Font("Open Sans", Font.BOLD, 13));

		final JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setBounds(34, 183, 250, 40);
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUsername.getText();
				db.userExists(userName, passwordField.getPassword());
				System.out.println("User exists");
			} // end method actionPerformed
		});
		btnLogIn.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/button_login.png")));
		panelBackgroundFront.setLayout(null);
		panelBackgroundFront.add(txtUsername);
		panelBackgroundFront.add(lblLogin);
		panelBackgroundFront.add(passwordField);
		panelBackgroundFront.add(btnLogIn);
		panelBackgroundFront.add(lblBackgroundFront);

		JLabel lblBackground = new JLabel("background");
		lblBackground.setBorder(UIManager.getBorder("FormattedTextField.border"));
		lblBackground.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBackground.setForeground(new Color(102, 102, 102));
		lblBackground.setBounds(0, 0, 735, 437);
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/background.jpg")));
		panelBackgroundBack.add(lblBackground);

		// solves the problem of btnLogIn not getting focus
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() {
				btnLogIn.requestFocusInWindow();
			}
		});
	}
}
