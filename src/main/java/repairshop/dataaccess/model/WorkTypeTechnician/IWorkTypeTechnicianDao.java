package repairshop.dataaccess.model.WorkTypeTechnician;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IWorkTypeTechnicianDao {
	int create(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException;
	List<WorkTypeTechnician> getAllByWorkTypeId(Connection connection, int workTypeId) throws SQLException;
	List<WorkTypeTechnician> getAllByTechnicianId(Connection connection, int technicianId) throws SQLException;
	int update(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException;
	int delete(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException;
}