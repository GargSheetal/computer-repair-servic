package repairshop.dataaccess.model.CustomerDevice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import repairshop.dataaccess.model.Customer.Customer;
import repairshop.dataaccess.model.Device.Device;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer_device")
public class CustomerDevice {

	@JsonProperty("customer_device_id")
	@XmlAttribute(name = "customer_device_id")
	private int customerDeviceId;
	
	@JsonProperty("serial_number")
	@XmlElement(name="serial_number")
	private String serialNumber;
	
	@JsonProperty("customer")
	@XmlElement(name="customer")
	private Customer customer = new Customer();	// Foreign key reference
	
	@JsonProperty("device")
	@XmlElement(name="device")
	private Device device = new Device();		// Foreign key reference
	
	public CustomerDevice() {}
	
	public CustomerDevice(String serialNumber, Customer customer, Device device) {
		this.serialNumber = serialNumber;
		this.customer = customer;
		this.device = device;
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


