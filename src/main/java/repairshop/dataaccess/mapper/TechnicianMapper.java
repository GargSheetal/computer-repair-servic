/**
 * 
 */
package repairshop.dataaccess.mapper;

import java.util.List;

import repairshop.dataaccess.model.Technician.Technician;

/**
 * @author sheetal
 *
 */
public interface TechnicianMapper {
	
	Technician selectTechnicianById(int technicianId);
	
	Technician selectTechnicianByEmail(String email);
	
	List<Technician> getAllTechnicians();
	
	void addTechnician(Technician technician);
	
	void updateTechnician(Technician technician);
	
	void deleteTechnician(int technicianId);

}
