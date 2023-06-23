/**
 * 
 */
package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.mapper.CustomerMapper;
import repairshop.dataaccess.model.Customer.Customer;

/**
 * @author sheetal
 *
 */
public class CustomerMyBatisService implements CustomerMapper {

	private final CustomerMapper customerMapper;
    private final SqlSession session;
    
    public CustomerMyBatisService() throws IOException {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		customerMapper = session.getMapper(CustomerMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public Customer selectCustomerById(int customerId) {
		return customerMapper.selectCustomerById(customerId);
	}

	@Override
	public Customer selectCustomerByEmail(String email) {
		return customerMapper.selectCustomerByEmail(email);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerMapper.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		customerMapper.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerMapper.deleteCustomer(customerId);
	}
	
	public void closeSession() {
        session.close();
    }
}
