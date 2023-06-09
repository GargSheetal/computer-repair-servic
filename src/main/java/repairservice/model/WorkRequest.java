package repairservice.model;

import java.util.Date;

public class WorkRequest {

	private int workRequestId;
	private WorkType workType;		// Foreign key reference
	private CustomerDevice customerDevice;		// Foreign key reference
	private Date createdTimestamp;
	private Date lastUpdatedTimestamp;
	private Date completedTimestamp;
	private double amount;
	private String workRequestDescription;
	
	public WorkRequest() {}

	public WorkRequest(int workRequestId, WorkType workType, CustomerDevice customerDevice, Date createdTimestamp,
			Date lastUpdatedTimestamp, Date completedTimestamp, double amount, String workRequestDescription) {
		this.workRequestId = workRequestId;
		this.workType = workType;
		this.customerDevice = customerDevice;
		this.createdTimestamp = createdTimestamp;
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
		this.completedTimestamp = completedTimestamp;
		this.amount = amount;
		this.workRequestDescription = workRequestDescription;
	}

	public int getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(int workRequestId) {
		this.workRequestId = workRequestId;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
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

	public String getWorkRequestDescription() {
		return workRequestDescription;
	}

	public void setWorkRequestDescription(String workRequestDescription) {
		this.workRequestDescription = workRequestDescription;
	}
	
}

