package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.TechnicianMapper;
import repairshop.dataaccess.model.Technician.Technician;

public class TechnicianMyBatisService implements TechnicianMapper {

	private final TechnicianMapper technicianMapper;
    private final SqlSession session;

    public TechnicianMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		technicianMapper = session.getMapper(TechnicianMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public Technician selectTechnicianById(int technicianId) {
		return technicianMapper.selectTechnicianById(technicianId);
	}

	@Override
	public Technician selectTechnicianByEmail(String email) {
		return technicianMapper.selectTechnicianByEmail(email);
	}

	@Override
	public List<Technician> getAllTechnicians() {
		return technicianMapper.getAllTechnicians();
	}

	@Override
	public void addTechnician(Technician technician) {
		technicianMapper.addTechnician(technician);
	}

	@Override
	public void updateTechnician(Technician technician) {
		technicianMapper.updateTechnician(technician);
	}

	@Override
	public void deleteTechnician(int technicianId) {
		technicianMapper.deleteTechnician(technicianId);
	}

	public void closeSession() {
        session.close();
    }
}
