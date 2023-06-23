/**
 * 
 */
package repairshop.dataaccess.mapper;

import repairshop.dataaccess.model.Device.Device;

/**
 * @author sheetal
 *
 */
public interface DeviceMapper {

	Device selectDeviceById(int deviceId);
	
	Device selectDeviceByDeviceName(String deviceName);
	
	Device selectDeviceDetailsByDeviceId(int deviceId);
	
	void addDevice(Device device);
	
	void updateDevice(Device device);
	
	void deleteDevice(int deviceId);
	
}
