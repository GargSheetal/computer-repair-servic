package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.customer.Customer;
import repairshop.dataaccess.model.customer.CustomerDaoImpl;

public class CustomerService {

	private CustomerDaoImpl customerDao;
	private DatabaseConnectionManager connectionManager;
	
	public CustomerService() throws IOException {
		this.customerDao = new CustomerDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public Customer createCustomer(Customer customer) throws SQLException {
		Connection connection = null;
		Customer createdCustomer = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int customerId = customerDao.create(connection, customer);
            createdCustomer = customerDao.getById(connection, customerId);

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
	
	
	public Customer getById(int customerId) throws SQLException {
		Connection connection = null;
		Customer customer = null;
		try {
            connection = connectionManager.getConnection();
            customer = customerDao.getById(connection, customerId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customer;
	}
	
	
	public List<Customer> getAll() throws SQLException {
		Connection connection = null;
		List<Customer> customerList = null;
		try {
            connection = connectionManager.getConnection();
            customerList = customerDao.getAll(connection);
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
	        customerDao.updateById(connection, customer);
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
	        customerDao.deleteById(connection, customerId);
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
