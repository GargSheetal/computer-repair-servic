package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IWorkRequestPaymentDao;
import repairservice.model.DeviceBrandService;
import repairservice.model.WorkRequest;
import repairservice.model.WorkRequestPayment;

public class WorkRequestPaymentDaoImpl implements IWorkRequestPaymentDao {

	ResultSet rs = null;
	WorkRequestPayment payment = null;
	Date paymentTimestamp = new Date(payment.getPaymentTimestamp().getTime());
	@Override
	public WorkRequestPayment create(WorkRequestPayment payment) {
		String query = "INSERT into work_request_payments(work_request_id, payment_confirmation_number, payment_timestamp, amount) values(?,?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setInt(1, payment.getWorkRequest().getWorkRequestId());
			ps.setString(2, payment.getPaymentConfirmationNumber());
			ps.setDate(3, paymentTimestamp);
			ps.setDouble(4, payment.getAmount());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating workRequestPayment: " + e.getMessage());
			e.printStackTrace();
		}
		return payment;
	}

	@Override
	public WorkRequestPayment getById(int workReqPymtId) {
		String query = "SELECT * from work_request_payments where work_request_payment_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workReqPymtId);
			// execute the query
			rs = ps.executeQuery();

			// create a WorkRequestPayment object and populate its data
			if(rs.next()) {
				payment = new WorkRequestPayment();
				payment.getWorkRequest().setWorkRequestId(rs.getInt("work_request_id"));
				payment.setPaymentConfirmationNumber(rs.getString("payment_confirmation_number"));
				payment.setPaymentTimestamp(rs.getDate("payment_timestamp"));
				payment.setAmount(rs.getDouble("amount"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequestPayment: " + e.getMessage());
			e.printStackTrace();
		}
		return payment;
	}

	@Override
	public List<WorkRequestPayment> getAll() {
		List<WorkRequestPayment> paymentList = new ArrayList<>();
		WorkRequestDaoImpl workRequestDaoImpl = new WorkRequestDaoImpl();
		String query = "SELECT * from work_request_payments"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int workrequestPaymentId = rs.getInt("work_request_payment_id");
				int workrequestId = rs.getInt("work_request_id");
				String paymentConfirmationNumber = rs.getString("payment_confirmation_number");
	            Date paymentTimestamp = rs.getDate("payment_timestamp");
	            double amount = rs.getDouble("amount");
	          
	            WorkRequest workRequest = workRequestDaoImpl.getById(workrequestId);
	            payment = new WorkRequestPayment(workrequestPaymentId, workRequest, paymentConfirmationNumber, paymentTimestamp, amount);
	            paymentList.add(payment);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequestPayments: " + e.getMessage());
			e.printStackTrace();
		}
		return paymentList;
	}

	@Override
	public WorkRequestPayment update(WorkRequestPayment payment) {
		String query = "UPDATE work_request_payments SET work_request_id=?, payment_confirmation_number=?, payment_timestamp=?, amount=? WHERE work_request_payment_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setInt(1, payment.getWorkRequest().getWorkRequestId());
			ps.setString(2, payment.getPaymentConfirmationNumber());
			ps.setDate(3, paymentTimestamp);
			ps.setDouble(4, payment.getAmount());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating workRequestPayment: " + e.getMessage());
			e.printStackTrace();
		}
		return payment;
	}

	@Override
	public int delete(int workReqPymtId) {
		String query = "DELETE from work_request_payments WHERE work_request_payment_id=?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workReqPymtId);
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
			if(count>0) {
				System.out.println("WorkRequestPayment with ID: " + workReqPymtId + " deleted successfully");
			} 
			else {
				System.out.println("No workRequestPayment with ID: " + workReqPymtId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting workRequestPayment: " + e.getMessage());
			e.printStackTrace();
		}
		return workReqPymtId;
	}

}
