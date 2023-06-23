package repairshop.mybatis.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import repairshop.dataaccess.mapper.CustomerMapper;
import repairshop.dataaccess.mapper.WorkRequestPaymentMapper;
import repairshop.dataaccess.model.WorkRequestPayment.WorkRequestPayment;

public class WorkRequestPayementMyBatisService implements WorkRequestPaymentMapper {

	private final WorkRequestPaymentMapper workRequestPaymentMapper;
    private final SqlSession session;

    public WorkRequestPayementMyBatisService() {
    	try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
    		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    		session = sessionFactory.openSession(true);
    		workRequestPaymentMapper = session.getMapper(WorkRequestPaymentMapper.class);
    	} catch (IOException e) {
    		throw new RuntimeException("Error initializing MyBatis session factory", e);
    	}
    }
	
	@Override
	public WorkRequestPayment selectWorkRequestPaymentById(int workRequestPaymentId) {
		return workRequestPaymentMapper.selectWorkRequestPaymentById(workRequestPaymentId);
	}

	@Override
	public WorkRequestPayment selectWorkRequestPaymentByPaymentConfirmationNumber(String paymentConfirmationNumber) {
		return workRequestPaymentMapper.selectWorkRequestPaymentByPaymentConfirmationNumber(paymentConfirmationNumber);
	}

	@Override
	public void addWorkRequestPayment(WorkRequestPayment workRequestPayment) {
		workRequestPaymentMapper.addWorkRequestPayment(workRequestPayment);
	}

	@Override
	public void updateWorkRequestPayment(WorkRequestPayment workRequestPayment) {
		workRequestPaymentMapper.updateWorkRequestPayment(workRequestPayment);
	}

	@Override
	public void deleteWorkRequestPayment(int workRequestPaymentId) {
		workRequestPaymentMapper.deleteWorkRequestPayment(workRequestPaymentId);
	}

	public void closeSession() {
        session.close();
    }
}
