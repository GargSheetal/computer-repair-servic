package repairshop.dataaccess.model.WorkRequestPayment;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// workRequestPayments
@XmlRootElement(name="workRequestPayments")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestPayments {

	@XmlElement(name = "workRequestPayment")
	private List<WorkRequestPayment> workRequestPayments;

	public List<WorkRequestPayment> getWorkRequestPayments() {
		return workRequestPayments;
	}
}