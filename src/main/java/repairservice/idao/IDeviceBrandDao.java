package repairservice.idao;

import java.util.List;

import repairservice.model.DeviceBrand;

public interface IDeviceBrandDao extends IDAO<DeviceBrand> {

	@Override
	DeviceBrand create(DeviceBrand brand);

	DeviceBrand getById(int id);

	@Override
	List<DeviceBrand> getAll();

	@Override
	DeviceBrand update(DeviceBrand brand);

	@Override
	int delete(int id);
	
}
