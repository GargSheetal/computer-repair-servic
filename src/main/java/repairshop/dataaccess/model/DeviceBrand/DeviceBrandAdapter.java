package repairshop.dataaccess.model.DeviceBrand;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class DeviceBrandAdapter{
	
    public DeviceBrand adaptFromDb(ResultSet record) throws SQLException {
        DeviceBrand deviceBrand = new DeviceBrand();
        deviceBrand.setDeviceBrandId(record.getInt("device_brand_id"));
        deviceBrand.setBrandName(record.getString("brand_name"));
        return deviceBrand;
    }
}

