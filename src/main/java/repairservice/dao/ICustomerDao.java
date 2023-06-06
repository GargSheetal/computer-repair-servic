package repairservice.dao;

import java.util.List;

import repairservice.model.Customer;

public interface ICustomerDao extends IDAO<Customer> {

	void create(Customer customer);

	Customer getById(int id);

	List<Customer> getAll();

	void update(Customer customer, String[] params);

	void delete(int id);

}
