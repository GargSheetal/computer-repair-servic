package repairshop.dataaccess.model.WorkRequest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// workRequests
@XmlRootElement(name="workRequests")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequests {

	@JsonProperty("work_request")
	@XmlElement(name = "work_request")
	private List<WorkRequest> workRequests;

	public List<WorkRequest> getWorkRequests() {
		return workRequests;
	}
}