package repairservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.JDBCUtil;
import repairservice.model.Customer;

public class CustomerDao implements ICustomerDao {

	public void create(Customer customer) {

		String query = "INSERT into customer('last_name', 'rest_of_name', 'email', 'phone') values(?,?,?,?)";
		
		// get connection
		try(Connection conn = JDBCUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, customer.getLastName());
			ps.setString(2, customer.getRestOfName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public Customer getById(int id) {
		String query = "SELECT * from customer where customer_id=?"; 
		
		ResultSet rs = null;
		Customer customer = null;
			try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setInt(1, id);
				// execute the query
				rs = ps.executeQuery();
				
				// create a customer object and populate its data
				if(rs.next()) {
					customer = new Customer();
					customer.setLastName(rs.getString("last_name"));
					customer.setRestOfName(rs.getString("rest_of_name"));
					customer.setEmail(rs.getString("email"));
					customer.setPhone(rs.getString("phone"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return customer;
			
		
	}

	public List<Customer> getAll() {
		List<Customer> custList = new ArrayList<Customer>();
		Customer customer = null;
		String query = "SELECT * from customer"; 
		Connection conn = JDBCUtil.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				customer = new Customer(rs.getInt("customer_id"), rs.getString("last_name"), rs.getString("rest_of_name"), rs.getString("email"), rs.getString("phone"));
				custList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custList;
	}

	public void update(Customer customer, String[] params) {
		String query = "UPDATE customer SET last_name=?, rest_of_name=?, email=?, phone=? WHERE id=?"; 
		try (Connection conn = JDBCUtil.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(2, params[1]);  // Assuming params[1] corresponds to the updated last_name
			ps.setString(3, params[2]);  // Assuming params[2] corresponds to the updated rest_of_name
			ps.setString(4, params[3]);  // Assuming params[3] corresponds to the updated email
			ps.setString(5, params[4]);  // Assuming params[4] corresponds to the updated phone
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		String query = "DELETE from customer WHERE id=?";
		try (Connection conn = JDBCUtil.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, id);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
