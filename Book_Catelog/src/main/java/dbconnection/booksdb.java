package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class booksdb {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "Karthikb@11";
	private static String url = "jdbc:mysql://localhost:3306/bookcat";
	private static Connection conn = null;
	public static Connection conn() {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
