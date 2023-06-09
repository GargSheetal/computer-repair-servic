package repairservice.model;

public class WorkType {
	
	private int workTypeId;
	private String workDescription;
	private double price;
	private Device device;	// Foreign key reference
	
	public WorkType() {}
	
	public WorkType(int workTypeId, String workDescription, double price, Device device) {
		this.workTypeId = workTypeId;
		this.workDescription = workDescription;
		this.price = price;
		this.device = device;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
}
