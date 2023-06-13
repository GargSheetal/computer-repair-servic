package repairshop.dataaccess.model.DeviceType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import repairshop.dataaccess.model.DeviceBrand.DeviceBrand;

@XmlRootElement(name = "device_type")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceType {
	
	@XmlAttribute(name = "device_type_id", required = true)
	private int deviceTypeId;
	
	@XmlElement(name = "device_type_name")
	private String deviceTypeName;
	
	@XmlElement(name = "device_brand")
	private DeviceBrand deviceBrand = new DeviceBrand();;	// Foreign key reference
	
	public DeviceType() {
	}
	
	public DeviceType(int deviceTypeId, String deviceTypeName, DeviceBrand deviceBrand) {
		this.deviceTypeId = deviceTypeId;
		this.deviceTypeName = deviceTypeName;
		this.deviceBrand = deviceBrand;
	}
	
	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public DeviceBrand getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(DeviceBrand deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	
	public String toString() {
		return ("DeviceType ID: " + this.getDeviceTypeId() + " | " +
				"DeviceType Name: " + this.getDeviceTypeName() + " | " +
				"DeviceBrand Id: " + this.getDeviceBrand().getDeviceBrandId()
				);
	}
	
}
