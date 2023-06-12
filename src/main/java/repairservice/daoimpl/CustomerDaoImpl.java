package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.ICustomerDao;
import repairservice.model.Customer;

public class CustomerDaoImpl implements ICustomerDao {
	
	ResultSet rs = null;
	Customer customer = null;
	
	public Customer create(Customer customer) {

		String query = "INSERT into customers(last_name, rest_of_name, email, phone) values(?,?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, customer.getLastName());
			ps.setString(2, customer.getRestOfName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating customer: " + e.getMessage());
			e.printStackTrace();
		}
		return customer;
	}

	public Customer getById(int customerId) {
		String query = "SELECT * from customers where customer_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, customerId);
			// execute the query
			rs = ps.executeQuery();

			// create a customer object and populate its data
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setLastName(rs.getString("last_name"));
				customer.setRestOfName(rs.getString("rest_of_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving customer: " + e.getMessage());
			e.printStackTrace();
		}
		return customer;
	}

	public List<Customer> getAll() {
		List<Customer> custList = new ArrayList<>();
		String query = "SELECT * from customers"; 

		try(Connection conn = ConnectionPool.getConnection();
			   PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				customer = new Customer(rs.getInt("customer_id"), rs.getString("last_name"), rs.getString("rest_of_name"), rs.getString("email"), rs.getString("phone"));
				custList.add(customer);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving customers: " + e.getMessage());
			e.printStackTrace();
		}
		return custList;
	}

	public Customer update(Customer customer) {
		String query = "UPDATE customers SET last_name=?, rest_of_name=?, email=?, phone=? WHERE customer_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, customer.getLastName());
			ps.setString(2, customer.getRestOfName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());

			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating customer: " + e.getMessage());
			e.printStackTrace();
		}
		return customer;
	}

	public int delete(int customerId) {
		String query = "DELETE from customers WHERE customer_id = ?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			// Set the value for the prepared statement
			ps.setInt(1, customerId);
			int count = ps.executeUpdate();
			System.out.println("\n" + count + " row/s deleted.");
			if(count>0) {
				System.out.println("Customer with ID: " + customerId + " deleted successfully");
			} 
			else {
				System.out.println("No customer with ID: " + customerId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting customer: " + e.getMessage());
			e.printStackTrace();
		}
		return customerId;
	}

}






