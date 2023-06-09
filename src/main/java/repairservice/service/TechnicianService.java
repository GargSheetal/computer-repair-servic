package repairservice.service;

import java.util.List;

import repairservice.daoimpl.TechnicianDaoImpl;
import repairservice.model.Technician;

public class TechnicianService {

	private TechnicianDaoImpl technicianDaoImpl;

	public TechnicianService(TechnicianDaoImpl technicianDaoImpl) {
		this.technicianDaoImpl = technicianDaoImpl;
	}
	
	public Technician create(Technician technician) {
		return technicianDaoImpl.create(technician);
	}
	
	public Technician getById(int technicianId) {
		return technicianDaoImpl.getById(technicianId);
	}
	
	public List<Technician> getAll() {
		return technicianDaoImpl.getAll();
	}
	
	public Technician update(Technician technician) {
		return technicianDaoImpl.update(technician);
	}
	
	public int delete(int technicianId) {
		technicianDaoImpl.delete(technicianId);
		return technicianId;
	}
	
}
