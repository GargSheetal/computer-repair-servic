package repairshop.dataaccess.model.WorkRequest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkRequestDaoImpl implements IWorkRequestDao {
    // create
    public int create(Connection connection, WorkRequest workRequest) throws SQLException {
        int generatedId = -1;
        String query = "INSERT into work_requests (work_type_id, customer_device_id, work_request_description, created_timestamp, last_updated_timestamp) values(?, ?, ?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, workRequest.getWorkType().getWorkTypeId());
            ps.setInt(2, workRequest.getCustomerDevice().getCustomerDeviceId());
            ps.setString(3,  workRequest.getWorkRequestDescription());
            ps.setDate(4,  (Date) workRequest.getCreatedTimestamp());
            ps.setDate(5,  (Date) workRequest.getLastUpdatedTimestamp());

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
    public WorkRequest getById(Connection connection, int workRequestId) throws SQLException {
        WorkRequest workRequest = null;
        String query = "SELECT * from work_requests where work_request_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workRequestId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    WorkRequestAdapter workRequestAdapter = new WorkRequestAdapter();
                    workRequest = workRequestAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return workRequest;
    }

    // getAll
    public List<WorkRequest> getAll(Connection connection) throws SQLException {
        List<WorkRequest> workRequestList = new ArrayList<>();
        String query = "SELECT * from work_requests"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
            while (resultSet.next()) {
                WorkRequestAdapter workRequestAdapter = new WorkRequestAdapter();
                WorkRequest workRequest = workRequestAdapter.adaptFromDb(resultSet);
                workRequestList.add(workRequest);
            }
        }
        return workRequestList;
    }
    
    // getAllByCustomerId
    public List<WorkRequest> getAllByCustomerId(Connection connection, int customerId) throws SQLException {
        List<WorkRequest> workRequestList = new ArrayList<>();
        String query = "SELECT wr.* from work_requests wr, customer_devices cd WHERE cd.customerId= ? AND cd.customer_device_id = wr.customer_device_id"; 

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
                    WorkRequestAdapter workRequestAdapter = new WorkRequestAdapter();
                    WorkRequest workRequest = workRequestAdapter.adaptFromDb(resultSet);
                    workRequestList.add(workRequest);
                }
            }
            
        }
        return workRequestList;
    }

    // updateById
    public int updateById(Connection connection, WorkRequest workRequest) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE work_requests SET work_request_description=?, last_updated_timestamp=?, completed_timestamp=? WHERE work_request_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, workRequest.getWorkRequestDescription());
            ps.setDate(2, (Date) workRequest.getLastUpdatedTimestamp());
            ps.setDate(3, (Date) workRequest.getCompletedTimestamp());
            ps.setInt(4, workRequest.getWorkRequestId());
            
            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int workRequestId) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE from work_requests WHERE work_request_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, workRequestId);
            
            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }
}