package repairshop.dataaccess.model.WorkRequestAppointment;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import repairshop.xml.DateAdapter;
import repairshop.dataaccess.model.Technician.Technician;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;

@XmlRootElement(name = "work_request_appointment")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestAppointment {
	
	@XmlAttribute(name = "work_request_appointment_id", required = true)
	private int workRequestAppointmentId;
	
	@XmlElement(name = "work_request")
	private WorkRequest workRequest = new WorkRequest();		// Foreign key reference
	
	@XmlElement(name = "technician")
	private Technician technician = new Technician();		// Foreign key reference
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date appointmentTimestamp;
	
	@XmlElement(name = "technician_notes")
	private String technicianNotes;
	
	public WorkRequestAppointment() {}

	public WorkRequestAppointment(int workRequestAppointmentId, WorkRequest workRequest, Technician technician,
			Date appointmentTimestamp, String technicianNotes) {
		this.workRequestAppointmentId = workRequestAppointmentId;
		this.workRequest = workRequest;
		this.technician = technician;
		this.appointmentTimestamp = appointmentTimestamp;
		this.technicianNotes = technicianNotes;
	}

	public int getWorkRequestAppointmentId() {
		return workRequestAppointmentId;
	}

	public void setWorkRequestAppointmentId(int workRequestAppointmentId) {
		this.workRequestAppointmentId = workRequestAppointmentId;
	}

	public WorkRequest getWorkRequest() {
		return workRequest;
	}

	public void setWorkRequest(WorkRequest workRequest) {
		this.workRequest = workRequest;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Date getAppointmentTimestamp() {
		return appointmentTimestamp;
	}

	public void setAppointmentTimestamp(Date appointmentTimestamp) {
		this.appointmentTimestamp = appointmentTimestamp;
	}

	public String getTechnicianNotes() {
		return technicianNotes;
	}

	public void setTechnicianNotes(String technicianNotes) {
		this.technicianNotes = technicianNotes;
	}
	
}
