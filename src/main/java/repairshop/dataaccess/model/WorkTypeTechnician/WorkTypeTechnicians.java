package repairshop.dataaccess.model.WorkTypeTechnician;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// workTypeTechnicians
@XmlRootElement(name="workTypeTechnicians")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkTypeTechnicians {

	@XmlElement(name = "workTypeTechnician")
	private List<WorkTypeTechnician> workTypeTechnicians;

	public List<WorkTypeTechnician> getWorkTypeTechnicians() {
		return workTypeTechnicians;
	}
}