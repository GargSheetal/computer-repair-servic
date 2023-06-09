package repairservice.service;

import java.util.List;

import repairservice.daoimpl.WorkTypeTechnicianDaoImpl;
import repairservice.model. WorkTypeTechnician;

public class WorkTypeTechnicianService {

	private WorkTypeTechnicianDaoImpl workTypeTechnicianDaoImpl;

	public WorkTypeTechnicianService(WorkTypeTechnicianDaoImpl workTypeTechnicianDaoImpl) {
		this.workTypeTechnicianDaoImpl = workTypeTechnicianDaoImpl;
	}
	
	public  WorkTypeTechnician create( WorkTypeTechnician workTypeTech) {
		return workTypeTechnicianDaoImpl.create(workTypeTech);
	}
	
	public  WorkTypeTechnician getByWorkType(int workTypeTechId) {
		return workTypeTechnicianDaoImpl.getByWorkType(workTypeTechId);
	}
	
	public List< WorkTypeTechnician> getAll() {
		return workTypeTechnicianDaoImpl.getAll();
	}
	
	public  WorkTypeTechnician update( WorkTypeTechnician workTypeTech) {
		return workTypeTechnicianDaoImpl.update(workTypeTech);
	}
	
	public WorkTypeTechnician delete(WorkTypeTechnician workTypeTech) {
		workTypeTechnicianDaoImpl.delete(workTypeTech);
		return workTypeTech;
	}
}
