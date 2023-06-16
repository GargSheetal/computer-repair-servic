package repairshop.dataaccess.model.WorkRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// workRequests
@XmlRootElement(name="workRequests")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequests {

	@XmlElement(name = "workRequest")
	private List<WorkRequest> workRequests;

	public List<WorkRequest> getWorkRequests() {
		return workRequests;
	}
}