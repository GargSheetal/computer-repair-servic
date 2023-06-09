package repairservice.idao;

import java.util.List;

import repairservice.model.WorkRequestAppointment;

public interface IWorkRequestAppointmentDao extends IDAO<WorkRequestAppointment> {

	@Override
	WorkRequestAppointment create(WorkRequestAppointment appointment);

	WorkRequestAppointment getById(int id);

	@Override
	List<WorkRequestAppointment> getAll();

	@Override
	WorkRequestAppointment update(WorkRequestAppointment appointment);

	@Override
	int delete(int id);

	
	
}
