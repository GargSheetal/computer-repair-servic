package repairshop.dataaccess.model.WorkRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class WorkRequestAdapter{
        
        public WorkRequest adaptFromDb(ResultSet record) throws SQLException {
            WorkRequest workRequest = new WorkRequest();
            workRequest.setWorkRequestId(record.getInt("work_request_id"));
            workRequest.getWorkType().setWorkTypeId(record.getInt("work_type_id"));
            workRequest.getCustomerDevice().setCustomerDeviceId(record.getInt("customer_device_id"));
            workRequest.setWorkRequestDescription(record.getString("work_request_description"));
            workRequest.setCreatedTimestamp(record.getDate("created_timestamp"));
            workRequest.setLastUpdatedTimestamp(record.getDate("last_updated_timestamp"));
            workRequest.setCompletedTimestamp(record.getDate("completed_timestamp"));
            return workRequest;
        }
}