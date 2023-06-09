package repairservice.model;

public class DeviceType {
	
	private int deviceTypeId;
	private String deviceTypeName;
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

	public void setDeviceTypeId(int deviceCategoryId) {
		this.deviceTypeId = deviceCategoryId;
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
	
}
