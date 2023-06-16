package repairshop.dataaccess.model.WorkRequestPayment;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class WorkRequestPaymentAdapter{
        
        public WorkRequestPayment adaptFromDb(ResultSet record) throws SQLException {
            WorkRequestPayment workRequestPayment = new WorkRequestPayment();
            workRequestPayment.setWorkRequestPaymentId(record.getInt("work_request_payment_id"));
            workRequestPayment.getWorkRequest().setWorkRequestId(record.getInt("work_request_id"));
            workRequestPayment.setPaymentConfirmationNumber(record.getString("payment_confirmation_number"));
            workRequestPayment.setPaymentTimestamp(record.getTimestamp("payment_timestamp"));
            workRequestPayment.setAmount(record.getDouble("amount"));
            return workRequestPayment;
        }
}