package repairshop.dataaccess.model.WorkRequestAppointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkRequestAppointmentDaoImpl implements IWorkRequestAppointmentDao {
    // create 
    public int create(Connection connection, WorkRequestAppointment workRequestAppointment) throws SQLException {
        int generatedId = -1;
        String query = "INSERT into work_request_appointments (work_request_id, technician_id, appointment_timestamp) values(?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, workRequestAppointment.getWorkRequest().getWorkRequestId());
            ps.setInt(2, workRequestAppointment.getTechnician().getTechnicianId());
            ps.setDate(3,  (Date) workRequestAppointment.getAppointmentTimestamp());

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

    // getById
    public WorkRequestAppointment getById(Connection connection, int workRequestAppointmentId) throws SQLException {
        WorkRequestAppointment workRequestAppointment = null;
        String query = "SELECT * from work_request_appointments where work_request_appointment_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workRequestAppointmentId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    WorkRequestAppointmentAdapter workRequestAppointmentAdapter = new WorkRequestAppointmentAdapter();
                    workRequestAppointment = workRequestAppointmentAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return workRequestAppointment;
    }

    // getAll
    public List<WorkRequestAppointment> getAll(Connection connection) throws SQLException {
        List<WorkRequestAppointment> workRequestAppointmentList = new ArrayList<>();
        String query = "SELECT * from work_request_appointments"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
            while (resultSet.next()) {
                WorkRequestAppointmentAdapter workRequestAppointmentAdapter = new WorkRequestAppointmentAdapter();
                WorkRequestAppointment workRequestAppointment = workRequestAppointmentAdapter.adaptFromDb(resultSet);
                workRequestAppointmentList.add(workRequestAppointment);
            }
        }
        return workRequestAppointmentList;
    }

    // updateById
    public int updateById(Connection connection, WorkRequestAppointment workRequestAppointment) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE work_request_appointments SET technician_id=?, appointment_timestamp=?, technician_notes=? WHERE work_request_appointment_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, workRequestAppointment.getTechnician().getTechnicianId());
            ps.setDate(2, (Date) workRequestAppointment.getAppointmentTimestamp());
            ps.setString(3,  workRequestAppointment.getTechnicianNotes());
            ps.setInt(4, workRequestAppointment.getWorkRequestAppointmentId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int workRequestAppointmentId) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE FROM work_request_appointments WHERE work_request_appointment_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, workRequestAppointmentId);

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }
}