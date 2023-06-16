package repairshop.dataaccess.model.Technician;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class TechnicianAdapter{
        
        public Technician adaptFromDb(ResultSet record) throws SQLException {
            Technician technician = new Technician();
            technician.setTechnicianId(record.getInt("technician_id"));
            technician.setLastName(record.getString("last_name"));
            technician.setRestOfName(record.getString("rest_of_name"));
            technician.setEmail(record.getString("email"));
            technician.setPhone(record.getString("phone"));
            return technician;
        }
}