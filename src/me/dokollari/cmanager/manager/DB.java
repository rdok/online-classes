/*******************************************************************************
 *  The MIT License
 *   
 *  Copyright (c) 2014 Rizart Dokollari.
 *  
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *  
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
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
//	private static final String REGEX_USER_NAME = "[a-zA-Z0-9_]{3,45}";
//	private static final String REGEX_PASSWORD = "[a-zA-Z0-9!@#$%^&*()+=._]{8,45}";
	private final String DB_CONNECTION = "jdbc:mysql://db4free.net:3306/labsdb";
	private static final String DB_USER = "labsadmin";
	private static final String DB_PASSWORD = "fxWI7MSvqKcEo1lHg8v7";
	private Connection connection;

	/**
	 * @param db_user
	 * @param db_password
	 * @throws Exception
	 */
	public DB(String db_user, String db_password) throws Exception {
		// setDb_user(db_user);
		// setDb_password(db_password);
		connection = getDBConnection();
	}

	public boolean userExists(String userName, char[] password)
			throws SQLException {
		boolean userFound = false;
		// String query =
		// "SELECT * FROM `classesonline`.`students` WHERE `user_name`='"
		// + userName + "' AND `password`='" + new String(password) + "';";
		String query = "SELECT * FROM labsdb.students WHERE user_name = 'demo_user';";

		connection = getDBConnection(); // verifies valid connection

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
		// if current connection is still valid then return that connection
//		if(connection != null && !connection.isClosed() ) {
//			
//			return connection;
//		}
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", DB_USER);
		connectionProps.put("password", DB_PASSWORD);
		connection = DriverManager.getConnection(DB_CONNECTION, connectionProps);
		return connection;
	} // end method getDBConnection

	// public void setDb_user(String db_user) throws CManagerException {
	// if (!db_user.matches(REGEX_USER_NAME)) {
	// throw new CManagerException("Username can contain only: "
	// + REGEX_USER_NAME);
	// } // end if
	// this.DB_USER = db_user;
	// }
	//
	// public void setDb_password(String db_password) throws CManagerException {
	// if (!db_password.matches(REGEX_PASSWORD)) {
	// throw new CManagerException("Password can contain only: "
	// + REGEX_USER_NAME);
	// } // end if
	// this.DB_PASSWORD = db_password;
	// }

} // end DB
