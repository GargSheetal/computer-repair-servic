package repairservice.main;

import java.util.List;

import repairservice.daoimpl.CustomerDaoImpl;
import repairservice.db.ConnectionPool;
import repairservice.model.Customer;
import repairservice.service.CustomerService;

public class Main {

	public static void main(String[] args) {
		
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		CustomerService customerService = new CustomerService(customerDao);
		
		// Retrieve all customers
		List<Customer> custList = customerService.getAll();
		for(Customer customer: custList) {
			System.out.println(customer.getCustomerId() + " : " + customer.getLastName() + " : " + 
								customer.getRestOfName() + " : " + customer.getEmail() + " : " + customer.getEmail());
		}
		
		// Get a specific customer by ID
		int customerId = 2;
		Customer customer = customerService.getById(customerId);
		if (customer != null) {
            System.out.println("\nCustomer with ID " + customerId + ":");
            System.out.println(customer.getCustomerId() + " : " + customer.getLastName() + " : " + 
					customer.getRestOfName() + " : " + customer.getEmail() + " : " + customer.getEmail());
        } else {
            System.out.println("\nCustomer with ID " + customerId + " not found.");
        }
		
		// Add a new customer
        Customer newCustomer = new Customer("Jackson", "Michael", "jm234@gmail.com", "2222333344");
        customerService.create(newCustomer);
        System.out.println(newCustomer.getCustomerId() + " : " + newCustomer.getLastName() + " : " + 
        		newCustomer.getRestOfName() + " : " + newCustomer.getEmail() + " : " + newCustomer.getEmail());
        
        // Delete a customer
		int customerId2 = 12;
        customerService.delete(customerId2);
        
     // Shutdown the connection pool
        ConnectionPool.shutdown();
	}

}
