package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.CustomerDeviceMapper;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;

public class CustomerDeviceMyBatisService implements CustomerDeviceMapper {

	private final CustomerDeviceMapper customerDeviceMapper;
    private final SqlSession session;

    public CustomerDeviceMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		customerDeviceMapper = session.getMapper(CustomerDeviceMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public CustomerDevice selectCustomerDeviceById(int customerDeviceId) {
		return customerDeviceMapper.selectCustomerDeviceById(customerDeviceId);
	}

	@Override
	public CustomerDevice selectCustomerDeviceBySerialNumber(int serialNumber) {
		return customerDeviceMapper.selectCustomerDeviceBySerialNumber(serialNumber);
	}

	@Override
	public CustomerDevice getCustomerDeviceDetailsById(int customerDeviceId) {
		return customerDeviceMapper.getCustomerDeviceDetailsById(customerDeviceId);
	}

	@Override
	public void addCustomerDevice(CustomerDevice customerDevice) {
		customerDeviceMapper.addCustomerDevice(customerDevice);
	}

	@Override
	public void updateCustomerDevice(CustomerDevice customerDevice) {
		customerDeviceMapper.updateCustomerDevice(customerDevice);
	}

	@Override
	public void deleteCustomerDevice(int customerDeviceId) {
		customerDeviceMapper.deleteCustomerDevice(customerDeviceId);
	}
	
	public void closeSession() {
        session.close();
    }
}
