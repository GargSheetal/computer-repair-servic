package repairshop.dataaccess.model.WorkRequestPayment;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// workRequestPayments
@XmlRootElement(name="workRequestPayments")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestPayments {

	@JsonProperty("work_request_payment")
	@XmlElement(name = "work_request_payment")
	private List<WorkRequestPayment> workRequestPayments;

	public List<WorkRequestPayment> getWorkRequestPayments() {
		return workRequestPayments;
	}
}