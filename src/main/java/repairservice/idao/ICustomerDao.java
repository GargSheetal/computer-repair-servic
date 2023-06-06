package repairservice.idao;

import java.util.List;

import repairservice.model.Customer;

public interface ICustomerDao extends IDAO<Customer> {

	Customer create(Customer customer);

	Customer getById(int id);

	List<Customer> getAll();

	Customer update(Customer customer);

	int delete(int id);

}
