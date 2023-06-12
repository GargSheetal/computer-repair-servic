package repairservice.xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import repairservice.model.Customer;
import repairservice.model.CustomerDevice;
import repairservice.model.CustomerDevices;
import repairservice.model.Customers;

public class XmlJAXBParser {
	
	public static <T> T unmarshall(String fileName, Class<?> clazz) {
		
		try {
			// Step 1: Create JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			
			// Step 2: Create Unmarshaller
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			// Step 3: Unmarshal XML to Java objects
			File file = new File(fileName);
			return (T) clazz.cast(unmarshaller.unmarshal(file));
		}
		catch(JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void unmarshallCustomer(String fileName, Class<?> clazz) {
		
		Customers customers =  unmarshall(fileName, clazz);
		
		// Access the parsed customer object
		List<Customer> customerList = customers.getCustomers();
		customerList.forEach(customer -> System.out.println(customer.toString()));
	}
	

	public static void unmarshallCustDevice(String fileName, Class<?> clazz) {
		
		CustomerDevices custDevices = unmarshall(fileName, clazz);

		// Access the parsed customer device object
		List<CustomerDevice> custDeviceList = custDevices.getCustDeviceList();
		custDeviceList.forEach(custDevice -> System.out.println(custDevice.toString()));
		
//		for(CustomerDevice custDevice: custDeviceList) {
//			System.out.println("CustomerDevice ID: " + custDevice.getCustomerDeviceId());
//			System.out.println("Serail Number: " + custDevice.getSerialNumber());
//			System.out.println("Customer ID: " + custDevice.getCustomer().getCustomerId());
//			System.out.println("Device ID: " + custDevice.getDevice().getDeviceId());
//			System.out.println();
//		}
	}
		
	
	
}
