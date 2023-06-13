package repairshop.dataaccess.model.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.model.DeviceType.DeviceType;
import repairshop.dataaccess.model.DeviceType.DeviceTypeAdapter;

public class DeviceDaoImpl implements IDeviceDao {
    // create
    public int create(Connection connection, Device device) throws SQLException {
        int generatedId = -1;
        String command = "INSERT into devices (device_type_id, device_name) values(?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, device.getDeviceType().getDeviceTypeId());
            ps.setString(2, device.getDeviceName());

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
    public Device getById(Connection connection, int deviceId) throws SQLException {
        Device device = null;
        String query = "SELECT * from devices where device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);

            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    DeviceAdapter deviceAdapter = new DeviceAdapter();
                    device = deviceAdapter.adaptFromDb(resultSet);
                }
            }

        }
        return device;
    }

    // getAll
    public List<Device> getAll(Connection connection) throws SQLException {
        List<Device> deviceList = new ArrayList<>();
        String query = "SELECT * from devices"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
                while (resultSet.next()) {
                    DeviceAdapter deviceAdapter = new DeviceAdapter();
                    Device device = deviceAdapter.adaptFromDb(resultSet);
                    deviceList.add(device);
                }
            }
        return deviceList;
    }
    
    // getAllByDeviceTypeId
    public List<Device> getAllByDeviceTypeId(Connection connection, int deviceTypeId) throws SQLException {
        List<Device> deviceList = new ArrayList<>();
        String query = "SELECT * from devices WHERE device_type_id = ?"; 

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceTypeId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
                    DeviceAdapter deviceAdapter = new DeviceAdapter();
                    Device device = deviceAdapter.adaptFromDb(resultSet);
                    deviceList.add(device);
                }
            }
            
        }
        return deviceList;
    }

    // updateById
    public int updateById(Connection connection, Device device) throws SQLException {
        int rowsAffected = -1;
        String query = "UPDATE devices SET device_name=? WHERE device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)){            
            ps.setString(1, device.getDeviceName());
            ps.setInt(2, device.getDeviceId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int deviceId) throws SQLException {
        int rowsAffected = -1;
        String query = "DELETE FROM devices WHERE device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, deviceId);

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

}