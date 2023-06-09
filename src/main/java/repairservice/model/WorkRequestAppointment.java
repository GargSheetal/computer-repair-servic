package repairservice.model;

import java.util.Date;

public class WorkRequestAppointment {
	
	private int workRequestAppointmentId;
	private WorkRequest workRequest;		// Foreign key reference
	private Technician technician;		// Foreign key reference
	private Date appointmentTimestamp;
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
