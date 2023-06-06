package repairservice.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
	
	private static BasicDataSource dataSource;
	
	static {
        // Configure the data source
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/computer_repair_service");
        dataSource.setUsername("root");
        dataSource.setPassword("Q!W@E#r4t5y6");
        dataSource.setMinIdle(20);
        dataSource.setMaxIdle(50);
        dataSource.setMaxOpenPreparedStatements(100);
        dataSource.setMaxWaitMillis(20000); 
    }
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.setAutoCommit(true); // Reset auto-commit to true
            connection.close(); // Close the connection
        }
    }
	
	public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void shutdown(){
        try {
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
