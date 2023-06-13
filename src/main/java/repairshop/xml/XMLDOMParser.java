package repairshop.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Get the document builder
 * Get the document
 * Normalize the xml structure
 * Get all the elements by tag name
 */

public class XMLDOMParser {

	// Helper method to get the text value of an element
    private static String getTextValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element el = (Element) nodeList.item(0);
            return el.getTextContent();
        }
        return null;
    }
	
	public static void parse() throws ParserConfigurationException, SAXException, IOException {
		// Get the document builder
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		// Get the document
		Document document = builder.parse(new File("./src/main/resources/repairshop/xmldata/customers.xml"));
		
		// Normalize the xml structure
		document.getDocumentElement().normalize();
		
		// Traverse the Document to extract data
		Element root = document.getDocumentElement();
		NodeList customerList = root.getElementsByTagName("customer");
		
		// Iterate over customers
		for(int i=0; i <= customerList.getLength(); i++) {
			Element customerElement = (Element) customerList.item(i);
			
			// Skip if customerElement is null
            if(customerElement == null) {
                continue;
            }
            String custId = customerElement.getAttribute("customer_id");
			
			// Get customer details
            String lastName = getTextValue(customerElement, "last_name");
            String restOfName = getTextValue(customerElement, "rest_of_name");
            String email = getTextValue(customerElement, "email");
            String phone = getTextValue(customerElement, "phone");
            
//            // Get customer device details
//            Element deviceElement = (Element) customerElement.getElementsByTagName("customer_device").item(0);
//            
//            // Skip if deviceElement is null
//            if(deviceElement == null) {
//            	continue;
//            }
//            
//            String deviceID = deviceElement.getAttribute("customer_device_id");
//            String serialNumber = getTextValue(deviceElement, "serial_number");
            
            // Printing with the extracted data
            System.out.println("Customer ID: " + custId);
            System.out.println("Last Name: " + lastName);
            System.out.println("Rest of Name: " + restOfName);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
//            System.out.println("CustomerDevice ID: " + deviceID);
//            System.out.println("    Serial Number: " + serialNumber);
            System.out.println("--------------------");
		}
	}
}

