package repairservice.model;

import java.util.Date;

public class ServiceRequestAppointment {
	
	private ServiceRequest serviceRequest;		// Foreign key reference
	private Technician technician;		// Foreign key reference
	private Date appointmentTimestamp;
	private String technicianNotes;
	
	public ServiceRequestAppointment() {}
	
	public ServiceRequestAppointment(ServiceRequest serviceRequest, Technician technician, Date appointmentTimestamp,
			String technicianNotes) {
		super();
		this.serviceRequest = serviceRequest;
		this.technician = technician;
		this.appointmentTimestamp = appointmentTimestamp;
		this.technicianNotes = technicianNotes;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
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
