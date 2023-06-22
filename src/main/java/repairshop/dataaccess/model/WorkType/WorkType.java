package repairshop.dataaccess.model.WorkType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import repairshop.dataaccess.model.Device.Device;

@JsonRootName(value = "work_type")
@XmlRootElement(name = "work_type")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkType {
	
	@JsonProperty("work_type_id")
	@XmlAttribute(name = "work_type_id", required = true)
	private int workTypeId;
	
	@JsonProperty("work_description")
	@XmlElement(name = "work_description")
	private String workDescription;
	
	@JsonProperty("price")
	@XmlElement(name = "price")
	private double price;
	
	@JsonProperty("device")
	@XmlElement(name = "device")
	private Device device = new Device();	// Foreign key reference
	
	public WorkType() {}
	
	public WorkType(int workTypeId, String workDescription, double price, Device device) {
		this.workTypeId = workTypeId;
		this.workDescription = workDescription;
		this.price = price;
		this.device = device;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
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
	
	@Override
	public String toString() {
		return ("Work Type ID: " + this.getWorkTypeId() + " | " +
				"Work Description: " + this.getWorkDescription() + " | " + 
				"Price: " + this.getPrice() + " | " + 
				"Device ID: " + this.getDevice().getDeviceId()
				);
	}
}
