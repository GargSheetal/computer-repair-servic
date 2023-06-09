package repairservice.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class XMLValidationDriver {

	public static void main(String[] args) {
		boolean flag = true;
		try {
			validate("./src/main/resources/repairservice/xmldata/technicians.xml", "./src/main/resources/repairservice/xmldata/technicians.xsd");
		} catch (SAXException e) {
			flag = false;
		} catch (IOException e) {
			flag = false;
		}
		System.out.println("xml file is valid : " + flag);
	}

	public static void validate(String xmlFile, String validationFile) throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.newSchema(new File(validationFile)).newValidator().validate(new StreamSource(new File(xmlFile)));
	}
	
}


