package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://TANTHONG:1433;databaseName=quanLyLaoDong;encrypt=false";
			String tk = "sa";
			String mk = "thong2602";
			c = DriverManager.getConnection(url, tk, mk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null)
				c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
