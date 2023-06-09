package repairservice.service;

import java.util.List;

import repairservice.daoimpl.WorkRequestAppointmentDaoImpl;
import repairservice.model.WorkRequestAppointment;

public class WorkRequestAppointmantService {

	private WorkRequestAppointmentDaoImpl workRequestAppointmentDaoImpl;

	public WorkRequestAppointmantService(WorkRequestAppointmentDaoImpl workRequestAppointmentDaoImpl) {
		this.workRequestAppointmentDaoImpl = workRequestAppointmentDaoImpl;
	}
	
	public WorkRequestAppointment create(WorkRequestAppointment appointment) {
		return workRequestAppointmentDaoImpl.create(appointment);
	}
	
	public WorkRequestAppointment getById(int appointmentId) {
		return workRequestAppointmentDaoImpl.getById(appointmentId);
	}
	
	public List<WorkRequestAppointment> getAll() {
		return workRequestAppointmentDaoImpl.getAll();
	}
	
	public WorkRequestAppointment update(WorkRequestAppointment appointment) {
		return workRequestAppointmentDaoImpl.update(appointment);
	}
	
	public int delete(int appointmentId) {
		workRequestAppointmentDaoImpl.delete(appointmentId);
		return appointmentId;
	}
	
	
}
