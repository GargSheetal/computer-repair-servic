package repairservice.idao;

import java.util.List;

import repairservice.model.CustomerDevice;

public interface ICustomerDeviceDao extends IDAO<CustomerDevice> {

	@Override
	CustomerDevice create(CustomerDevice customerDevice);

	CustomerDevice getById(int id);

	@Override
	List<CustomerDevice> getAll();

	@Override
	CustomerDevice update(CustomerDevice customerDevice);

	@Override
	int delete(int id);
	
}
