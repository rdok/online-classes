package me.dokollari.cmanager.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Rizart Dokollari
 * @version 1.7
 * @since February, 2014
 * 
 */
public class DB
{
	private static final String REGEX_USER_NAME = "[a-zA-Z0-9_]{3,45}";
	private static final String REGEX_PASSWORD = "[a-zA-Z0-9!@#$%^&*()+=._]{8,45}";
	private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/classesonline";
	private String db_user;
	private String db_password;
	private Connection connection;

	public DB(String db_user, String db_password) throws Exception {
		setDb_user(db_user);
		setDb_password(db_password);
		connection = getDBConnection();
	}

	public boolean userExists(String userName, char[] password)
			throws SQLException {
		boolean userFound = false;
		String query = "SELECT * FROM `classesonline`.`students` WHERE `user_name`='"
				+ userName + "' AND `password`='" + new String(password) + "';";
		Connection connection;
		connection = getDBConnection();

		Statement statementUser = connection.createStatement();
		ResultSet resultSet = statementUser.executeQuery(query);

		if (!resultSet.isBeforeFirst()) {
			userFound = false;
		} // end if

		connection.close();
		statementUser.close();
		resultSet.close();

		return userFound;
	}

	/**
	 * source:
	 * http://www.mkyong.com/jdbc/jdbc-preparestatement-example-select-list
	 * -of-the-records/
	 * 
	 * @return
	 */
	private Connection getDBConnection() throws SQLException {
		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", db_user);
		connectionProps.put("password", db_password);
		connection = DriverManager.getConnection(DB_CONNECTION, connectionProps);
		return connection;
	} // end method getDBConnection

	public void setDb_user(String db_user) throws CManagerException {
		if (!db_user.matches(REGEX_USER_NAME)) {
			throw new CManagerException("Username can contain only: "
					+ REGEX_USER_NAME);
		} // end if
		this.db_user = db_user;
	}

	public void setDb_password(String db_password) throws CManagerException {
		if (!db_password.matches(REGEX_PASSWORD)) {
			throw new CManagerException("Password can contain only: "
					+ REGEX_USER_NAME);
		} // end if
		this.db_password = db_password;
	}

}
