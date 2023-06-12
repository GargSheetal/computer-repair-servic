package repairservice.main;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import repairservice.daoimpl.CustomerDaoImpl;
import repairservice.daoimpl.CustomerDeviceDaoImpl;
import repairservice.daoimpl.DeviceTypeDaoImpl;
import repairservice.db.ConnectionPool;
import repairservice.model.Customer;
import repairservice.model.CustomerDevice;
import repairservice.model.CustomerDevices;
import repairservice.model.Customers;
import repairservice.model.DeviceType;
import repairservice.service.CustomerDeviceService;
import repairservice.service.CustomerService;
import repairservice.service.DeviceTypeService;
import repairservice.xml.XMLDOMParser;
import repairservice.xml.XMLValidationDriver;
import repairservice.xml.XmlJAXBParser;

public class Main {

	public static void main(String[] args) {
		
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		CustomerService customerService = new CustomerService(customerDao);
		CustomerDeviceDaoImpl customerDeviceDaoImpl = new CustomerDeviceDaoImpl();
		CustomerDeviceService customerDeviceService = new CustomerDeviceService(customerDeviceDaoImpl);
		
		DeviceTypeDaoImpl deviceTypeDaoImpl = new DeviceTypeDaoImpl();
		DeviceTypeService deviceTypeService = new DeviceTypeService(deviceTypeDaoImpl);
		
		// Retrieve all customers
		List<Customer> custList = customerService.getAll();
		System.out.println("All Customers:");
		for(Customer customer: custList) {
			System.out.println(customer.getCustomerId() + " : " + customer.getLastName() + " : " + 
								customer.getRestOfName() + " : " + customer.getEmail() + " : " + customer.getEmail());
		}
		
		// Get a specific customer by ID
		int customerId = 2;
		Customer customer = customerService.getById(customerId);
		if (customer != null) {
            System.out.println("\nCustomer with ID " + customerId + ":");
            System.out.println(customer.getCustomerId() + " : " + customer.getLastName() + " : " + 
					customer.getRestOfName() + " : " + customer.getEmail() + " : " + customer.getEmail());
        } else {
            System.out.println("\nCustomer with ID " + customerId + " not found.");
        }
		
//		// Add a new customer
//        Customer newCustomer = new Customer("Jackson", "Michael", "jm234@gmail.com", "2222333344");
//        customerService.create(newCustomer);
//        System.out.println(newCustomer.getCustomerId() + " : " + newCustomer.getLastName() + " : " + 
//        		newCustomer.getRestOfName() + " : " + newCustomer.getEmail() + " : " + newCustomer.getEmail());
//        
//        // Delete a customer
//		  int customerId2 = 12;
//        customerService.delete(customerId2);
		
		// Retrieve all customer devices
		List<CustomerDevice> custDeviceList = customerDeviceService.getAll();
		System.out.println("\nAll Customer Devices:");
		System.out.println("CustDeviceId" + " : " + "SerialNumber" + " : " + "CustId" + " : " + "DeviceId");
		for(CustomerDevice customerDevice: custDeviceList) {
			System.out.println(customerDevice.getCustomerDeviceId() + " : " + customerDevice.getSerialNumber() + " : " + 
					customerDevice.getCustomer().getCustomerId() + " : " + customerDevice.getDevice().getDeviceId());
		}
		
		// Retrieve deviceType by id
		DeviceType deviceType = deviceTypeService.getById(3);
		System.out.println("\nDeviceTypeId : DeviceTypeName : DeviceBrandId");
		System.out.println(deviceType.getDeviceTypeId() + " : " + deviceType.getDeviceTypeName() + " : " + deviceType.getDeviceBrand().getDeviceBrandId());
		
		
		// Shutdown the connection pool
        ConnectionPool.shutdown();
        
        
        // Validating xml file with xml schema
        boolean flag = true;
		try {
			XMLValidationDriver.validate("./src/main/resources/repairservice/xmldata/technicians.xml", "./src/main/resources/repairservice/xmldata/technicians.xsd");
		} catch (SAXException e) {
			flag = false;
		} catch (IOException e) {
			flag = false;
		}
		System.out.println("\nxml file is valid : " + flag);
		System.out.println("-------------------------");
		
		// parsing xml file with DOM parser
		System.out.println("\n-------- Parsing Xml using DOM parser --------");
		try {
			XMLDOMParser.parse();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		// parsing xml file with JAXB parser (Unmarshalling)
		System.out.println("\n-------- Parsing customers.xml using JAXB parser --------");
		XmlJAXBParser.unmarshallCustomer("./src/main/resources/repairservice/xmldata/customers.xml", Customers.class);
		
		System.out.println("\n-------- Parsing customer_devices.xml using JAXB parser --------");
		XmlJAXBParser.unmarshallCustDevice("src/main/resources/repairservice/xmldata/customer_devices.xml", CustomerDevices.class);
		
		
	}

}
