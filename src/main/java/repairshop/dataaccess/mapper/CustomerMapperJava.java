package repairshop.dataaccess.mapper;

import org.apache.ibatis.annotations.Select;

import repairshop.dataaccess.model.Customer.Customer;

public interface CustomerMapperJava {
	
	@Select("SELECT customer_id AS customerId, last_name AS lastName, rest_of_name AS restOfName, email, phone from customers where customer_id = #{customerId}")
	Customer selectCustomerById(int customerId);
	
}
