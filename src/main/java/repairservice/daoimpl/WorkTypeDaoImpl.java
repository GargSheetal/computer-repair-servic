package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IWorkTypeDao;
import repairservice.model.Device;
import repairservice.model.WorkType;

public class WorkTypeDaoImpl implements IWorkTypeDao {

	ResultSet rs = null;
	WorkType workType = null;
	
	@Override
	public WorkType create(WorkType workType) {
		
		String query = "INSERT into work_types(work_description, price, device_id) values(?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, workType.getWorkDescription());
			ps.setDouble(2, workType.getPrice());
			ps.setInt(3, workType.getDevice().getDeviceId());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating workType: " + e.getMessage());
			e.printStackTrace();
		}
		return workType;
	}

	@Override
	public WorkType getById(int workTypeId) {
		String query = "SELECT * from work_types where work_type_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workTypeId);
			// execute the query
			rs = ps.executeQuery();

			// create a WorkType object and populate its data
			if(rs.next()) {
				workType = new WorkType();
				workType.setWorkDescription(rs.getString("work_description"));
				workType.setPrice(rs.getDouble("price"));
				workType.getDevice().setDeviceId(rs.getInt("device_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workType: " + e.getMessage());
			e.printStackTrace();
		}
		return workType;
	}

	@Override
	public List<WorkType> getAll() {
		List<WorkType> workTypeList = new ArrayList<>();
		DeviceDaoImpl deviceDaoImpl = new DeviceDaoImpl();
		String query = "SELECT * from work_types"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int workTypeId = rs.getInt("work_type_id");
				String workDescription = rs.getString("work_description");
				double price = rs.getDouble("price");
	            int deviceId = rs.getInt("device_id");
	          
	            Device device = deviceDaoImpl.getById(deviceId);
	            workType = new WorkType(workTypeId, workDescription, price, device);
	            workTypeList.add(workType);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workTypes: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeList;
	}

	@Override
	public WorkType update(WorkType workType) {
		String query = "UPDATE work_types SET work_description=?, price=?, device_id=?, WHERE work_type_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, workType.getWorkDescription());
			ps.setDouble(2, workType.getPrice());
			ps.setInt(3, workType.getDevice().getDeviceId());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating workType: " + e.getMessage());
			e.printStackTrace();
		}
		return workType;
	}

	@Override
	public int delete(int workTypeId) {
		String query = "DELETE from work_types WHERE work_type_id=?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workTypeId);
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
			if(count>0) {
				System.out.println("WorkType with ID: " + workTypeId + " deleted successfully");
			} 
			else {
				System.out.println("No workType with ID: " + workTypeId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting workType: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeId;
	}

}
