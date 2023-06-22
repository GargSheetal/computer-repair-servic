package repairshop.dataaccess.model.WorkTypeTechnician;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// workTypeTechnicians
@XmlRootElement(name="workTypeTechnicians")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkTypeTechnicians {

	@JsonProperty("work_type_technician")
	@XmlElement(name = "work_type_technician")
	private List<WorkTypeTechnician> workTypeTechnicians;

	public List<WorkTypeTechnician> getWorkTypeTechnicians() {
		return workTypeTechnicians;
	}
}