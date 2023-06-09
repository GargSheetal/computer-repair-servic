package repairservice.service;

import java.util.List;

import repairservice.daoimpl.DeviceTypeDaoImpl;
import repairservice.model.DeviceType;

public class DeviceTypeService {

	private DeviceTypeDaoImpl deviceTypeDaoImpl;

	public DeviceTypeService(DeviceTypeDaoImpl deviceTypeDaoImpl) {
		this.deviceTypeDaoImpl = deviceTypeDaoImpl;
	}
	
	public DeviceType create(DeviceType deviceType) {
		return deviceTypeDaoImpl.create(deviceType);
	}
	
	public DeviceType getById(int deviceTypeId) {
		return deviceTypeDaoImpl.getById(deviceTypeId);
	}
	
	public List<DeviceType> getAll() {
		return deviceTypeDaoImpl.getAll();
	}
	
	public DeviceType update(DeviceType deviceType) {
		return deviceTypeDaoImpl.update(deviceType);
	}
	
	public int delete(int deviceTypeId) {
		deviceTypeDaoImpl.delete(deviceTypeId);
		return deviceTypeId;
	}
}
