package repairshop.dataaccess.model.Device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import repairshop.dataaccess.model.DeviceType.DeviceType;

@XmlRootElement(name="device")
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {

	@JsonProperty("device_id")
	@XmlAttribute(name = "device_id", required = true)
	private int deviceId;
	
	@JsonProperty("device_name")
	@XmlElement(name = "device_name")
	private String deviceName;
	
	@JsonProperty("device_type")
	@XmlElement(name = "device_type")
	private DeviceType deviceType = new DeviceType();	// Foreign key reference
	
	public Device() {
		
	}
	
	public Device(int deviceId, String deviceName, DeviceType deviceType) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	
	@Override
	public String toString() {
		return ("Device ID: " + this.getDeviceId() + " | " +
				"Device Name: " + this.getDeviceName() + " | " + 
				"DeviceType ID: " + this.getDeviceType().getDeviceTypeId()
				);
	}
}



