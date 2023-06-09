package repairservice.idao;

import java.util.List;

import repairservice.model.WorkRequest;

public interface IWorkRequestDao extends IDAO<WorkRequest> {

	@Override
	WorkRequest create(WorkRequest request);

	WorkRequest getById(int id);

	@Override
	List<WorkRequest> getAll();

	@Override
	WorkRequest update(WorkRequest request);

	@Override
	int delete(int id);
	
	
}
