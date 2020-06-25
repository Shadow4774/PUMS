package it.enaip.corso.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceFactory {

	//TODO: TRIPLE-CHECK THIS!
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MARCO", "marco");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
/*/
	private static class SingletonHelper {
		private static final DataSourceFactory INSTANCE = new DataSourceFactory();
	}
//*/
}
