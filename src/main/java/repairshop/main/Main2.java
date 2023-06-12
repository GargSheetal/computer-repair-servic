package repairshop.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import repairshop.dataaccess.model.customer.*;
import repairshop.service.*;

public class Main2 {

	public static void main(String[] args) throws IOException, SQLException {
		CustomerService customerService = new CustomerService();
		List<Customer> custList = customerService.getAll();
		System.out.println("All Customers:");
		for(Customer customer: custList) {
			System.out.println(customer.toString());
		}
	}
}
