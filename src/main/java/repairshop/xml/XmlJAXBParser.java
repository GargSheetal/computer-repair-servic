package repairshop.xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import repairshop.dataaccess.model.Customer.*;
import repairshop.dataaccess.model.CustomerDevice.*;

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
	
	public static void marshalToXml(Object object, String fileName) {
        try {
            // Step 1: Create JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            // Step 2: Create Marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Step 3: Marshal Java object to XML
            File file = new File(fileName);
            marshaller.marshal(object, file);

            System.out.println("Java object marshalled to XML successfully.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
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
		
	}
		
	
	
}
