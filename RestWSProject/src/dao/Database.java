package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
	public Connection getConnection() throws Exception
	{
		try
		{
			//INSERT INTO `person`(`firstname`, `lastname`, `userID`, `loggedIn`, `loggedOut`, `role`) VALUES  ('Max','Mustermann',1,'2015-05-18 12:12:12','2015-05-18 12:24:16','admin')

			String connectionURL = "jdbc:mysql://localhost:3306/service";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}
}
