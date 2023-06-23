package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.DeviceBrandMapper;
import repairshop.dataaccess.model.DeviceBrand.DeviceBrand;

public class DeviceBrandMyBatisService implements DeviceBrandMapper {

	private final DeviceBrandMapper deviceBrandMapper;
    private final SqlSession session;

    public DeviceBrandMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		deviceBrandMapper = session.getMapper(DeviceBrandMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public DeviceBrand selectDeviceBrandById(int deviceBrandId) {
		return deviceBrandMapper.selectDeviceBrandById(deviceBrandId);
	}

	@Override
	public DeviceBrand selectDeviceBrandByBrandName(String brandName) {
		return deviceBrandMapper.selectDeviceBrandByBrandName(brandName);
	}

	@Override
	public List<DeviceBrand> getAllDeviceBrands() {
		return deviceBrandMapper.getAllDeviceBrands();
	}

	@Override
	public void addDeviceBrand(DeviceBrand deviceBrand) {
		deviceBrandMapper.addDeviceBrand(deviceBrand);
	}

	@Override
	public void updateDeviceBrand(DeviceBrand deviceBrand) {
		deviceBrandMapper.updateDeviceBrand(deviceBrand);
	}

	@Override
	public void deleteDeviceBrand(int deviceBrandId) {
		deviceBrandMapper.deleteDeviceBrand(deviceBrandId);
	}
	
	public void closeSession() {
        session.close();
    }
}
