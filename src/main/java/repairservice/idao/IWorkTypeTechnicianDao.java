package repairservice.idao;

import java.util.List;

import repairservice.model.WorkTypeTechnician;

public interface IWorkTypeTechnicianDao {

	WorkTypeTechnician create(WorkTypeTechnician workTypeTechnician);

	WorkTypeTechnician getByWorkType(int workTypeId);
	
	List<WorkTypeTechnician> getAll();

	WorkTypeTechnician update(WorkTypeTechnician workTypeTechnician);

	WorkTypeTechnician delete(WorkTypeTechnician workTypeTechnician);
	
	
}
