package repairshop.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import repairshop.menu.MenuHelper;

public class Main {
	
	
	public static void main(String[] args) throws IOException, SQLException, ParserConfigurationException, SAXException {
		MenuHelper.mainMenu();
	//	MenuHelper.parserMenu();
		
	}
	
}

