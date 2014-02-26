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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

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

import me.dokollari.cmanager.manager.DB;

/**
 * @author Rizart Dokollari
 * @version 1.7
 * @since February, 2014
 * 
 */
public class MainFrame
{

	private static final Color BACKGROUND_COLOR_SUCCESS = new Color(50, 205, 50);
	private static final Color FONT_COLOR_DEFAULT = new Color(51, 51, 51);
	private static final Color BACKGROUND_COLOR_DEFAULT = new Color(255, 255,
			255);
	private static final Color BACKGROUND_COLOR_ERROR = new Color(216, 0, 0);
	private static final String LOG_IN_MESSAGE_JLABEL = "Log In";
	private static final String USER_NAME_MESSAGE = "Username";
	private static final String PASSWORD_MESSAGE = "Password";
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private DB db;
	private JLabel lblConnectionMessage;

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
		panelBackgroundBack.setForeground(FONT_COLOR_DEFAULT);
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
						(int) (panelBackgroundBack.getHeight() / 2 - firstComponent
								.getSize().getHeight() / 2));

			}
		});
		frame.getContentPane().add(panelBackgroundBack);
		panelBackgroundBack.setLayout(null);

		JPanel panelBackgroundFront = new JPanel();
		panelBackgroundFront.setBounds(222, 62, 314, 277);
		panelBackgroundBack.add(panelBackgroundFront);

		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					logInAction();
				} // end if
			}
		});
		txtUsername.setBounds(34, 72, 250, 35);
		txtUsername.setBorder(new MatteBorder(0, 5, 0, 0, (Color) null));
		txtUsername.setCaretColor(new Color(0, 153, 255));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) {
				String userName = txtUsername.getText();

				// reset color for user name
				txtUsername.setBorder(new MatteBorder(0, 5, 0, 0,
						(Color) BACKGROUND_COLOR_DEFAULT));
				txtUsername.setBackground(BACKGROUND_COLOR_DEFAULT);

				// clear connection message
				lblConnectionMessage.setText("");

				// empties user indication
				if (userName.equals(USER_NAME_MESSAGE)) {
					txtUsername.setBorder(new MatteBorder(0, 5, 0, 0,
							(Color) BACKGROUND_COLOR_DEFAULT));
					txtUsername.setBackground(BACKGROUND_COLOR_DEFAULT);
					txtUsername.setFont(new Font("Rockwell", Font.PLAIN, 13));
					txtUsername.setForeground(FONT_COLOR_DEFAULT);
					txtUsername.setText("");
				} // end if
			} // end method focusGainec

			@Override
			public void focusLost(FocusEvent arg0) {
				String userName = txtUsername.getText();

				// show input indication for user name
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
		lblLogin.setFocusable(false);
		lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin.setBounds(34, 43, 50, 18);
		lblLogin.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblLogin.setForeground(FONT_COLOR_DEFAULT);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logInAction();
				} // end if
			}
		});
		passwordField.setBounds(34, 123, 250, 35);
		passwordField.setCaretColor(new Color(0, 153, 255));
		passwordField.setToolTipText("Your password.");
		passwordField.setText(PASSWORD_MESSAGE);
		passwordField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e) {
				// reset colors for password
				passwordField.setBorder(new MatteBorder(0, 5, 0, 0,
						(Color) BACKGROUND_COLOR_DEFAULT));
				passwordField.setBackground(BACKGROUND_COLOR_DEFAULT);

				// clear connection message
				lblConnectionMessage.setText("");

				// clear password field
				if (new String(passwordField.getPassword())
						.equals(PASSWORD_MESSAGE)) {
					passwordField.setText("");
				} // end if
			}

			@Override
			public void focusLost(FocusEvent e) {

				// reset password indication
				if (new String(passwordField.getPassword()).equals("")) {
					passwordField.setText(PASSWORD_MESSAGE);
					passwordField.setBorder(new MatteBorder(0, 5, 0, 0,
							(Color) BACKGROUND_COLOR_DEFAULT));
					passwordField.setBackground(BACKGROUND_COLOR_DEFAULT);
					passwordField.setFont(new Font("Open Sans", Font.PLAIN, 13));
					passwordField.setForeground(FONT_COLOR_DEFAULT);
				} // end if
			}
		});
		passwordField.setFont(new Font("Open Sans", Font.BOLD, 13));

		final JButton btnLogIn = new JButton("Sign In");
		btnLogIn.setBounds(34, 198, 250, 40);
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				logInAction();
			} // end method actionPerformed
		});
		btnLogIn.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/button_login.png")));
		panelBackgroundFront.setLayout(null);
		panelBackgroundFront.add(txtUsername);
		panelBackgroundFront.add(lblLogin);
		panelBackgroundFront.add(passwordField);
		panelBackgroundFront.add(btnLogIn);

		lblConnectionMessage = new JLabel("");
		lblConnectionMessage.setFocusable(false);
		lblConnectionMessage.setBounds(34, 166, 250, 18);
		panelBackgroundFront.add(lblConnectionMessage);

		JLabel lblDemoUser = new JLabel("demo_user/demo_password");
		lblDemoUser.setFocusable(false);
		lblDemoUser.setForeground(Color.GRAY);
		lblDemoUser.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblDemoUser.setBounds(94, 43, 146, 18);
		panelBackgroundFront.add(lblDemoUser);

		JLabel lblBackgroundFront = new JLabel("Front Background");
		lblBackgroundFront.setFocusable(false);
		lblBackgroundFront.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackgroundFront.setBounds(0, 0, 314, 277);
		lblBackgroundFront.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/background_small.png")));
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

	/**
	 * - called when user presses log in button / enter keyboard button
	 * 
	 * - app tries to connection to database. if connection is achieved it stores
	 * the given user_name & password; these credentials will be used for the
	 * rest of the app
	 * 
	 * - if any error is found then the app uses colors & message to indicate the
	 * user what did he do wrong
	 */
	private void logInAction() {
		String userName = txtUsername.getText();
		try {

			db = new DB(userName, new String(passwordField.getPassword()));

			// connection successfully at this point - no exception
			txtUsername.setBackground(BACKGROUND_COLOR_SUCCESS);
			txtUsername.setBorder(new MatteBorder(0, 5, 0, 0,
					(Color) BACKGROUND_COLOR_SUCCESS));
			passwordField.setBorder(new MatteBorder(0, 5, 0, 0,
					(Color) BACKGROUND_COLOR_SUCCESS));
			passwordField.setBackground(BACKGROUND_COLOR_SUCCESS);

			lblConnectionMessage.setForeground(Color.GREEN);
			lblConnectionMessage.setText("Connection established.");

		} catch (SQLException e) {
			// error messages
			lblConnectionMessage.setForeground(BACKGROUND_COLOR_ERROR);
			lblConnectionMessage.setToolTipText(e.getMessage());
			lblConnectionMessage.setText("Error username/password");

			// error colors of user name
			txtUsername.setBorder(new MatteBorder(0, 5, 0, 0,
					(Color) BACKGROUND_COLOR_ERROR));
			txtUsername.setBackground(BACKGROUND_COLOR_ERROR);

			// error colors for password
			passwordField.setBorder(new MatteBorder(0, 5, 0, 0,
					(Color) BACKGROUND_COLOR_ERROR));
			passwordField.setBackground(BACKGROUND_COLOR_ERROR);
			passwordField.setFont(new Font("Open Sans", Font.PLAIN, 13));
			passwordField.setForeground(FONT_COLOR_DEFAULT);
		} catch (Exception e) {
			lblConnectionMessage.setForeground(BACKGROUND_COLOR_ERROR);
			lblConnectionMessage.setText("Credentials Error. Hover for details.");
			lblConnectionMessage.setToolTipText(e.getMessage());

		} 
	} // end method logInAction
} // end class MainFrame

