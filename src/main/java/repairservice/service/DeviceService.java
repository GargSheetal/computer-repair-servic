package repairservice.service;

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
	
}

