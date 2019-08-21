package complexity_measuring_tool.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection connection;

	public static Connection getDBConnection()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		if (connection == null || connection.isClosed()) {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/measure", "root", "mysql");

		}

		return connection;

	}
}
