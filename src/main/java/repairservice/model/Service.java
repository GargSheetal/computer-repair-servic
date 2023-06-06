package repairservice.model;

public class Service {
	
	private String serviceDescription;
	private double price;
	private Device device;	// Foreign key reference
	
	public Service(String serviceDescription, double price, Device device) {
		super();
		this.serviceDescription = serviceDescription;
		this.price = price;
		this.device = device;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
