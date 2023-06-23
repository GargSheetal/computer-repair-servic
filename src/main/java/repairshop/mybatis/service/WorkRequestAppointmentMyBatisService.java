package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.WorkRequestAppointmentMapper;
import repairshop.dataaccess.model.WorkRequestAppointment.WorkRequestAppointment;

public class WorkRequestAppointmentMyBatisService implements WorkRequestAppointmentMapper {

	private final WorkRequestAppointmentMapper workRequestAppointmentMapper;
    private final SqlSession session;

    public WorkRequestAppointmentMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		workRequestAppointmentMapper = session.getMapper(WorkRequestAppointmentMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public WorkRequestAppointment selectWorkRequestAppointmentById(int workRequestAppointmentId) {
		return workRequestAppointmentMapper.selectWorkRequestAppointmentById(workRequestAppointmentId);
	}

	@Override
	public WorkRequestAppointment selectWorkRequestAppointmentByAppointmentTimestamp(Date appointmentTimestamp) {
		return workRequestAppointmentMapper.selectWorkRequestAppointmentByAppointmentTimestamp(appointmentTimestamp);
	}

	@Override
	public void addWorkRequestAppointment(WorkRequestAppointment workRequestAppointment) {
		workRequestAppointmentMapper.addWorkRequestAppointment(workRequestAppointment);
	}

	@Override
	public void updateWorkRequestAppointment(WorkRequestAppointment workRequestAppointment) {
		workRequestAppointmentMapper.updateWorkRequestAppointment(workRequestAppointment);
	}

	@Override
	public void deleteWorkRequestAppointment(int workRequestAppointmentId) {
		workRequestAppointmentMapper.deleteWorkRequestAppointment(workRequestAppointmentId);
	}

	public void closeSession() {
        session.close();
    }
}
