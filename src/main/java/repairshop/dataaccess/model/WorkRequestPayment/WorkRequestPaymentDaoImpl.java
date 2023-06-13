package repairshop.dataaccess.model.WorkRequestPayment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkRequestPaymentDaoImpl implements IWorkRequestPaymentDao {
    // create 
    public int create(Connection connection, WorkRequestPayment workRequestPayment) throws SQLException {
        int generatedId = -1;
        String query = "INSERT into work_request_payments (work_request_id, payment_confirmation_number, payment_timestamp, amount) values(?, ?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, workRequestPayment.getWorkRequest().getWorkRequestId());
            ps.setString(2, workRequestPayment.getPaymentConfirmationNumber());
            ps.setDate(3, (Date) workRequestPayment.getPaymentTimestamp());
            ps.setDouble(4, workRequestPayment.getAmount());

            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
            
            try(ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    generatedId = resultSet.getInt(1);
                }
            }
        }
        return generatedId;
    }

    // getByWorkRequestId
    public WorkRequestPayment getByWorkRequestId(Connection connection, int workRequestId) throws SQLException {
        WorkRequestPayment workRequestPayment = null;
        String query = "SELECT * from work_request_payments where work_request_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workRequestId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    WorkRequestPaymentAdapter workRequestPaymentAdapter = new WorkRequestPaymentAdapter();
                    workRequestPayment = workRequestPaymentAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return workRequestPayment;
    }
    
}