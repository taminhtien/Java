import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBC {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/trainees";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database...");
			
			// Execute a query
			//System.out.println("Creating database...");
			stmt = (Statement) conn.createStatement();

			// String sql = "CREATE DATABASE TRAINEES";
			// stmt.executeUpdate(sql);

			String sql = "INSERT INTO traineeInfo "
					+ "VALUES ('tientm', 'tientm', 'tientm@gmail.com')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO traineeInfo "
					+ "VALUES ('loint', 'loint', 'loint@gmail.com')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO traineeInfo "
					+ "VALUES ('thongvc', 'thongvc', 'thongvc@gmail.com')";
			stmt.executeUpdate(sql);
			
			System.out.println("Records created successfully...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// Finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // End finally try
		} // End try
		System.out.println("Goobye");
	}
}
