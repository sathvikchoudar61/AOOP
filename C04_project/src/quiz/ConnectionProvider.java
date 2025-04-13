package quiz;

import java.sql.*;
public class ConnectionProvider { 
	private static Connection con;
	public static Connection getConnection() {
	    try {
	        if (con == null || con.isClosed()) {
	            // Load MySQL JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Create database connection
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "sathvikchoudary61", "@Madhavi2006");
	            System.out.println("Database connected successfully!");
	        }
	    } catch (Exception e) {
	        System.err.println("Database connection failed: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return con;
	}
}