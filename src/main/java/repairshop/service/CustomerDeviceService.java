package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.CustomerDevice.*;

public class CustomerDeviceService {

	private CustomerDeviceDaoImpl customerDeviceDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public CustomerDeviceService() throws IOException {
		this.customerDeviceDaoImpl = new CustomerDeviceDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public CustomerDevice createCustomerDevice(CustomerDevice customerDevice) throws SQLException {
		Connection connection = null;
		CustomerDevice createdCustomerDevice = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int customerDeviceId = customerDeviceDaoImpl.create(connection, customerDevice);
            createdCustomerDevice = customerDeviceDaoImpl.getById(connection, customerDeviceId);

            this.connectionManager.commitTransaction(connection);
        } catch (SQLException e) {
        	this.connectionManager.rollbackTransaction(connection);
            throw e;
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		System.out.println("CustomerDevice created successfully");
		return createdCustomerDevice;
	}
	
	
	public CustomerDevice getCustomerDeviceById(int customerDeviceId) throws SQLException {
		Connection connection = null;
		CustomerDevice customerDevice = null;
		try {
            connection = connectionManager.getConnection();
            customerDevice = customerDeviceDaoImpl.getById(connection, customerDeviceId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customerDevice;
	}
	
	
	public List<CustomerDevice> getAllCustomerDevices() throws SQLException {
		Connection connection = null;
		List<CustomerDevice> customerDeviceList = null;
		try {
            connection = connectionManager.getConnection();
            customerDeviceList = customerDeviceDaoImpl.getAll(connection);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customerDeviceList;
	}
	
	
	public void updateCustomerDeviceById(CustomerDevice customerDevice) throws SQLException {
		Connection connection = null;
		try {
	        connection = connectionManager.getConnection();
	        this.connectionManager.beginTransaction(connection);
	
	        // business logic
	        customerDeviceDaoImpl.updateById(connection, customerDevice);
	        System.out.println("CustomerDevice updated successfully");
	
	        this.connectionManager.commitTransaction(connection);
	    } catch (SQLException e) {
	    	this.connectionManager.rollbackTransaction(connection);
	        throw e;
	    } finally {
	    	this.connectionManager.closeConnection(connection);
	    }
		return;
	}
	
	
	public void deleteCustomerDeviceById(int customerDeviceId) throws SQLException {
		Connection connection = null;
		try {
	        // Start transaction
	        connection = connectionManager.getConnection();
	        this.connectionManager.beginTransaction(connection);
	
	        // business logic
	        customerDeviceDaoImpl.deleteById(connection, customerDeviceId);
	        System.out.println("CustomerDevice deleted successfully");
	
	        this.connectionManager.commitTransaction(connection);
	    } catch (SQLException e) {
	    	this.connectionManager.rollbackTransaction(connection);
	        throw e;
	    } finally {
	    	this.connectionManager.closeConnection(connection);
	    }
		return;
	}

	
    public List<CustomerDevice> getAllCustomerDevicesByCustomerId(int customerId) throws SQLException {
    	Connection connection = null;
    	List<CustomerDevice> customerDeviceList = null;
        
    	try {
            connection = connectionManager.getConnection();
            customerDeviceList = customerDeviceDaoImpl.getAllByCustomerId(connection, customerId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customerDeviceList;
    }
}
