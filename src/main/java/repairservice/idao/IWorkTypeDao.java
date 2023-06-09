package repairservice.idao;

import java.util.List;

import repairservice.model.WorkType;

public interface IWorkTypeDao extends IDAO<WorkType> {

	@Override
	WorkType create(WorkType workType);

	WorkType getById(int id);

	@Override
	List<WorkType> getAll();

	@Override
	WorkType update(WorkType workType);

	@Override
	int delete(int id);

}
