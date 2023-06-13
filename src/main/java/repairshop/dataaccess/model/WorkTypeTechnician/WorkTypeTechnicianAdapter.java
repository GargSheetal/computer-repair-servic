package repairshop.dataaccess.model.WorkTypeTechnician;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class WorkTypeTechnicianAdapter{
        
        public WorkTypeTechnician adaptFromDb(ResultSet record) throws SQLException {
            WorkTypeTechnician workTypeTechnician = new WorkTypeTechnician();
            workTypeTechnician.getWorkType().setWorkTypeId(record.getInt("work_type_id"));
            workTypeTechnician.getTechnician().setTechnicianId(record.getInt("technician_id"));
            workTypeTechnician.setSkillLevel(record.getInt("skill_level"));
            return workTypeTechnician;
        }
}