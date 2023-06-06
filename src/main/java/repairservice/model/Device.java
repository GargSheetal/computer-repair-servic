package repairservice.model;

public class Device {

	private int deviceId;
	private String deviceName;
	private DeviceCategory deviceCategory;	// Foreign key reference
	
	public Device() {
		
	}
	
	public Device(int deviceId, String deviceName, DeviceCategory deviceCategory) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceCategory = deviceCategory;
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

	public DeviceCategory getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(DeviceCategory deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

}
