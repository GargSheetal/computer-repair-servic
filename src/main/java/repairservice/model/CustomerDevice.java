package repairservice.model;

public class CustomerDevice {

	private int customerDeviceId;
	private String serialNumber;
	private Customer customer;	// Foreign key reference
	private Device device;		// Foreign key reference
	
	public CustomerDevice() {
		
	}
	
	public CustomerDevice(int customerDeviceId, String serialNumber, Customer customer, Device device) {
		this.customerDeviceId = customerDeviceId;
		this.serialNumber = serialNumber;
		this.customer = customer;
		this.device = device;
	}

	public int getCustomerDeviceId() {
		return customerDeviceId;
	}

	public void setCustomerDeviceId(int customerDeviceId) {
		this.customerDeviceId = customerDeviceId;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	

}

