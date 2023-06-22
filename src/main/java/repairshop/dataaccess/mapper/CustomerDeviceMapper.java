package repairshop.dataaccess.mapper;

import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;

public interface CustomerDeviceMapper {

	CustomerDevice selectCustomerDeviceById(int customerDeviceId);
	
	CustomerDevice selectCustomerDeviceBySerialNumber(int serialNumber);
	
	CustomerDevice getCustomerDeviceById(int customerDeviceId);
	
	void addCustomerDevice(CustomerDevice customerDevice);
	
	void updateCustomerDevice(CustomerDevice customerDevice);
	
	void deleteCustomerDevice(int customerDeviceId);
	
}
