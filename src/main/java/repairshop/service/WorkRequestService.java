package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.WorkRequest.*;
import repairshop.dataaccess.model.WorkRequestAppointment.*;
import repairshop.dataaccess.model.WorkRequestPayment.*;



public class WorkRequestService {

	private WorkRequestDaoImpl workRequestDaoImpl;
	private WorkRequestPaymentDaoImpl workRequestPaymentDaoImpl;
	private WorkRequestAppointmentDaoImpl workRequestAppointmentDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public WorkRequestService() throws IOException {
		this.workRequestDaoImpl = new WorkRequestDaoImpl();
		this.workRequestPaymentDaoImpl = new WorkRequestPaymentDaoImpl();
		this.workRequestAppointmentDaoImpl = new WorkRequestAppointmentDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public WorkRequest createWorkRequest(WorkRequest workRequest) throws SQLException {
		Connection connection = null;
		WorkRequest createdWorkRequest = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int workRequestId = workRequestDaoImpl.create(connection, workRequest);
            createdWorkRequest = workRequestDaoImpl.getById(connection, workRequestId);

            this.connectionManager.commitTransaction(connection);
        } catch (SQLException e) {
        	this.connectionManager.rollbackTransaction(connection);
            throw e;
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		System.out.println("Work Request created successfully");
		return createdWorkRequest;
	}
	
	public WorkRequestPayment createWorkRequestPayment(WorkRequestPayment workRequestPayment) throws SQLException {
		Connection connection = null;
		WorkRequestPayment createdWorkRequestPayment = null;
		try {
            connection = this.connectionManager.getConnection();
            this.connectionManager.beginTransaction(connection);

            // business logic
            int workRequestPaymentId = workRequestPaymentDaoImpl.create(connection, workRequestPayment);
            createdWorkRequestPayment = workRequestPaymentDaoImpl.getById(connection, workRequestPaymentId);

            this.connectionManager.commitTransaction(connection);
        } catch (SQLException e) {
        	this.connectionManager.rollbackTransaction(connection);
            throw e;
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		System.out.println("Work Request Payment created successfully");
		return createdWorkRequestPayment;
	}
	
	
	public WorkRequest getWorkRequestById(int workRequestId) throws SQLException {
		Connection connection = null;
		WorkRequest workRequest = null;
		try {
            connection = connectionManager.getConnection();
            workRequest = workRequestDaoImpl.getById(connection, workRequestId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return workRequest;
	}
	
	
	public List<WorkRequest> getAllWorkRequestsByCustomerId(int customerId) throws SQLException {
		Connection connection = null;
		List<WorkRequest> workRequestList = null;
		try {
            connection = connectionManager.getConnection();
            workRequestList = workRequestDaoImpl.getAllByCustomerId(connection, customerId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return workRequestList;
	}
	
	
	public void updateWorkRequestById(WorkRequest workRequest) throws SQLException {
		Connection connection = null;
		try {
	        connection = connectionManager.getConnection();
	        this.connectionManager.beginTransaction(connection);
	
	        // business logic
	        workRequestDaoImpl.updateById(connection, workRequest);
	        System.out.println("Work Request updated successfully");
	
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
