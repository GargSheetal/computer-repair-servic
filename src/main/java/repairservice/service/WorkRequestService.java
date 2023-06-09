package repairservice.service;

import java.util.List;

import repairservice.daoimpl.WorkRequestDaoImpl;
import repairservice.model.WorkRequest;

public class WorkRequestService {

	private WorkRequestDaoImpl workRequestDaoImpl;

	public WorkRequestService(WorkRequestDaoImpl workRequestDaoImpl) {
		this.workRequestDaoImpl = workRequestDaoImpl;
	}
	
	public WorkRequest create(WorkRequest workRequest) {
		return workRequestDaoImpl.create(workRequest);
	}
	
	public WorkRequest getById(int workRequestId) {
		return workRequestDaoImpl.getById(workRequestId);
	}
	
	public List<WorkRequest> getAll() {
		return workRequestDaoImpl.getAll();
	}
	
	public WorkRequest update(WorkRequest workRequest) {
		return workRequestDaoImpl.update(workRequest);
	}
	
	public int delete(int workRequestId) {
		workRequestDaoImpl.delete(workRequestId);
		return workRequestId;
	}
}
