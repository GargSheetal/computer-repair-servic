package repairshop.dataaccess.model.DeviceType;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class DeviceTypeAdapter{
    
    public DeviceType adaptFromDb(ResultSet record) throws SQLException {
        DeviceType deviceType = new DeviceType();
        deviceType.setDeviceTypeId(record.getInt("device_type_id"));
        deviceType.setDeviceTypeName(record.getString("device_type_name"));
        deviceType.getDeviceBrand().setDeviceBrandId(record.getInt("device_brand_id"));
        return deviceType;
    }
}