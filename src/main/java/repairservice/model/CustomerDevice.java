package repairservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDevice {

	@XmlAttribute(name="customer_device_id")
	private int customerDeviceId;
	
	@XmlElement(name="serial_number")
	private String serialNumber;
	
	@XmlElement(name="customer")
	private Customer customer = new Customer();	// Foreign key reference
	
	@XmlElement(name="device")
	private Device device = new Device();		// Foreign key reference
	
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
	
	public String toString() {
		return ("CustomerDevice ID: " + this.getCustomerDeviceId() + "\n" +
				"Serail Number: " + this.getSerialNumber() + "\n" +
				"Customer ID: " + this.getCustomer().getCustomerId() + "\n" +
				"Device ID: " + this.getDevice().getDeviceId() + "\n");
	}
	
}


