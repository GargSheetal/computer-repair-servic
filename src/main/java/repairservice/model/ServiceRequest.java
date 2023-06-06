package repairservice.model;

import java.util.Date;

public class ServiceRequest {

	private int serviceRequestId;
	private Service service;		// Foreign key reference
	private CustomerDevice customerDevice;		// Foreign key reference
	private Date createdTimestamp;
	private Date lastUpdatedTimestamp;
	private Date completedTimestamp;
	private double amount;
	private String serviceRequestDescription;
	
	public ServiceRequest() {}
	
	public ServiceRequest(int serviceRequestId, Service service, CustomerDevice customerDevice, Date createdTimestamp,
			Date lastUpdatedTimestamp, Date completedTimestamp, double amount, String serviceRequestDescription) {
		super();
		this.serviceRequestId = serviceRequestId;
		this.service = service;
		this.customerDevice = customerDevice;
		this.createdTimestamp = createdTimestamp;
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
		this.completedTimestamp = completedTimestamp;
		this.amount = amount;
		this.serviceRequestDescription = serviceRequestDescription;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public CustomerDevice getCustomerDevice() {
		return customerDevice;
	}

	public void setCustomerDevice(CustomerDevice customerDevice) {
		this.customerDevice = customerDevice;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	public Date getCompletedTimestamp() {
		return completedTimestamp;
	}

	public void setCompletedTimestamp(Date completedTimestamp) {
		this.completedTimestamp = completedTimestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getServiceRequestDescription() {
		return serviceRequestDescription;
	}

	public void setServiceRequestDescription(String serviceRequestDescription) {
		this.serviceRequestDescription = serviceRequestDescription;
	}
	
}
