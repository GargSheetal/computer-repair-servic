package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.DeviceMapper;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.dataaccess.model.Device.Device;

public class DeviceMyBatisService implements DeviceMapper {

	private final DeviceMapper deviceMapper;
    private final SqlSession session;

    public DeviceMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		deviceMapper = session.getMapper(DeviceMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public CustomerDevice selectDeviceById(int deviceId) {
		return deviceMapper.selectDeviceById(deviceId);
	}

	@Override
	public CustomerDevice selectDeviceByDeviceName(String deviceName) {
		return deviceMapper.selectDeviceByDeviceName(deviceName);
	}

	@Override
	public CustomerDevice selectDeviceDetailsByDeviceId(int deviceId) {
		return deviceMapper.selectDeviceDetailsByDeviceId(deviceId);
	}

	@Override
	public void addDevice(Device device) {
		deviceMapper.addDevice(device);
	}

	@Override
	public void updateDevice(Device device) {
		deviceMapper.updateDevice(device);
	}

	@Override
	public void deleteDevice(int deviceId) {
		deviceMapper.deleteDevice(deviceId);
	}

	public void closeSession() {
        session.close();
    }
}
