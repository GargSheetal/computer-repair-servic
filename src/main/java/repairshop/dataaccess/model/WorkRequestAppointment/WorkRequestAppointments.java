package repairshop.dataaccess.model.WorkRequestAppointment;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// workRequestAppointments
@XmlRootElement(name="work_request_appointments")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestAppointments {

	@JsonProperty("work_request_appointment")
    @XmlElement(name = "work_request_appointment")
    private List<WorkRequestAppointment> workRequestAppointments;

    public List<WorkRequestAppointment> getWorkRequestAppointments() {
        return workRequestAppointments;
    }
}