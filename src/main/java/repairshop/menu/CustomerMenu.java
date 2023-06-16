package repairshop.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repairshop.dataaccess.model.Customer.*;
import repairshop.service.*;

public class CustomerMenu {
	
	private static final Logger logger = LogManager.getLogger(CustomerMenu.class);
	private static Scanner scanner = new Scanner(System.in);
	private CustomerService customerService;
	
	public CustomerMenu() throws IOException {
		this.customerService = new CustomerService();
	}
	
	public Customer createCustomer() throws SQLException {
		
		String lastName = requestCustomerLastName();
		String restOfName = requestCustomerRestOfName();
		String email = requestCustomerEmail();
		String phone = requestCustomerPhone();
		Customer customer = new Customer(lastName, restOfName, email, phone);
		return customerService.createCustomer(customer);
	}
	
	public Customer login() throws SQLException {
		String email = requestCustomerEmail();
		Customer customer;
		try {
			customer = customerService.getCustomerByEmail(email);
			if(customer == null) {
				throw new InvalidAttributesException("Incorrect Email. Please enter valid email !");
			}
		}
		catch(InvalidAttributesException e) {
			logger.info("InvalidAttributesException : " + e.getMessage());
			customer = login();
		}
		logger.info("\nLogin Successful. Welcome " + customer.getRestOfName() + " " + customer.getLastName());
		return customer;
	}
	
	public String requestCustomerLastName() {
		logger.info("Enter Last Name: ");
		String lastName = scanner.nextLine();
		return lastName;	
	}

	public String requestCustomerRestOfName() {
		logger.info("Enter Rest Of Name: ");
		String restOfName = scanner.nextLine();
		return restOfName;	
	}
	
	public String requestCustomerEmail() {
		logger.info("Enter Email: ");
		String email = scanner.nextLine();
		return email;	
	}
	
	public String requestCustomerPhone() {
		logger.info("Enter Phone: ");
		String phone = scanner.nextLine();
		return phone;	
	}
}
