package me.dokollari.cmanager.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB
{
	private final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/classesonline";
	private String db_user;
	private String db_password;
	private Connection connection;

	public DB(String db_user, String db_password) throws SQLException {
		this.db_user = db_user;
		this.db_password = db_password;
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
	}
}
