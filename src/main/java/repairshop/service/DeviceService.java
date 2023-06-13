package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.Device.*;
import repairshop.dataaccess.model.DeviceBrand.*;
import repairshop.dataaccess.model.DeviceType.*;


public class DeviceService {

	private DeviceBrandDaoImpl deviceBrandDaoImpl;
	private DeviceTypeDaoImpl deviceTypeDaoImpl;
	private DeviceDaoImpl deviceDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public DeviceService() throws IOException {
		this.deviceBrandDaoImpl = new DeviceBrandDaoImpl();
		this.deviceTypeDaoImpl = new DeviceTypeDaoImpl();
		this.deviceDaoImpl = new DeviceDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	
	public List<DeviceBrand> getAllDeviceBrands() throws SQLException {
		Connection connection = null;
		List<DeviceBrand> deviceBrandList = null;
		try {
            connection = connectionManager.getConnection();
            deviceBrandList = deviceBrandDaoImpl.getAll(connection);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return deviceBrandList;
	}
	
	public List<DeviceType> getAllDeviceTypesByDeviceBrandId(int deviceBrandId) throws SQLException {
		Connection connection = null;
		List<DeviceType> deviceTypeList = null;
		try {
            connection = connectionManager.getConnection();
            deviceTypeList = deviceTypeDaoImpl.getAllByDeviceBrandId(connection, deviceBrandId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return deviceTypeList;
	}
	
	public List<Device> getAllDevicesByDeviceTypeId(int deviceTypeId) throws SQLException {
		Connection connection = null;
		List<Device> deviceList = null;
		try {
            connection = connectionManager.getConnection();
            deviceList = deviceDaoImpl.getAllByDeviceTypeId(connection, deviceTypeId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return deviceList;
	}
}
