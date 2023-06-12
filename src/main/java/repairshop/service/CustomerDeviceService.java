package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.customerdevice.*;

public class CustomerDeviceService {

	private CustomerDeviceDaoImpl customerDeviceDao;
	private DatabaseConnectionManager connectionManager;
	
	public CustomerDeviceService() throws IOException {
		this.customerDeviceDao = new CustomerDeviceDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public CustomerDevice createCustomerDevice(CustomerDevice customerDevice) throws SQLException {
		Connection connection = null;
		CustomerDevice createdCustomerDevice = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int customerDeviceId = customerDeviceDao.create(connection, customerDevice);
            createdCustomerDevice = customerDeviceDao.getById(connection, customerDeviceId);

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
	
	
	public CustomerDevice getById(int customerDeviceId) throws SQLException {
		Connection connection = null;
		CustomerDevice customerDevice = null;
		try {
            connection = connectionManager.getConnection();
            customerDevice = customerDeviceDao.getById(connection, customerDeviceId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return customerDevice;
	}
	
	
	public List<CustomerDevice> getAll() throws SQLException {
		Connection connection = null;
		List<CustomerDevice> customerDeviceList = null;
		try {
            connection = connectionManager.getConnection();
            customerDeviceList = customerDeviceDao.getAll(connection);
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
	        customerDeviceDao.updateById(connection, customerDevice);
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
	        customerDeviceDao.deleteById(connection, customerDeviceId);
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

}
