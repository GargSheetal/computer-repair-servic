package repairshop.dataaccess.model.WorkRequestPayment;

import java.sql.Connection;
import java.sql.SQLException;

public interface IWorkRequestPaymentDao {
	int create(Connection connection, WorkRequestPayment workRequestPayment) throws SQLException;
	WorkRequestPayment getByWorkRequestId(Connection connection, int workRequestId) throws SQLException;
}