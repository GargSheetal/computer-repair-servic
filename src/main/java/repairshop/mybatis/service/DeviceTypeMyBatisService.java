package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.CustomerMapper;
import repairshop.dataaccess.mapper.DeviceTypeMapper;
import repairshop.dataaccess.model.DeviceType.DeviceType;

public class DeviceTypeMyBatisService implements DeviceTypeMapper {

	private final DeviceTypeMapper deviceTypeMapper;
    private final SqlSession session;

    public DeviceTypeMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		deviceTypeMapper = session.getMapper(DeviceTypeMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public DeviceType selectDeviceTypeById(int deviceTypeId) {
		return deviceTypeMapper.selectDeviceTypeById(deviceTypeId);
	}

	@Override
	public DeviceType selectDeviceTypeByDeviceTypeName(String deviceTypeName) {
		return deviceTypeMapper.selectDeviceTypeByDeviceTypeName(deviceTypeName);
	}

	@Override
	public void addDeviceType(DeviceType deviceType) {
		deviceTypeMapper.addDeviceType(deviceType);
	}

	@Override
	public void updateDeviceType(DeviceType deviceType) {
		deviceTypeMapper.updateDeviceType(deviceType);
	}

	@Override
	public void deleteDeviceTypeById(int deviceTypeId) {
		deviceTypeMapper.deleteDeviceTypeById(deviceTypeId);
	}
	
	public void closeSession() {
        session.close();
    }
}
