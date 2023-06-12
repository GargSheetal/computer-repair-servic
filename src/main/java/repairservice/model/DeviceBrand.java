package repairservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="device_brand")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceBrand {
	
	@XmlAttribute(name = "device_brand_id", required = true)
	private int deviceBrandId;
	
	@XmlElement(name = "brand_name")
	private String brandName;

	public DeviceBrand() {
		
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

}
