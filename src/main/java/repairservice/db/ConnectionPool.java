package repairservice.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {
	
	private static BasicDataSource dataSource;
	
	public static Connection getConnection() throws SQLException {
		Properties props = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream("./src/main/resources/repairservice/db.properties");
			try {
				props.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		dataSource = new BasicDataSource();
		dataSource.setUrl(props.getProperty("url"));
		dataSource.setUsername(props.getProperty("username"));
		dataSource.setPassword(props.getProperty("password"));
		dataSource.setMinIdle(20);
		dataSource.setMaxIdle(50);
		dataSource.setMaxOpenPreparedStatements(100);
		dataSource.setMaxWaitMillis(20000); 

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
