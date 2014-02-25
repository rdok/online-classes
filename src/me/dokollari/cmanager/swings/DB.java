package me.dokollari.cmanager.swings;

public class DB
{

	public void userExists(String userName, char[] password) {
		// #INSERT INTO `classesonline`.`students` (`user_name`, `password`)
		// VALUES ('username1', 'password1');

		String query = "SELECT * FROM `classesonline`.`students` WHERE `user_name`='"
				+ userName + "' AND `password`='" + password + "';";
		System.out.println(query);
	}
}
