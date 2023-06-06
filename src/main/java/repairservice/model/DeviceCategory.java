package repairservice.model;

public class DeviceCategory {
	
	private int deviceCategoryId;
	private String deviceCategoryName;
	private DeviceBrand deviceBrand;	// Foreign key reference
	
	public DeviceCategory() {
	}
	
	public DeviceCategory(int deviceCategoryId, String deviceCategoryName, DeviceBrand deviceBrand) {
		this.deviceCategoryId = deviceCategoryId;
		this.deviceCategoryName = deviceCategoryName;
		this.deviceBrand = deviceBrand;
	}
	
	public int getDeviceCategoryId() {
		return deviceCategoryId;
	}

	public void setDeviceCategoryId(int deviceCategoryId) {
		this.deviceCategoryId = deviceCategoryId;
	}
	
	public String getDeviceCategoryName() {
		return deviceCategoryName;
	}

	public void setDeviceCategoryName(String deviceCategoryName) {
		this.deviceCategoryName = deviceCategoryName;
	}

	public DeviceBrand getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(DeviceBrand deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	
}
