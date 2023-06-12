package repairservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="device")
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {

	@XmlAttribute(name = "device_id", required = true)
	private int deviceId;
	
	@XmlElement(name = "device_name")
	private String deviceName;
	
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

}


