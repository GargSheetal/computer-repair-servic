package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IWorkRequestAppointmentDao;
import repairservice.model.Technician;
import repairservice.model.WorkRequest;
import repairservice.model.WorkRequestAppointment;

public class WorkRequestAppointmentDaoImpl implements IWorkRequestAppointmentDao {

	ResultSet rs = null;
	WorkRequestAppointment appointment = null;
	// Set the appointment timestamp using setDate()
	Date appointmentDate = new Date(appointment.getAppointmentTimestamp().getTime());
	
	@Override
	public WorkRequestAppointment create(WorkRequestAppointment appointment) {
		String query = "INSERT into work_request_appointments(work_request_id, technician_id, appointment_timestamp, technician_notes) values(?,?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setInt(1, appointment.getWorkRequest().getWorkRequestId());
			ps.setInt(2, appointment.getTechnician().getTechnicianId());
			ps.setDate(3, appointmentDate);
			ps.setString(4, appointment.getTechnicianNotes());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating workRequestAppointment: " + e.getMessage());
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public WorkRequestAppointment getById(int workReqApptId) {
		String query = "SELECT * from work_request_appointments where work_request_appointment_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workReqApptId);
			// execute the query
			rs = ps.executeQuery();

			// create a WorkRequestAppointment object and populate its data
			if(rs.next()) {
				appointment = new WorkRequestAppointment();
				appointment.getWorkRequest().setWorkRequestId(rs.getInt("work_request_id"));
				appointment.getTechnician().setTechnicianId(rs.getInt("technician_id"));
				appointment.setAppointmentTimestamp(rs.getDate("appointment_timestamp"));
				appointment.setTechnicianNotes(rs.getString("technician_notes"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequestAppointment: " + e.getMessage());
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public List<WorkRequestAppointment> getAll() {
		List<WorkRequestAppointment> appointmentList = new ArrayList<>();
		WorkRequestDaoImpl workRequestDaoImpl = new WorkRequestDaoImpl();
		TechnicianDaoImpl technicianDaoImpl = new TechnicianDaoImpl();
		String query = "SELECT * from work_request_appointments"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int workrequestAppointmentId = rs.getInt("work_request_appointment_id");
				int workrequestId = rs.getInt("work_request_id");
				int technicianId = rs.getInt("technician_id");
	            Date appointmentTimesatmp = rs.getDate("appointment_timestamp");
	            String techinicianNotes = rs.getString("technician_notes");
	          
	            WorkRequest workRequest = workRequestDaoImpl.getById(workrequestId);
	            Technician technician = technicianDaoImpl.getById(technicianId);
	            appointment = new WorkRequestAppointment(workrequestAppointmentId, workRequest, technician, appointmentTimesatmp, techinicianNotes);
				appointmentList.add(appointment);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workRequestAppointments: " + e.getMessage());
			e.printStackTrace();
		}
		return appointmentList;
	}

	@Override
	public WorkRequestAppointment update(WorkRequestAppointment appointment) {
		String query = "UPDATE work_request_appointments SET work_request_id=?, technician_id=?, appointment_timestamp=?, technician_notes=? WHERE work_request_appointment_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setInt(1, appointment.getWorkRequest().getWorkRequestId());
			ps.setInt(2, appointment.getTechnician().getTechnicianId());
			ps.setDate(3, appointmentDate);
			ps.setString(4, appointment.getTechnicianNotes());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating workRequestAppointment: " + e.getMessage());
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public int delete(int workReqApptId) {
		String query = "DELETE from work_request_appointments WHERE work_request_appointment_id=?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workReqApptId);
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
			if(count>0) {
				System.out.println("WorkRequestAppointment with ID: " + workReqApptId + " deleted successfully");
			} 
			else {
				System.out.println("No workRequestAppointment with ID: " + workReqApptId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting workRequestAppointment: " + e.getMessage());
			e.printStackTrace();
		}
		return workReqApptId;
	}

	

}
