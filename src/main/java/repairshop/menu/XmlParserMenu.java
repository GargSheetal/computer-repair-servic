package repairshop.menu;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import repairshop.dataaccess.model.Customer.Customers;
import repairshop.xml.XMLDOMParser;
import repairshop.xml.XmlJAXBParser;

public class XmlParserMenu {

	public static void parseCustomerUsingJaxbParser() {
		System.out.println("\n--- Parsing Customer Data using JAXB Parser ---");
		XmlJAXBParser.unmarshallCustomer("./src/main/resources/repairshop/xmldata/customers.xml", Customers.class);
	}
	
	public static void parseCustomerUsingDomParser() throws ParserConfigurationException, SAXException, IOException {
		System.out.println("\n--- Parsing Customer Data using DOM Parser ---");
		XMLDOMParser.parse();
	} 
}
