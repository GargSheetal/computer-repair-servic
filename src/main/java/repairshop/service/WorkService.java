package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.Device.*;
import repairshop.dataaccess.model.WorkType.*;


public class WorkService {

	private WorkTypeDaoImpl workTypeDaoImpl;
	private DeviceDaoImpl deviceDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public WorkService() throws IOException {
		this.workTypeDaoImpl = new WorkTypeDaoImpl();
		this.deviceDaoImpl = new DeviceDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	
	public List<WorkType> getAllWorkTypesByDeviceId(int deviceId) throws SQLException {
		Connection connection = null;
		List<WorkType> workTypeList = null;
		try {
            connection = connectionManager.getConnection();
            workTypeList = workTypeDaoImpl.getAllByDeviceId(connection, deviceId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return workTypeList;
	}
	
	public WorkType getWorkTypeById(int workTypeId) throws SQLException {
		Connection connection = null;
		WorkType workType = null;
		try {
            connection = connectionManager.getConnection();
            workType = workTypeDaoImpl.getById(connection, workTypeId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return workType;
	}
}
