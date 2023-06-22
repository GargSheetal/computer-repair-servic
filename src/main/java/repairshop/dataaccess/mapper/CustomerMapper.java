package repairshop.dataaccess.mapper;

import java.util.List;

import repairshop.dataaccess.model.Customer.Customer;

public interface CustomerMapper {
	
	// method name must correspond to id of select query in customerMapper.xml file
	Customer selectCustomerById(int customerId);
	
	Customer selectCustomerByEmail(String email);
	
	List<Customer> getAllCustomer();
	
	void addCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(int customerId);

}
