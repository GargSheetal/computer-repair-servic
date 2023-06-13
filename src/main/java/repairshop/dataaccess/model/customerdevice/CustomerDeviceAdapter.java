package repairshop.dataaccess.model.CustomerDevice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDeviceAdapter {

	public CustomerDevice adaptFromDb(ResultSet record) throws SQLException {
		CustomerDevice customerDevice = new CustomerDevice();
		customerDevice.setCustomerDeviceId(record.getInt("customer_device_id"));
		customerDevice.setSerialNumber(record.getString("serial_number"));
		customerDevice.getCustomer().setCustomerId(record.getInt("customer_id"));
		customerDevice.getDevice().setDeviceId(record.getInt("device_id"));
		return customerDevice;
	}
}
