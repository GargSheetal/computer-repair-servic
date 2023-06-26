package repairshop.dataaccess.mapper;

import repairshop.dataaccess.model.DeviceType.DeviceType;

public interface DeviceTypeMapper {
	
	DeviceType selectDeviceTypeById(int deviceTypeId);
	
	DeviceType selectDeviceTypeByDeviceTypeName(String deviceTypeName);
	
	DeviceType selectDeviceTypeDetailsById(int deviceTypeId);
	
	void addDeviceType(DeviceType deviceType);
	
	void updateDeviceType(DeviceType deviceType);
	
	void deleteDeviceTypeById(int deviceTypeId);

}
