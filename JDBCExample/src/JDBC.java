import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
			// System.out.println("Creating database...");
			stmt = (Statement) conn.createStatement();

			// String sql = "CREATE DATABASE TRAINEES";
			// stmt.executeUpdate(sql);

			/*
			 * String sql = "INSERT INTO traineeInfo " +
			 * "VALUES ('tientm', 'tientm', 'tientm@gmail.com')";
			 * stmt.executeUpdate(sql);
			 * 
			 * sql = "INSERT INTO traineeInfo " +
			 * "VALUES ('loint', 'loint', 'loint@gmail.com')";
			 * stmt.executeUpdate(sql);
			 * 
			 * sql = "INSERT INTO traineeInfo " +
			 * "VALUES ('thongvc', 'thongvc', 'thongvc@gmail.com')";
			 * stmt.executeUpdate(sql);
			 * 
			 * System.out.println("Records created successfully...");
			 */
			System.out.println("Input your account: ");
			String userName = "", pass = "", email = "";
			while (userName == "" || pass == "" || email == "") {
				System.out.print("User Name: ");
				userName = new Scanner(System.in).nextLine();
				System.out.print("Password: ");
				pass = new Scanner(System.in).nextLine();
				System.out.print("Email: ");
				email = new Scanner(System.in).nextLine();
			}
			String sql = "SELECT * FROM traineeInfo WHERE username = \'"
					+ userName + "\'";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			String rsUserName = "", rsPass = "", rsEmail = "";
			while (rs.next()) {
				rsUserName = rs.getString("username");
				rsPass = rs.getString("password");
				rsEmail = rs.getString("email");
				System.out.println("User Name: " + rsUserName);
				System.out.println("Password: " + rsPass);
				System.out.println("Email: " + rsEmail);
			}

			// Update new data
			if (rs != null) {
				sql = "UPDATE traineeInfo SET password = \'" + pass + "\', "
						+ "email = \'" + email + "\' WHERE username = \'"
						+ userName + "\'";
				int rs2 = stmt.executeUpdate(sql);
				if (rs2 == 1) {
					System.out.println("Updated database..");
				}
			}

			rs.close();
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
