package repairshop.dataaccess.model.WorkRequestAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class WorkRequestAppointmentAdapter{
        
        public WorkRequestAppointment adaptFromDb(ResultSet record) throws SQLException {
            WorkRequestAppointment workRequestAppointment = new WorkRequestAppointment();
            workRequestAppointment.setWorkRequestAppointmentId(record.getInt("work_request_appointment_id"));
            workRequestAppointment.getWorkRequest().setWorkRequestId(record.getInt("work_request_id"));
            workRequestAppointment.getTechnician().setTechnicianId(record.getInt("technician_id"));
            workRequestAppointment.setAppointmentTimestamp(record.getDate("appointment_timestamp"));
            workRequestAppointment.setTechnicianNotes(record.getString("technician_notes"));
			return workRequestAppointment;
        }
}