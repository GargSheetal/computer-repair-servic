package repairshop.dataaccess.model.DeviceBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeviceBrandDaoImpl implements IDeviceBrandDao {
	
	// create
	public int create(Connection connection, DeviceBrand deviceBrand) throws SQLException {
		int generatedId = -1;
		String command = "INSERT into device_brands (brand_name) values(?)";
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, deviceBrand.getBrandName());

			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()) {
	            if (resultSet.next()) {
	            	generatedId = resultSet.getInt(1);
	            }
	        }
		}
		return generatedId;
	}

	
	// getById
	public DeviceBrand getById(Connection connection, int deviceBrandId) throws SQLException {
		DeviceBrand deviceBrand = null;
		String query = "SELECT * from device_brands where device_brand_id=?";
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, deviceBrandId);
			
			try(ResultSet resultSet = ps.executeQuery()){
				if (resultSet.next()) {
					DeviceBrandAdapter deviceBrandAdapter = new DeviceBrandAdapter();
		            deviceBrand = deviceBrandAdapter.adaptFromDb(resultSet);
		        }
			}
	        
		}
		return deviceBrand;
	}

	// getAll
	public List<DeviceBrand> getAll(Connection connection) throws SQLException {
		List<DeviceBrand> deviceBrandList = new ArrayList<>();
		String query = "SELECT * from device_brands"; 

		try(
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
		) {
			DeviceBrandAdapter deviceBrandAdapter = new DeviceBrandAdapter();
			while(resultSet.next())
			{
				DeviceBrand deviceBrand = deviceBrandAdapter.adaptFromDb(resultSet);
				deviceBrandList.add(deviceBrand);
			}
		}
		return deviceBrandList;
	}


	// updateById
	public int updateById(Connection connection, DeviceBrand deviceBrand) throws SQLException {
		int updatedId = -1;
		String command = "UPDATE device_brands SET brand_name=? WHERE device_brand_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, deviceBrand.getBrandName());
			ps.setInt(2, deviceBrand.getDeviceBrandId());
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()){
		        if (resultSet.next()) {
		        	updatedId = resultSet.getInt(1);
		        }
	        }
		}
		return updatedId;
	}


	// deleteById
	public int deleteById(Connection connection, int deviceBrandId) throws SQLException {
		int deletedId = -1;
		String command = "DELETE from device_brands WHERE device_brand_id = ?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
			ps.setInt(1, deviceBrandId);
			
			int rowsAffected = ps.executeUpdate();
	        System.out.println("\n" + rowsAffected + " row/s affected");
	        
	        try(ResultSet resultSet = ps.getGeneratedKeys()){
		        if (resultSet.next()) {
		        	deletedId = resultSet.getInt(1);
		        }
	        }
		}
		return deletedId;
	}

}
