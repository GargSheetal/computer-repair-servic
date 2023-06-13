package repairshop.dataaccess.model.DeviceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeviceTypeDaoImpl implements IDeviceTypeDao {
    // create
    public int create(Connection connection, DeviceType deviceType) throws SQLException {
        int generatedId = -1;
        String command = "INSERT into device_types (device_type_name, device_brand_id) values(?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, deviceType.getDeviceTypeName());
            ps.setInt(2, deviceType.getDeviceBrand().getDeviceBrandId());

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
    public DeviceType getById(Connection connection, int deviceTypeId) throws SQLException {
        DeviceType deviceType = null;
        String query = "SELECT * from device_types where device_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceTypeId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    DeviceTypeAdapter deviceTypeAdapter = new DeviceTypeAdapter();
                    deviceType = deviceTypeAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return deviceType;
    }

    // getAll
    public List<DeviceType> getAll(Connection connection) throws SQLException {
        List<DeviceType> deviceTypeList = new ArrayList<>();
        String query = "SELECT * from device_types"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
            while (resultSet.next()) {
                DeviceTypeAdapter deviceTypeAdapter = new DeviceTypeAdapter();
                DeviceType deviceType = deviceTypeAdapter.adaptFromDb(resultSet);
                deviceTypeList.add(deviceType);
            }
        }
        return deviceTypeList;
    }

    // getAllByDeviceBrandId
    public List<DeviceType> getAllByDeviceBrandId(Connection connection, int deviceBrandId) throws SQLException {
        List<DeviceType> deviceTypeList = new ArrayList<>();
        String query = "SELECT * from device_types WHERE device_brand_id = ?"; 

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceBrandId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
                    DeviceTypeAdapter deviceTypeAdapter = new DeviceTypeAdapter();
                    DeviceType deviceType = deviceTypeAdapter.adaptFromDb(resultSet);
                    deviceTypeList.add(deviceType);
                }
            }
            
        }
        return deviceTypeList;
    }
    
    // updateById
    public int updateById(Connection connection, DeviceType deviceType) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE device_types SET device_type_name=? WHERE device_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, deviceType.getDeviceTypeName());
            ps.setInt(2, deviceType.getDeviceTypeId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int deviceTypeId) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE FROM device_types WHERE device_type_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, deviceTypeId);

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }
}