package repairshop.dataaccess.model.CustomerDevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDeviceDaoImpl implements ICustomerDeviceDao {
    // create
    public int create(Connection connection, CustomerDevice customerDevice) throws SQLException {
        int generatedId = -1;
        String command = "INSERT into customer_devices (customer_id, device_id, serial_number) values(?, ?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, customerDevice.getCustomer().getCustomerId());
            ps.setInt(2, customerDevice.getDevice().getDeviceId());
            ps.setString(3, customerDevice.getSerialNumber());

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
    public CustomerDevice getById(Connection connection, int customerDeviceId) throws SQLException {
    	CustomerDevice customerDevice = null;
        String query = "SELECT * from customer_devices where customer_device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerDeviceId);

            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                	CustomerDeviceAdapter customerDeviceAdapter = new CustomerDeviceAdapter();
                	customerDevice = customerDeviceAdapter.adaptFromDb(resultSet);
                }
            }

        }
        return customerDevice;
    }

    // getAll
    public List<CustomerDevice> getAll(Connection connection) throws SQLException {
        List<CustomerDevice> customerDeviceList = new ArrayList<>();
        String query = "SELECT * from customer_devices"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
                while (resultSet.next()) {
                	CustomerDeviceAdapter customerDeviceAdapter = new CustomerDeviceAdapter();
                    CustomerDevice customerDevice = customerDeviceAdapter.adaptFromDb(resultSet);
                    customerDeviceList.add(customerDevice);
                }
            }
        return customerDeviceList;
    }
    
    // getAllByCustomerId
    public List<CustomerDevice> getAllByCustomerId(Connection connection, int customerId) throws SQLException {
        List<CustomerDevice> customerDeviceList = new ArrayList<>();
        String query = "SELECT * from customer_devices WHERE customer_id = ?"; 

        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
            		CustomerDeviceAdapter customerDeviceAdapter = new CustomerDeviceAdapter();
            		CustomerDevice customerDevice = customerDeviceAdapter.adaptFromDb(resultSet);
                    customerDeviceList.add(customerDevice);
                }
            }
            
        }
        return customerDeviceList;
    }

    // updateById
    public int updateById(Connection connection, CustomerDevice customerDevice) throws SQLException {
        int rowsAffected = -1;
        String query = "UPDATE customer_devices SET serial_number=? WHERE customer_device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)){            
            ps.setString(1, customerDevice.getSerialNumber());
            ps.setInt(2, customerDevice.getCustomerDeviceId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int customerDeviceId) throws SQLException {
        int rowsAffected = -1;
        String query = "DELETE FROM customer_devices WHERE customer_device_id=?";

        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, customerDeviceId);

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

}