package repairservice.idao;

import java.util.List;

import repairservice.model.Device;

public interface IDeviceDao extends IDAO<Device> {

	@Override
	Device create(Device device);

	@Override
	Device getById(int id);

	@Override
	List<Device> getAll();

	@Override
	Device update(Device device);

	@Override
	int delete(int id);

	
}
