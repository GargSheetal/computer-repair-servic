package repairservice.service;

import java.util.List;

import repairservice.daoimpl.WorkTypeDaoImpl;
import repairservice.model.WorkType;

public class WorkTypeService {

	private WorkTypeDaoImpl workTypeDaoImpl;

	public WorkTypeService(WorkTypeDaoImpl workTypeDaoImpl) {
		this.workTypeDaoImpl = workTypeDaoImpl;
	}
	
	public WorkType create(WorkType workType) {
		return workTypeDaoImpl.create(workType);
	}
	
	public WorkType getById(int workTypeId) {
		return workTypeDaoImpl.getById(workTypeId);
	}
	
	public List<WorkType> getAll() {
		return workTypeDaoImpl.getAll();
	}
	
	public WorkType update(WorkType workType) {
		return workTypeDaoImpl.update(workType);
	}
	
	public int delete(int workTypeId) {
		workTypeDaoImpl.delete(workTypeId);
		return workTypeId;
	}
}
