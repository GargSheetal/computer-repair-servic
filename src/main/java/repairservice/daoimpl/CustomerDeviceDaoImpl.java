package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.ICustomerDeviceDao;
import repairservice.model.Customer;
import repairservice.model.CustomerDevice;
import repairservice.model.Device;

public class CustomerDeviceDaoImpl implements ICustomerDeviceDao {

	ResultSet rs = null;
	
	@Override
	public CustomerDevice create(CustomerDevice custDevice) {
		String query = "INSERT into customer_devices('serial_number', 'customer_id', 'device_id') values(?,?,?)";
		// get connection
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, custDevice.getSerialNumber());
			ps.setInt(2, custDevice.getCustomer().getCustomerId());
			ps.setInt(3, custDevice.getDevice().getDeviceId());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating customerDevice: " + e.getMessage());
			e.printStackTrace();
		}
		return custDevice;
	}

	@Override
	public CustomerDevice getById(int customerDeviceId) {
		String query = "SELECT * from customer_devices where customer_device_id=?"; 
		CustomerDevice custDevice = null;
			try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setInt(1, customerDeviceId);
				// execute the query
				rs = ps.executeQuery();
				
				// create a customerDevice object and populate its data
				if(rs.next()) {
					custDevice = new CustomerDevice();
					custDevice.setCustomerDeviceId(rs.getInt("customer_device_id"));
					custDevice.setSerialNumber(rs.getString("serial_number"));
					custDevice.getCustomer().setCustomerId(rs.getInt("customer_id"));
					custDevice.getDevice().setDeviceId(rs.getInt("device_id"));
				}
			} catch (SQLException e) {
				System.out.println("Error retrieving customerDevice: " + e.getMessage());
				e.printStackTrace();
			}
			return custDevice;
	}

	@Override
	public List<CustomerDevice> getAll() {
		List<CustomerDevice> custDeviceList = new ArrayList<>();
		CustomerDaoImpl custDaoImpl = new CustomerDaoImpl();
		DeviceDaoImpl deviceDaoImpl = new DeviceDaoImpl();
		
		String query = "SELECT * from customer_devices"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int customerDeviceId = rs.getInt("customer_device_id");
				String serialNumber = rs.getString("serial_number");
	            int customerId = rs.getInt("customer_id");
	            int deviceId = rs.getInt("device_id");
	          
	            Customer customer = custDaoImpl.getById(customerId);
	            Device device = deviceDaoImpl.getById(deviceId);
	            CustomerDevice custDevice = new CustomerDevice(customerDeviceId, serialNumber, customer, device);
				custDeviceList.add(custDevice);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving customerDevices: " + e.getMessage());
			e.printStackTrace();
		}
		return custDeviceList;
	}

	@Override
	public CustomerDevice update(CustomerDevice custDevice) {
		String query = "UPDATE customer_devices SET serial_number=?, customer_id=?, device_id=? WHERE customer_device_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, custDevice.getSerialNumber());
			ps.setInt(2, custDevice.getCustomer().getCustomerId());
			ps.setInt(3, custDevice.getDevice().getDeviceId());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating customerDevice: " + e.getMessage());
			e.printStackTrace();
		}
		return custDevice;
	}

	@Override
	public int delete(int customerDeviceId) {
		String query = "DELETE from customer_devices WHERE customer_device_id=?";
		try (Connection conn = ConnectionPool.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, customerDeviceId);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
			 if(count>0) {
					System.out.println("CustomerDevice with ID: " + customerDeviceId + " deleted successfully");
				} 
				else {
					System.out.println("No CustomerDevice with ID: " + customerDeviceId + " found");
				}
		} catch (SQLException e) {
			System.out.println("Error deleting customerDevice: " + e.getMessage());
			e.printStackTrace();
		}
		return customerDeviceId;
	}

}


