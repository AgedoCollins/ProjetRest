package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection connect = null;

	private ConnectDB() {
	}

	public static Connection getConnection() {
		if (connect == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String hote = "Char-oracle11.condorcet.be";// "localhost";
			String URL = "jdbc:oracle:thin:@" + hote + ":1521:xe";
			String USER = "sylvain3";// "facsys";//"exa5";//
			String PASSWD = "Sylvain";// "root1";//
			try {
				connect = DriverManager.getConnection(URL, USER, PASSWD);
			} catch (SQLException e) {
				connect = null;
				e.printStackTrace();
			}
		}
		return connect;
	}

}
