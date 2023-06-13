package repairshop.dataaccess.model.WorkRequest;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import repairshop.xml.DateAdapter;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.dataaccess.model.WorkType.WorkType;

@XmlRootElement(name = "work_request")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequest {

	@XmlAttribute(name = "work_request_id", required = true)
	private int workRequestId;
	
	@XmlElement(name = "work_type")
	private WorkType workType = new WorkType();		// Foreign key reference
	
	@XmlElement(name = "customer_device")
	private CustomerDevice customerDevice = new CustomerDevice();		// Foreign key reference
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date createdTimestamp;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date lastUpdatedTimestamp;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date completedTimestamp;
	
	@XmlElement(name = "amount")
	private double amount;
	
	@XmlElement(name = "work_request_description")
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


