package repairshop.dataaccess.model.customerdevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.model.customer.Customer;
import repairshop.dataaccess.model.customer.CustomerAdapter;

public class CustomerDeviceDaoImpl implements ICustomerDeviceDao {

	ResultSet rs = null;
	
	public int create(Connection connection, CustomerDevice custDevice) throws SQLException {
		int generatedId = -1;
		String query = "INSERT into customer_devices('serial_number', 'customer_id', 'device_id') values(?,?,?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			ps.setString(1, custDevice.getSerialNumber());
			ps.setInt(2, custDevice.getCustomer().getCustomerId());
			ps.setInt(3, custDevice.getDevice().getDeviceId());
			
			//execute query
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

	public CustomerDevice getById(Connection connection, int customerDeviceId) throws SQLException {
		CustomerDevice customerDevice = null;
		String query = "SELECT * from customer_devices where customer_device_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, customerDeviceId);

			try(ResultSet resultSet = ps.executeQuery()) {
				if (resultSet.next()) {
					CustomerDeviceAdapter customerDeviceAdapter = new CustomerDeviceAdapter();
					customerDevice = customerDeviceAdapter.adaptFromDb(resultSet);
				}
			}
	
		}
		return customerDevice;
	}

	
	public List<CustomerDevice> getAll(Connection connection) throws SQLException {
		List<CustomerDevice> customerDeviceList = new ArrayList<>();
		String query = "SELECT * from customer_devices"; 

		try(
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
		) {
			CustomerDeviceAdapter customerDeviceAdapter = new CustomerDeviceAdapter();
			while(resultSet.next())
			{
				CustomerDevice customerDevice = customerDeviceAdapter.adaptFromDb(resultSet);
				customerDeviceList.add(customerDevice);
			}
		}
		return customerDeviceList;
	}


	public int updateById(Connection connection, CustomerDevice customerDevice) throws SQLException {
		int updatedId = -1;
		String command = "UPDATE customer_devices SET serial_number=?, customer_id=?, device_id=? WHERE customer_device_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, customerDevice.getSerialNumber());
			ps.setInt(2, customerDevice.getCustomer().getCustomerId());
			ps.setInt(3, customerDevice.getDevice().getDeviceId());
			ps.setInt(4, customerDevice.getCustomerDeviceId());
			
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

	
	public int deleteById(Connection connection, int customerDeviceId) throws SQLException {
		int deletedId = -1;
		String command = "DELETE from customer_devices WHERE customer_device_id=?"; 
		
		try(PreparedStatement ps = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
			ps.setInt(1, customerDeviceId);
			
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


