package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.WorkRequestMapper;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;

public class WorkRequestMyBatisService implements WorkRequestMapper {

	private final WorkRequestMapper workRequestMapper;
    private final SqlSession session;

    public WorkRequestMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		workRequestMapper = session.getMapper(WorkRequestMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public WorkRequest selectWorkRequestById(int workRequestId) {
		return workRequestMapper.selectWorkRequestById(workRequestId);
	}

	@Override
	public WorkRequest selectWorkRequestByCreatedTimestamp(Date createdTimestamp) {
		return workRequestMapper.selectWorkRequestByCreatedTimestamp(createdTimestamp);
	}

	@Override
	public void addWorkRequest(WorkRequest workRequest) {
		workRequestMapper.addWorkRequest(workRequest);
	}

	@Override
	public void updateWorkRequest(WorkRequest workRequest) {
		workRequestMapper.updateWorkRequest(workRequest);
	}

	@Override
	public void deleteWorkRequest(int workRequestId) {
		workRequestMapper.deleteWorkRequest(workRequestId);
	}
	
	public void closeSession() {
        session.close();
    }
}
