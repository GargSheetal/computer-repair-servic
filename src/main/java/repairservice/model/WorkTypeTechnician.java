package repairservice.model;

public class WorkTypeTechnician {

	private int skillLevel;
	private WorkType workType;
	private Technician technician;
	
	public WorkTypeTechnician() {}

	public WorkTypeTechnician(int skillLevel, WorkType workType, Technician technician) {
		this.skillLevel = skillLevel;
		this.workType = workType;
		this.technician = technician;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	};
	
}
