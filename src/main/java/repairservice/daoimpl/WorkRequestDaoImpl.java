package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IWorkRequestDao;
import repairservice.model.CustomerDevice;
import repairservice.model.DeviceBrandService;
import repairservice.model.WorkRequest;
import repairservice.model.WorkType;

public class WorkRequestDaoImpl implements IWorkRequestDao {

	ResultSet rs = null;
	WorkRequest request = null;
	
	@Override
	public WorkRequest create(WorkRequest request) {
		String query = "INSERT into work_requests(work_type_id, customer_device_id, created_timestamp, last_updated_timestamp, "
				+ "completed_timestamp, amount, work_request_description) values(?,?,?,?,?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setInt(1, request.getWorkType().getWorkTypeId());
			ps.setInt(2, request.getCustomerDevice().getCustomerDeviceId());
			
			// Set the appointment timestamp using setDate()
			Date createdTimestamp = new Date(request.getCreatedTimestamp().getTime());
			ps.setDate(3, createdTimestamp);
			
			Date lastUpdatedTimestamp = new Date(request.getLastUpdatedTimestamp().getTime());
			ps.setDate(4, lastUpdatedTimestamp);
			
			Date completedTimestamp = new Date(request.getCompletedTimestamp().getTime());
			ps.setDate(5, completedTimestamp);
			ps.setDouble(6, request.getAmount());
			ps.setString(7, request.getWorkRequestDescription());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating workRequest: " + e.getMessage());
			e.printStackTrace();
		}
		return request;
	}

	@Override
	public WorkRequest getById(int id) {
		String query = "SELECT * from work_requests where work_request_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			// execute the query
			rs = ps.executeQuery();

			// create a WorkRequest object and populate its data
			if(rs.next()) {
				request = new WorkRequest();
				request.getWorkType().setWorkTypeId(rs.getInt("work_type_id"));
				request.getCustomerDevice().setCustomerDeviceId(rs.getInt("customer_device_id"));
				request.setCreatedTimestamp(rs.getDate("created_timestamp"));
				request.setLastUpdatedTimestamp(rs.getDate("last_updated_timestamp"));
				request.setCompletedTimestamp(rs.getDate("completed_timestamp"));
				request.setAmount(rs.getDouble("amount"));
				request.setWorkRequestDescription(rs.getString("work_request_description"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequest: " + e.getMessage());
			e.printStackTrace();
		}
		return request;
	}

	@Override
	public List<WorkRequest> getAll() {
		List<WorkRequest> requestList = new ArrayList<>();
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		CustomerDeviceDaoImpl customerDeviceDaoImpl = new CustomerDeviceDaoImpl();
		String query = "SELECT * from work_requests"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int workRequestId = rs.getInt("work_request_id");
				int workTypeId = rs.getInt("work_type_id");
				int custDeviceId = rs.getInt("customer_device_id");
				Date createdTimestamp = rs.getDate("created_timestamp");
	            Date lastUpdatedTimestamp = rs.getDate("last_updated_timestamp");
	            Date completedTimestamp = rs.getDate("completed_timestamp");
	            double amount = rs.getDouble("amount");
	            String workRequestDescription = rs.getString("work_request_description");
	          
	            WorkType workType = workTypeDaoImpl.getById(workTypeId);
	            CustomerDevice customerDevice = customerDeviceDaoImpl.getById(custDeviceId);
	            request = new WorkRequest(workRequestId, workType, customerDevice, createdTimestamp, lastUpdatedTimestamp, completedTimestamp, amount, workRequestDescription);
	            requestList.add(request);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequests: " + e.getMessage());
			e.printStackTrace();
		}
		return requestList;
	}

	@Override
	public WorkRequest update(WorkRequest request) {
		String query = "UPDATE work_requests SET work_type_id=?, customer_device_id=?, created_timestamp=?, last_updated_timestamp=?, completed_timestamp=?, amount=?, work_request_description=? WHERE work_request_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setInt(1, request.getWorkType().getWorkTypeId());
			ps.setInt(2, request.getCustomerDevice().getCustomerDeviceId());
			
			// Set the appointment timestamp using setDate()
			Date createdTimestamp = new Date(request.getCreatedTimestamp().getTime());
			ps.setDate(3, createdTimestamp);
			
			Date lastUpdatedTimestamp = new Date(request.getLastUpdatedTimestamp().getTime());
			ps.setDate(4, lastUpdatedTimestamp);
			
			Date completedTimestamp = new Date(request.getCompletedTimestamp().getTime());
			ps.setDate(5, completedTimestamp);
			
			ps.setDouble(6, request.getAmount());
			ps.setString(7, request.getWorkRequestDescription());

			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating workRequest: " + e.getMessage());
			e.printStackTrace();
		}
		return request;
	}

	@Override
	public int delete(int workRequestId) {
		String query = "DELETE from work_requests WHERE work_request_id=?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workRequestId);
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
			if(count>0) {
				System.out.println("WorkRequest with ID: " + workRequestId + " deleted successfully");
			} 
			else {
				System.out.println("No workRequest with ID: " + workRequestId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting workRequest: " + e.getMessage());
			e.printStackTrace();
		}
		return workRequestId;
	}

	
}
