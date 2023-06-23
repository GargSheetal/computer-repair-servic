package repairshop.dataaccess.model.WorkTypeTechnician;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import repairshop.dataaccess.model.Technician.Technician;
import repairshop.dataaccess.model.WorkType.WorkType;

@XmlRootElement(name = "work_type_technician")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkTypeTechnician {

	@JsonProperty("skill_level")
	@XmlElement(name = "skill_level")
	private int skillLevel;
	
	@JsonProperty("work_type")
	@XmlElement(name = "work_type")
	private WorkType workType = new WorkType();
	
	@JsonProperty("technician")
	@XmlElement(name = "technician")
	private Technician technician = new Technician();
	
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
	}

	@Override
	public String toString() {
		return "WorkTypeTechnician [skillLevel=" + skillLevel + ", workType=" + workType + ", technician=" + technician
				+ "]";
	};
}
