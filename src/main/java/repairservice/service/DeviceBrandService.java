package repairservice.service;

import java.util.List;

import repairservice.daoimpl.DeviceBrandDaoImpl;
import repairservice.model.DeviceBrand;

public class DeviceBrandService {
	
	private DeviceBrandDaoImpl deviceBrandDaoImpl;

	public DeviceBrandService(DeviceBrandDaoImpl deviceBrandDaoImpl) {
		this.deviceBrandDaoImpl = deviceBrandDaoImpl;
	}
	
	public DeviceBrand create(DeviceBrand deviceBrand) {
		deviceBrandDaoImpl.create(deviceBrand);
		return deviceBrand;
	}

	public DeviceBrand getById(int deviceBrandId) {
		return deviceBrandDaoImpl.getById(deviceBrandId);
	}
	
	public List<DeviceBrand> getAll() {
		return deviceBrandDaoImpl.getAll();
	}
	
	public DeviceBrand update(DeviceBrand deviceBrand) {
		return deviceBrandDaoImpl.update(deviceBrand);
	}
	
	public int delete(int deviceBrandId) {
		deviceBrandDaoImpl.delete(deviceBrandId);
		return deviceBrandId;
	}
	

}

