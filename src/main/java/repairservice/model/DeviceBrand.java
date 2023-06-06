package repairservice.model;

public class DeviceBrand {
	
	private int deviceBrandId;
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
