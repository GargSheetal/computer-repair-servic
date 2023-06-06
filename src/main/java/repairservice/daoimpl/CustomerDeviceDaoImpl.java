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

	@Override
	public CustomerDevice create(CustomerDevice custDevice) {
		String query = "INSERT into customer_device('serial_number', 'customer_id', 'device_id') values(?,?,?)";
		// get connection
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setInt(1, custDevice.getSerialNumber());
			ps.setInt(2, custDevice.getCustomer().getCustomerId());
			ps.setInt(3, custDevice.getDevice().getDeviceId());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating customer device: " + e.getMessage());
			e.printStackTrace();
		}
		return custDevice;
	}

	@Override
	public CustomerDevice getById(int id) {
		String query = "SELECT * from customer_device where customer_device_id=?"; 
		
		ResultSet rs = null;
		CustomerDevice custDevice = null;
			try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setInt(1, id);
				// execute the query
				rs = ps.executeQuery();
				
				// create a customer object and populate its data
				if(rs.next()) {
					custDevice = new CustomerDevice();
					custDevice.setCustomerDeviceId(rs.getInt("customer_device_id"));
					custDevice.setSerialNumber(rs.getInt("serial_number"));
					custDevice.getCustomer().setCustomerId(rs.getInt("customer_id"));
					custDevice.getDevice().setDeviceId(rs.getInt("device_id"));
				}
			} catch (SQLException e) {
				System.out.println("Error retrieving customer device: " + e.getMessage());
				e.printStackTrace();
			}
			return custDevice;
	}

	@Override
	public List<CustomerDevice> getAll() {
		List<CustomerDevice> custDeviceList = new ArrayList<>();
		CustomerDevice custDevice = null;
		CustomerDaoImpl custDaoImpl = null;
		DeviceDaoImpl deviceDaoImpl = null;
		String query = "SELECT * from customer_device"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				int customerDeviceId = rs.getInt("customer_device_id");
	            int serialNumber = rs.getInt("serial_number");
	            int customerId = rs.getInt("customer_id");
	            int deviceId = rs.getInt("device_id");
	          
	            Customer customer = custDaoImpl.getById(deviceId);
	            Device device = deviceDaoImpl.getById(deviceId);
				custDevice = new CustomerDevice(customerDeviceId, serialNumber, customer, device);
				custDeviceList.add(custDevice);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving customers: " + e.getMessage());
			e.printStackTrace();
		}
		return custDeviceList;
	}

	@Override
	public CustomerDevice update(CustomerDevice custDevice) {
		String query = "UPDATE customer_device SET serial_number=?, customer_id=?, device_id=? WHERE id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setInt(1, custDevice.getSerialNumber());
			ps.setInt(2, custDevice.getCustomer().getCustomerId());
			ps.setInt(3, custDevice.getDevice().getDeviceId());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating customer device: " + e.getMessage());
			e.printStackTrace();
		}
		return custDevice;
	}

	@Override
	public int delete(int id) {
		String query = "DELETE from customer_device WHERE id=?";
		try (Connection conn = ConnectionPool.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, id);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error deleting customer device: " + e.getMessage());
			e.printStackTrace();
		}
		return id;
	}

}
