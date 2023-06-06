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
		customerDao.create(customer);
		System.out.println("Customer created successfully");
		return customer;
	}
	
	public Customer getById(int id) {
		return customerDao.getById(id);
	}
	
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}
	
	public int delete(int id) {
		customerDao.delete(id);
		return id;
	}
}
