package repairshop.dataaccess.model.WorkRequestAppointment;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// workRequestAppointments
@XmlRootElement(name="work_request_appointments")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestAppointments {

    @XmlElement(name = "work_request_appointment")
    private List<WorkRequestAppointment> workRequestAppointments;

    public List<WorkRequestAppointment> getWorkRequestAppointments() {
        return workRequestAppointments;
    }
}