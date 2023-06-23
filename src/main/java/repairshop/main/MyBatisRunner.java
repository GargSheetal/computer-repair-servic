package repairshop.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.model.Customer.Customer;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.mybatis.service.CustomerDeviceMyBatisService;
import repairshop.mybatis.service.CustomerMyBatisService;

public class MyBatisRunner {

	public static void main(String[] args) throws IOException, SQLException {
			
		CustomerMyBatisService customerMyBatisService = new CustomerMyBatisService();
		CustomerDeviceMyBatisService customerDeviceMyBatisService = new CustomerDeviceMyBatisService();
		
		Customer customer = customerMyBatisService.selectCustomerById(2);
		System.out.println("Customer details : \n" + customer);
		
		System.out.println("------------------------ \n");
		List<Customer> customerList = customerMyBatisService.getAllCustomers();
		customerList.forEach(customer2 -> System.out.println(customer2.toString()));
		
		System.out.println("------------------------ \n");
		CustomerDevice customerDevice = customerDeviceMyBatisService.getCustomerDeviceDetailsById(2);
		System.out.println("Customer Device details : \n" + customerDevice.toString());
	//	System.out.println("Customer Device details : \n" + customerDeviceMyBatisService.getCustomerDeviceDetailsById(2));
		
		customerMyBatisService.closeSession();
		customerDeviceMyBatisService.closeSession();
	}
}
