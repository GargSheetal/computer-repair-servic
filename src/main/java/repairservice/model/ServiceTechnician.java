package repairservice.model;

public class ServiceTechnician {

	private int skillLevel;
	private Service service;
	private Technician technician;
	
	public ServiceTechnician() {};
	
	public ServiceTechnician(int skillLevel, Service service, Technician technician) {
		this.skillLevel = skillLevel;
		this.service = service;
		this.technician = technician;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Technician getTechnitian() {
		return technician;
	}

	public void setTechnitian(Technician technician) {
		this.technician = technician;
	}
	
	
	
	
}
