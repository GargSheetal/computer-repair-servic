package repairshop.dataaccess.model.WorkType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.model.Device.Device;
import repairshop.dataaccess.model.Device.DeviceAdapter;

public class WorkTypeDaoImpl implements IWorkTypeDao {
    // create
    public int create(Connection connection, WorkType workType) throws SQLException {
        int generatedId = -1;
        String command = "INSERT into work_types (work_description, price, device_id) values (?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, workType.getWorkDescription());
            ps.setDouble(2, workType.getPrice());
            ps.setInt(3, workType.getDevice().getDeviceId());

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
    public WorkType getById(Connection connection, int workTypeId) throws SQLException {
        WorkType workType = null;
        String query = "SELECT * from work_types where work_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workTypeId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    WorkTypeAdapter workTypeAdapter = new WorkTypeAdapter();
                    workType = workTypeAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return workType;
    }

    // getAll
    public List<WorkType> getAll(Connection connection) throws SQLException {
        List<WorkType> workTypeList = new ArrayList<>();
        String query = "SELECT * from work_types"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
            while (resultSet.next()) {
                WorkTypeAdapter workTypeAdapter = new WorkTypeAdapter();
                WorkType workType = workTypeAdapter.adaptFromDb(resultSet);
                workTypeList.add(workType);
            }
        }
        return workTypeList;
    }
    
 // getAllByDeviceId
    public List<WorkType> getAllByDeviceId(Connection connection, int deviceId) throws SQLException {
        List<WorkType> workTypeList = new ArrayList<>();
        String query = "SELECT * from work_types where device_id=?"; 

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
            		WorkTypeAdapter workTypeAdapter = new WorkTypeAdapter();
            		WorkType workType = workTypeAdapter.adaptFromDb(resultSet);
                    workTypeList.add(workType);
                }
            }
            
        }
        return workTypeList;
    }

    // updateById
    public int updateById(Connection connection, WorkType workType) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE work_types SET work_description=?, price=? WHERE work_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, workType.getWorkDescription());
            ps.setDouble(2, workType.getPrice());
            ps.setInt(3, workType.getWorkTypeId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int workTypeId) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE FROM work_types WHERE work_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, workTypeId);

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }
}