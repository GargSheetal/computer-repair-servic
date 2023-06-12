package repairshop.dataaccess.device;

public class Device {

	private int deviceId;
	private String deviceName;
//	private DeviceType deviceType = new DeviceType();	// Foreign key reference
	
	public Device() {
		
	}
	
//	public Device(int deviceId, String deviceName, DeviceType deviceType) {
	public Device(int deviceId, String deviceName) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
//		this.deviceType = deviceType;
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

//	public DeviceType getDeviceType() {
//		return deviceType;
//	}
//
//	public void setDeviceType(DeviceType deviceType) {
//		this.deviceType = deviceType;
//	}

}
