package repairshop.dataaccess.model.Device;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class DeviceAdapter{
        
        public Device adaptFromDb(ResultSet record) throws SQLException {
            Device device = new Device();
            device.setDeviceId(record.getInt("device_id"));
            device.getDeviceType().setDeviceTypeId(record.getInt("device_type_id"));
            device.setDeviceName(record.getString("device_name"));
            return device;
        }
}
	