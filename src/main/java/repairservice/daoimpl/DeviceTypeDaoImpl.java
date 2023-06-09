package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IDeviceTypeDao;
import repairservice.model.DeviceBrand;
import repairservice.model.DeviceType;

public class DeviceTypeDaoImpl implements IDeviceTypeDao{

	ResultSet rs = null;
	DeviceType deviceType = null;
	
	@Override
	public DeviceType create(DeviceType deviceType) {
		String query = "INSERT into device_type(device_type_id, device_type_name, device_brand_id) values(?,?,?)";
		// get connection
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement statement = conn.prepareStatement(query)) {
			
			statement.setInt(1, deviceType.getDeviceTypeId());
			statement.setString(2, deviceType.getDeviceTypeName());
			statement.setInt(3, deviceType.getDeviceBrand().getDeviceBrandId());
			
			// execute query
			int rowsAffected = statement.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating deviceType: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceType;	
	}

	@Override
	public DeviceType getById(int id) {
		String query = "SELECT * from device_type WHERE device_type_id = ?";
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement statement = conn.prepareStatement(query)) {
			
			statement.setInt(1, id);
			rs = statement.executeQuery();
			
			// create a DeviceType object and populate its data
			if(rs.next()) {
				deviceType = new DeviceType();
				deviceType.setDeviceTypeId(rs.getInt("device_type_id"));
				deviceType.setDeviceTypeName(rs.getString("device_type_name"));
				deviceType.getDeviceBrand().setDeviceBrandId(rs.getInt("device_brand_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving deviceType: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceType;
	}

	@Override
	public List<DeviceType> getAll() {
		List<DeviceType> devTypeList = new ArrayList<>();
		DeviceBrandDaoImpl deviceBrandDaoImpl = new DeviceBrandDaoImpl();
		String query = "SELECT * from device_type";
		try(Connection conn = ConnectionPool.getConnection();
			   PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int deviceTypeId = rs.getInt("device_type_id");
				String deviceTypeName = rs.getString("device_type_name");
	            int deviceBrandId = rs.getInt("device_brand_id");
	            DeviceBrand brand = deviceBrandDaoImpl.getById(deviceBrandId);
	            deviceType = new DeviceType(deviceTypeId, deviceTypeName, brand);
	            devTypeList.add(deviceType);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving deviceTypes: " + e.getMessage());
			e.printStackTrace();
		}
		return devTypeList;
	}

	@Override
	public DeviceType update(DeviceType deviceType) {
		String query = "UPDATE device_type SET device_type_name=?, device_brand_id=? WHERE device_type_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, deviceType.getDeviceTypeName());
			ps.setInt(2, deviceType.getDeviceBrand().getDeviceBrandId());
			
			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating deviceType: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceType;
	}

	@Override
	public int delete(int deviceTypeId) {
		String query = "DELETE from device_type WHERE device_type_id=?";
		try (Connection conn = ConnectionPool.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, deviceTypeId);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
			 if(count>0) {
					System.out.println("DeviceType with ID: " + deviceTypeId + " deleted successfully");
				} 
				else {
					System.out.println("No DeviceType with ID: " + deviceTypeId + " found");
				}
		} catch (SQLException e) {
			System.out.println("Error deleting deviceType: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceTypeId;
	}

	
}
