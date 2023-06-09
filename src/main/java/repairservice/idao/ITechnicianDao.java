package repairservice.idao;

import java.util.List;

import repairservice.model.Technician;

public interface ITechnicianDao extends IDAO<Technician> {

	@Override
	Technician create(Technician technician);

	Technician getById(int id);

	@Override
	List<Technician> getAll();

	@Override
	Technician update(Technician technician);

	@Override
	int delete(int id);

}
