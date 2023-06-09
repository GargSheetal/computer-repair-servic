package repairservice.service;

import java.util.List;

import repairservice.daoimpl.CustomerDeviceDaoImpl;
import repairservice.model.CustomerDevice;

public class CustomerDeviceService {
	
	private CustomerDeviceDaoImpl customerDeviceDaoImpl;

	public CustomerDeviceService(CustomerDeviceDaoImpl customerDeviceDaoImpl) {
		this.customerDeviceDaoImpl = customerDeviceDaoImpl;
	}
	
	public CustomerDevice create(CustomerDevice custDevice) {
		return customerDeviceDaoImpl.create(custDevice);
	}

	public CustomerDevice getById(int custDeviceId) {
		return customerDeviceDaoImpl.getById(custDeviceId);
	}
	
	public List<CustomerDevice> getAll() {
		return customerDeviceDaoImpl.getAll();
	}
	
	public CustomerDevice update(CustomerDevice custDevice) {
		return customerDeviceDaoImpl.update(custDevice);
	}
	
	public int delete(int id) {
		customerDeviceDaoImpl.delete(id);
		return id;
	}
}

