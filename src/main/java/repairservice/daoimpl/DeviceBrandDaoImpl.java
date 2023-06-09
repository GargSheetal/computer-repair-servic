package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IDeviceBrandDao;
import repairservice.model.DeviceBrand;

public class DeviceBrandDaoImpl implements IDeviceBrandDao {

	@Override
	public DeviceBrand create(DeviceBrand brand) {
		String query = "INSERT into device_brand('brand_name') values(?)";
		// get connection
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, brand.getBrandName());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating deviceBrand: " + e.getMessage());
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public DeviceBrand getById(int deviceBrandId) {
		String query = "SELECT * from device_brand where device_brand_id=?"; 
		
		ResultSet rs = null;
		DeviceBrand brand = null;
			try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setInt(1, deviceBrandId);
				// execute the query
				rs = ps.executeQuery();
				
				// create a DeviceBrand object and populate its data
				if(rs.next()) {
					brand = new DeviceBrand();
					brand.setDeviceBrandId(rs.getInt("device_brand_id"));
					brand.setBrandName(rs.getString("brand_name"));
				}
			} catch (SQLException e) {
				System.out.println("Error retrieving deviceBrand: " + e.getMessage());
				e.printStackTrace();
			}
			return brand;
	}

	@Override
	public List<DeviceBrand> getAll() {
		List<DeviceBrand> devBrandList = new ArrayList<>();
		DeviceBrand brand = null;
		String query = "SELECT * from device_brand"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				brand = new DeviceBrand(rs.getInt("device_brand_id"), rs.getString("brand_name"));
				devBrandList.add(brand);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving deviceBrands: " + e.getMessage());
			e.printStackTrace();
		}
		return devBrandList;
	}

	@Override
	public DeviceBrand update(DeviceBrand brand) {
		String query = "UPDATE device_brand SET brand_name=? WHERE device_brand_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, brand.getBrandName());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating deviceBrand: " + e.getMessage());
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public int delete(int deviceBrandId) {
		String query = "DELETE from device_brand WHERE device_brand_id=?";
		try (Connection conn = ConnectionPool.getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {
			 ps.setInt(1, deviceBrandId);
			 int count = ps.executeUpdate();
			 System.out.println(count + " row/s affected");
			 if(count>0) {
					System.out.println("DeviceBrand with ID: " + deviceBrandId + " deleted successfully");
				} 
				else {
					System.out.println("No DeviceBrand with ID: " + deviceBrandId + " found");
				}
		} catch (SQLException e) {
			System.out.println("Error deleting deviceBrand: " + e.getMessage());
			e.printStackTrace();
		}
		return deviceBrandId;
	}

}
