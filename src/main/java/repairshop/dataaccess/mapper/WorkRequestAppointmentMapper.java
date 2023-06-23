package repairshop.dataaccess.mapper;

import java.util.Date;

import repairshop.dataaccess.model.WorkRequestAppointment.WorkRequestAppointment;

public interface WorkRequestAppointmentMapper {
	
	WorkRequestAppointment selectWorkRequestAppointmentById(int workRequestAppointmentId);
	
	WorkRequestAppointment selectWorkRequestAppointmentByAppointmentTimestamp(Date appointmentTimestamp);
	
	void addWorkRequestAppointment(WorkRequestAppointment workRequestAppointment);
	
	void updateWorkRequestAppointment(WorkRequestAppointment workRequestAppointment);
	
	void deleteWorkRequestAppointment(int workRequestAppointmentId);

}
