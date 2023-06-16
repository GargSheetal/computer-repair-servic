package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.Customer.*;


public class CustomerService {

	private CustomerDaoImpl customerDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public CustomerService() throws IOException {
		this.customerDaoImpl = new CustomerDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public Customer createCustomer(Customer customer) throws SQLException {
		Connection connection = null;
		Customer createdCustomer = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int customerId = customerDaoImpl.create(connection, customer);
            createdCustomer = customerDaoImpl.getById(connection, customerId);

            this.connectionManager.commitTransaction(connection);
        } catch (SQLException e) {
        	this.connectionManager.rollbackTransaction(connection);
            throw e;
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		System.out.println("Customer created successfully");
		return createdCustomer;
	}
	
	
	public Customer getCustomerById(int customerId) throws SQLException {
		Connection connection = null;
		Customer customer = null;
		try {
            connection = connectionManager.getConnection();
            customer = customerDaoImpl.getById(connection, customerId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customer;
	}
	
	public Customer getCustomerByEmail(String email) throws SQLException {
		Connection connection = null;
		Customer customer = null;
		try {
            connection = connectionManager.getConnection();
            customer = customerDaoImpl.getByEmail(connection, email);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customer;
	}
	
	public List<Customer> getAllCustomers() throws SQLException {
		Connection connection = null;
		List<Customer> customerList = null;
		try {
            connection = connectionManager.getConnection();
            customerList = customerDaoImpl.getAll(connection);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customerList;
	}
	
	
	public void updateCustomerById(Customer customer) throws SQLException {
		Connection connection = null;
		try {
	        connection = connectionManager.getConnection();
	        this.connectionManager.beginTransaction(connection);
	
	        // business logic
	        customerDaoImpl.updateById(connection, customer);
	        System.out.println("Customer updated successfully");
	
	        this.connectionManager.commitTransaction(connection);
	    } catch (SQLException e) {
	    	this.connectionManager.rollbackTransaction(connection);
	        throw e;
	    } finally {
	    	this.connectionManager.closeConnection(connection);
	    }
		return;
	}
	
	
	public void deleteCustomerById(int customerId) throws SQLException {
		Connection connection = null;
		try {
	        // Start transaction
	        connection = connectionManager.getConnection();
	        this.connectionManager.beginTransaction(connection);
	
	        // business logic
	        customerDaoImpl.deleteById(connection, customerId);
	        System.out.println("Customer deleted successfully");
	
	        this.connectionManager.commitTransaction(connection);
	    } catch (SQLException e) {
	    	this.connectionManager.rollbackTransaction(connection);
	        throw e;
	    } finally {
	    	this.connectionManager.closeConnection(connection);
	    }
		return;
	}
    

}
