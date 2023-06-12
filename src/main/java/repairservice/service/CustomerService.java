package repairservice.service;

import java.util.List;

import repairservice.daoimpl.CustomerDaoImpl;
import repairservice.model.Customer;

public class CustomerService {

	private CustomerDaoImpl customerDao;

	public CustomerService(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}
	
	public Customer getById(int customerId) {
		return customerDao.getById(customerId);
	}
	
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}
	
	public int delete(int customerId) {
		customerDao.delete(customerId);
		return customerId;
	}
}




