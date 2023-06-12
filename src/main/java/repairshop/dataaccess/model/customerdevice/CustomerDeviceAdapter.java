package repairshop.dataaccess.model.customerdevice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDeviceAdapter {

	public CustomerDevice adaptFromDb(ResultSet record) throws SQLException {
		CustomerDevice custDevice = new CustomerDevice();
		custDevice.setCustomerDeviceId(record.getInt("customer_device_id"));
		custDevice.setSerialNumber(record.getString("serial_number"));
		custDevice.getCustomer().setCustomerId(record.getInt("customer_id"));
		custDevice.getDevice().setDeviceId(record.getInt("device_id"));
		return custDevice;
	}
}
