package repairshop.dataaccess.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {
	
	public int create(Connection connection, Customer customer) throws SQLException {
		int generatedId = -1;
		String command = "INSERT into customers (last_name, rest_of_name, email, phone) values(?,?,?,?)";
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, customer.getLastName());
			ps.setString(2, customer.getRestOfName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());

			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()) {
	            if (resultSet.next()) {
	            	generatedId = resultSet.getInt(1);
	            }
	        }
		}
		return generatedId;
	}
	
	public Customer getById(Connection connection, int customerId) throws SQLException {
		Customer customer = null;
		String query = "SELECT * from customers where customer_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, customerId);
			
			try(ResultSet resultSet = ps.executeQuery()){
				if (resultSet.next()) {
					CustomerAdapter customerAdapter = new CustomerAdapter();
		            customer = customerAdapter.adaptFromDb(resultSet);
		        }
			}
	        
		}
		return customer;
	}
	
	public Customer getByEmail(Connection connection, String email) throws SQLException {
		Customer customer = null;
		String query = "SELECT * from customers where email=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, email);
			
			try(ResultSet resultSet = ps.executeQuery()){
				if (resultSet.next()) {
					CustomerAdapter customerAdapter = new CustomerAdapter();
		            customer = customerAdapter.adaptFromDb(resultSet);
		        }
			}
	        
		}
		return customer;
	}

	
	public List<Customer> getAll(Connection connection) throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		String query = "SELECT * from customers"; 

		try(
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
		) {
			CustomerAdapter customerAdapter = new CustomerAdapter();
			while(resultSet.next())
			{
				Customer customer = customerAdapter.adaptFromDb(resultSet);
				customerList.add(customer);
			}
		}
		return customerList;
	}

	
	public int updateById(Connection connection, Customer customer) throws SQLException {
		int updatedId = -1;
		String command = "UPDATE customers SET last_name=?, rest_of_name=?, email=?, phone=? WHERE customer_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, customer.getLastName());
			ps.setString(2, customer.getRestOfName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());
			ps.setInt(5, customer.getCustomerId());
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()){
		        if (resultSet.next()) {
		        	updatedId = resultSet.getInt(1);
		        }
	        }
		}
		return updatedId;
	}

	
	public int deleteById(Connection connection, int customerId) throws SQLException {
		int deletedId = -1;
		String command = "DELETE from customers WHERE customer_id = ?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
			ps.setInt(1, customerId);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()){
		        if (resultSet.next()) {
		        	deletedId = resultSet.getInt(1);
		        }
	        }
		}
		return deletedId;
	}
}

