/**
 * 
 */
package repairshop.dataaccess.mapper;

import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.dataaccess.model.Device.Device;

/**
 * @author sheetal
 *
 */
public interface DeviceMapper {

	CustomerDevice selectDeviceById(int deviceId);
	
	CustomerDevice selectDeviceByDeviceName(String deviceName);
	
	CustomerDevice selectDeviceDetailsByDeviceId(int deviceId);
	
	void addDevice(Device device);
	
	void updateDevice(Device device);
	
	void deleteDevice(int deviceId);
	
}
