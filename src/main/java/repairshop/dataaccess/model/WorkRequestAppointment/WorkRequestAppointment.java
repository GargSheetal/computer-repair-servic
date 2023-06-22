package repairshop.dataaccess.model.WorkRequestAppointment;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import repairshop.xml.DateAdapter;
import repairshop.dataaccess.model.Technician.Technician;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;

@JsonRootName(value = "work_request_appointment")
@XmlRootElement(name = "work_request_appointment")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRequestAppointment {
	
	@JsonProperty("work_request_appointment_id")
	@XmlAttribute(name = "work_request_appointment_id", required = true)
	private int workRequestAppointmentId;
	
	@JsonProperty("work_request")
	@XmlElement(name = "work_request")
	private WorkRequest workRequest = new WorkRequest();		// Foreign key reference
	
	@JsonProperty("technician")
	@XmlElement(name = "technician")
	private Technician technician = new Technician();		// Foreign key reference
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date appointmentTimestamp;
	
	@JsonProperty("technician_notes")
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
