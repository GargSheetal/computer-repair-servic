package repairservice.service;

import java.util.List;

import repairservice.daoimpl.DeviceDaoImpl;
import repairservice.model.Device;

public class DeviceService {

	private DeviceDaoImpl deviceDaoImpl;

	public DeviceService(DeviceDaoImpl deviceDaoImpl) {
		this.deviceDaoImpl = deviceDaoImpl;
	}
	
	public Device create(Device device) {
		return deviceDaoImpl.create(device);
	}
	
	public Device getById(int deviceId) {
		return deviceDaoImpl.getById(deviceId);
	}
	
	public List<Device> getAll() {
		return deviceDaoImpl.getAll();
	}
	
	public Device update(Device device) {
		return deviceDaoImpl.update(device);
	}
	
	public int delete(int deviceId) {
		deviceDaoImpl.delete(deviceId);
		return deviceId;
	}
}

