package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con = null;	
	private ConnectDB(){}
	public static Connection getConnection(){
		if (con==null){	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			   
			String hote = "char-oracle11.condorcet.be";//"localhost";
		    String URL = "jdbc:oracle:thin:@"+hote+":1521:xe";
		    String USER = "sylvain3";//"facsys";//"exa5";//
		    String PASSWD = "Sylvain";//"root1";//
		    try {
				con =DriverManager.getConnection(URL,USER, PASSWD);
			} catch (SQLException e) {
				con = null;
				e.printStackTrace();
			}
		}
		return con;
	}

}
