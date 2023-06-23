package repairshop.dataaccess.model.DeviceBrand;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="device_brand")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceBrand {
	
	@JsonProperty("device_brand_id")
	@XmlAttribute(name = "device_brand_id", required = true)
	private int deviceBrandId;
	
	@JsonProperty("brand_name")
	@XmlElement(name = "brand_name")
	private String brandName;

	public DeviceBrand() {}
	
	public DeviceBrand(String brandName) {
		this.brandName = brandName;
	}

	public DeviceBrand(int deviceBrandId, String brandName) {
		this.deviceBrandId = deviceBrandId;
		this.brandName = brandName;
	}
	
	public int getDeviceBrandId() {
		return deviceBrandId;
	}

	public void setDeviceBrandId(int deviceBrandId) {
		this.deviceBrandId = deviceBrandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String toString() {
		return ("DeviceBrand ID: " + this.getDeviceBrandId() + " | " +
				"DeviceBrand Name: " + this.getBrandName()
				);
	}

}

