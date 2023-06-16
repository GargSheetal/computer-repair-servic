package repairshop.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;


public class MenuHelper {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(MenuHelper.class);
	
	public static void mainMenu() throws SQLException, IOException {
		logger.info("\n ***** Presenting Main Menu ***** ");
		logger.info("\n 1. Create New Account");
		logger.info("\n 2. Login");
		logger.info("\n 3. Work Request Enquiry");
		logger.info("\n Enter selection : ");
		int selectedOption = scanner.nextInt();
		
		CustomerMenu customerMenu = null;
		WorkTypeMenu workTypeMenu = null;
		
		switch(selectedOption) {
			case 1:
				customerMenu = new CustomerMenu();
				customerMenu.createCustomer();
				goBackToMainMenu(); break;
			case 2: 
				customerMenu = new CustomerMenu();
				customerMenu.login();
				goBackToMainMenu(); break;
			case 3: 
				workTypeMenu = new WorkTypeMenu();
				workTypeMenu.queryDeviceWorkType();
				goBackToMainMenu(); break;
			default: break;
		}
	}
	
	public static void goBackToMainMenu() throws SQLException, IOException {
		logger.info("\n\n Do you want to go back to Main Menu : ");
		Boolean selectedOption = scanner.nextBoolean();
		if(selectedOption == true) {
			mainMenu();
		}
		return;
	}
	
	public static void parserMenu() throws ParserConfigurationException, SAXException, IOException {
		logger.info("\n *** Presenting Parser Menu *** ");
		logger.info("\n 1. Parse XML using JAXB Parser");
		logger.info("\n 2. Parse XML using DOM Parser");
		logger.info("\n 3. Parse JSON using Jackson Parser");
		logger.info("\n Enter selection : ");
		int selectedOption = scanner.nextInt();
		
		switch(selectedOption) {
			case 1:
				ParserMenu.parseCustomerXMLUsingJaxbParser();
				goBackToParserMenu(); break;
			case 2: 
				ParserMenu.parseCustomerXMLUsingDomParser();
				goBackToParserMenu(); break;
			case 3: 
				ParserMenu.parseCustomerJSONUsingJacksonParser();
				goBackToParserMenu(); break;
			default: break;
		}
	}
	
	public static void goBackToParserMenu() throws ParserConfigurationException, SAXException, IOException {
		logger.info("\n\n Do you want to go back to Parser Menu : ");
		Boolean selectedOption = scanner.nextBoolean();
		if(selectedOption == true) {
			parserMenu();
		}
		return;
	}
	
}
