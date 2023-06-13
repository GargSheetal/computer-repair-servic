package repairshop.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import repairshop.menu.CustomerMenu;
import repairshop.menu.WorkTypeMenu;
import repairshop.menu.XmlParserMenu;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) throws IOException, SQLException, ParserConfigurationException, SAXException {
//		mainMenu();
		xmlMenu();
	}
	
	private static void mainMenu() throws SQLException, IOException {
		logger.info("\n *** Presenting Main Menu *** ");
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
	
	private static void xmlMenu() throws ParserConfigurationException, SAXException, IOException {
		logger.info("\n *** Presenting XML Menu *** ");
		logger.info("\n 1. Parse using JAXB Parser");
		logger.info("\n 2. Parse using DOM Parser");
		logger.info("\n Enter selection : ");
		int selectedOption = scanner.nextInt();
		
		switch(selectedOption) {
			case 1:
				XmlParserMenu.parseCustomerUsingJaxbParser();
				goBackToXmlMenu(); break;
			case 2: 
				XmlParserMenu.parseCustomerUsingDomParser();
				goBackToXmlMenu(); break;
			default: break;
		}
	}
	
	public static void goBackToXmlMenu() throws ParserConfigurationException, SAXException, IOException {
		logger.info("\n\n Do you want to go back to XML Menu : ");
		Boolean selectedOption = scanner.nextBoolean();
		if(selectedOption == true) {
			xmlMenu();
		}
		return;
	}
}

