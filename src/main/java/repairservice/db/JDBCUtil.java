package repairservice.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	//JDBC and database properties
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/computer_repair_service";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Q!W@E#r4t5y6";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			// Register the JDBC Driver
			Class.forName(DB_DRIVER);
			
			//Open the connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			
			if(conn != null)
			{
				System.out.println("Connected Successfully");
			}
			else
			{
				System.out.println("Connection Failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
		
	}
}
