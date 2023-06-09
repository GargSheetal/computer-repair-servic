package repairservice.idao;

import java.util.List;

import repairservice.model.WorkRequestPayment;

public interface IWorkRequestPaymentDao extends IDAO<WorkRequestPayment> {

	@Override
	WorkRequestPayment create(WorkRequestPayment payment);

	WorkRequestPayment getById(int id);

	@Override
	List<WorkRequestPayment> getAll();

	@Override
	WorkRequestPayment update(WorkRequestPayment payment);

	@Override
	int delete(int id);

	
}
