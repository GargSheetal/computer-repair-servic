package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IDeviceDao;
import repairservice.model.Device;
import repairservice.model.DeviceType;

public class DeviceDaoImpl implements IDeviceDao{

	ResultSet rs = null;
	Device device = null;
	
	@Override
	public Device create(Device device) {
		String query = "INSERT into devices(device_id, device_name, device_type_id) values(?,?,?)";
		// get connection
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement statement = conn.prepareStatement(query)) {
			
			statement.setInt(1, device.getDeviceId());
			statement.setString(2, device.getDeviceName());
			statement.setInt(3, device.getDeviceType().getDeviceTypeId());
			
			// execute query
			int rowsAffected = statement.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating Device: " + e.getMessage());
			e.printStackTrace();
		}
		return device;	
	}

	@Override
	public Device getById(int deviceId) {
		String query = "SELECT * from devices WHERE device_id = ?";
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement statement = conn.prepareStatement(query)) {
			
			statement.setInt(1, deviceId);
			rs = statement.executeQuery();
			
			// create a Device object and populate its data
			if(rs.next()) {
				device = new Device();
				device.setDeviceId(rs.getInt("device_id"));
				device.setDeviceName(rs.getString("device_name"));
				device.getDeviceType().setDeviceTypeId(rs.getInt("device_type_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving Device: " + e.getMessage());
			e.printStackTrace();
		}
		return device;
	}

	@Override
	public List<Device> getAll() {
		List<Device> deviceList = new ArrayList<>();
		DeviceTypeDaoImpl deviceCategoryDaoImpl = new DeviceTypeDaoImpl();
		
		String query = "SELECT * from devices";
		try(Connection conn = ConnectionPool.getConnection();
			   PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int deviceId = rs.getInt("device_id");
				String deviceName = rs.getString("device_name");
	            int deviceCategoryId = rs.getInt("device_type_id");
	            DeviceType category = deviceCategoryDaoImpl.getById(deviceCategoryId);
	            device = new Device(deviceId, deviceName, category);
				deviceList.add(device);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving Devices: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceList;
	}

	@Override
	public Device update(Device device) {
		String query = "UPDATE devices SET device_name=?, device_type_id=? WHERE device_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, device.getDeviceName());
			ps.setInt(2, device.getDeviceType().getDeviceTypeId());
			
			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating Device: " + e.getMessage());
			e.printStackTrace();
		}
		return device;
	}

	@Override
	public int delete(int deviceId) {
		String query = "DELETE from devices WHERE device_id=?";
		try (Connection conn = ConnectionPool.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, deviceId);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
			 if(count>0) {
					System.out.println("Device with ID: " + deviceId + " deleted successfully");
				} 
				else {
					System.out.println("No Device with ID: " + deviceId + " found");
				}
		} catch (SQLException e) {
			System.out.println("Error deleting Device: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceId;
	}
	
}
