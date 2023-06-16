package repairshop.menu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import repairshop.dataaccess.model.Customer.Customer;
import repairshop.dataaccess.model.Customer.Customers;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevices;
import repairshop.json.JsonJacksonParser;
import repairshop.xml.XMLDOMParser;
import repairshop.xml.XmlJAXBParser;

public class ParserMenu {

	private static final Logger logger = LogManager.getLogger(ParserMenu.class);
	
	public static void parseCustomerXMLUsingJaxbParser() {
		logger.info("\n--- Parsing Customer XML using JAXB Parser ---");
		XmlJAXBParser.unmarshallCustomer("./src/main/resources/repairshop/xmldata/customers.xml", Customers.class);
	}
	
	public static void parseCustomerXMLUsingDomParser() throws ParserConfigurationException, SAXException, IOException {
		logger.info("\n--- Parsing Customer XML using DOM Parser ---");
		XMLDOMParser.parse();
	} 
	
	public static void parseCustomerJSONUsingJacksonParser() throws IOException {
		logger.info("\n--- Parsing Customer JSON using Jackson Parser ---");
		Customers customers = JsonJacksonParser.readJsonFile(new File("./src/main/resources/repairshop/jsondata/customers.json"), Customers.class);
		List<Customer> customerList = customers.getCustomers();
		customerList.forEach(customer -> System.out.println(customer.toString()));
	} 
	
	public static void parseCustomerDeviceJSONUsingJacksonParser() throws IOException {
		logger.info("\n--- Parsing Customer Device JSON using Jackson Parser ---");
		CustomerDevices customerDevices = JsonJacksonParser.readJsonFile(new File("./src/main/resources/repairshop/jsondata/customer_devices.json"), CustomerDevices.class);
		List<CustomerDevice> customerDeviceList = customerDevices.getCustDeviceList();
		customerDeviceList.forEach(customerDevice -> System.out.println(customerDevice.toString()));
	} 
}
