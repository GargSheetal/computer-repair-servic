package repairservice.idao;

import java.util.List;

import repairservice.model.DeviceType;

public interface IDeviceTypeDao extends IDAO<DeviceType>{

	@Override
	DeviceType create(DeviceType deviceType);

	DeviceType getById(int id);

	@Override
	List<DeviceType> getAll();

	@Override
	DeviceType update(DeviceType deviceType);

	@Override
	int delete(int id);
	
}
