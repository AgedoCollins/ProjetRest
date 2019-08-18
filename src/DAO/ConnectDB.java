package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection connect = null;	
	private ConnectDB(){}
	public static Connection getConnection(){
		if (connect==null){	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//System.out.println ("driver etablie");
			} catch (ClassNotFoundException e) {
				//System.out.println ("driver not found");
				e.printStackTrace();
			}			   
//			String hote = "char-oracle11.condorcet.be";//"localhost";
//		    String URL = "jdbc:oracle:thin:@"+hote+":1521:xe";
//		    String USER = "sylvain3";//"facsys";//"exa5";//
//		    String PASSWD = "Sylvain";//"root1";//
		    
		    String hote = "192.168.1.18";//"localhost";
		    String URL = "jdbc:oracle:thin:@"+hote+":1521:xe";
		    String USER = "revision";//"facsys";//"exa5";//
		    String PASSWD = "collins";//"root1";//
		    try {
		    	connect =DriverManager.getConnection(URL,USER, PASSWD);
				//System.out.println ("connexion  base orcl etablie");
			} catch (SQLException e) {
				connect = null;
				//System.out.println ("pas de connexion");
				e.printStackTrace();
			}
		}
		return connect;
	}

}
