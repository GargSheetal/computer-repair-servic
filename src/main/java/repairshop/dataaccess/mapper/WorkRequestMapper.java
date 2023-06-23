/**
 * 
 */
package repairshop.dataaccess.mapper;

import java.util.Date;

import repairshop.dataaccess.model.WorkRequest.WorkRequest;

/**
 * @author sheetal
 *
 */
public interface WorkRequestMapper {
	
	WorkRequest selectWorkRequestById(int workRequestId);
	
	WorkRequest selectWorkRequestByCreatedTimestamp(Date createdTimestamp);
	
	void addWorkRequest(WorkRequest workRequest);
	
	void updateWorkRequest(WorkRequest workRequest);
	
	void deleteWorkRequest(int workRequestId);

}
