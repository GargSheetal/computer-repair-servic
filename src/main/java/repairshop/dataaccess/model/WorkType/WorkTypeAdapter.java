package repairshop.dataaccess.model.WorkType;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class WorkTypeAdapter {
        
        public WorkType adaptFromDb(ResultSet record) throws SQLException {
            WorkType workType = new WorkType();
            workType.setWorkTypeId(record.getInt("work_type_id"));
            workType.setWorkDescription(record.getString("work_description"));
            workType.setPrice(record.getDouble("price"));
            workType.getDevice().setDeviceId(record.getInt("device_id"));
            return workType;
        }
}