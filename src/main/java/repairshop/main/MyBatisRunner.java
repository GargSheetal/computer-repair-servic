package repairshop.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.CustomerMapper;
import repairshop.dataaccess.mapper.CustomerMapperJava;
import repairshop.dataaccess.model.Customer.Customer;

public class MyBatisRunner {

	public static void main(String[] args) throws IOException {
		try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)) {
			
			// provide 2 params - 1. namespace+id of the query from the CustomerMapper.xml file, 2. parameter for the query
		//	Customer customer = session.selectOne("repairshop.dataaccess.model.Customer.mapper.CustomerMapper.selectCustomerById", 2);
			CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
			
//			Customer customer = customerMapper.selectCustomerById(2);
//			System.out.println("Customer details : \n" + customer);
			
//			Customer customer = new Customer("Osborne", "Harry", "ho234@gmail.com", "2222333344");
//			customerMapper.addCustomer(customer);
//			System.out.println(customerMapper.selectCustomerByEmail("ho234@gmail.com"));
			
//			CustomerMapperJava customerMapperJava = session.getMapper(CustomerMapperJava.class);
//			Customer customer = customerMapperJava.selectCustomerById(1);
//			System.out.println("Customer details : \n" + customer);
			
			List<Customer> customerList = customerMapper.getAllCustomer();
			customerList.forEach(customer -> System.out.println(customer.toString()));
		}
	}

}
