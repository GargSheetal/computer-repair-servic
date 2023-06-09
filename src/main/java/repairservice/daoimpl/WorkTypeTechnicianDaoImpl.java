package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.IWorkTypeTechnicianDao;
import repairservice.model.Technician;
import repairservice.model.WorkType;
import repairservice.model.WorkTypeTechnician;

public class WorkTypeTechnicianDaoImpl implements IWorkTypeTechnicianDao {

	ResultSet rs = null;
	WorkTypeTechnician workTypeTechnician = null;
	
	@Override
	public WorkTypeTechnician create(WorkTypeTechnician workTypeTechnician) {
		String query = "INSERT into work_type_technician(skill_level, work_type_id, technician_id) values(?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setInt(1, workTypeTechnician.getSkillLevel());
			ps.setInt(2, workTypeTechnician.getWorkType().getWorkTypeId());
			ps.setInt(3, workTypeTechnician.getTechnician().getTechnicianId());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating workTypeTechnician: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeTechnician;
	}

	@Override
	public WorkTypeTechnician getByWorkType(int workTypeId) {
		String query = "SELECT * from work_type_technician where work_type_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, workTypeId);
			// execute the query
			rs = ps.executeQuery();

			// create a WorkTypeTechnician object and populate its data
			if(rs.next()) {
				workTypeTechnician = new WorkTypeTechnician();
				workTypeTechnician.setSkillLevel(rs.getInt("skill_level"));
				workTypeTechnician.getWorkType().setWorkTypeId(rs.getInt("work_type_id"));
				workTypeTechnician.getTechnician().setTechnicianId(rs.getInt("technician_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workTypeTechnician: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeTechnician;
	}

	@Override
	public List<WorkTypeTechnician> getAll() {
		List<WorkTypeTechnician> appointmentList = new ArrayList<>();
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		TechnicianDaoImpl technicianDaoImpl = new TechnicianDaoImpl();
		String query = "SELECT * from work_type_technician"; 
		
		try(Connection conn = ConnectionPool.getConnection();
			PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				int skillLevel = rs.getInt("skill_level");
				int workTypeId = rs.getInt("work_type_id");
				int technicianId = rs.getInt("technician_id");
	          
	            WorkType workType = workTypeDaoImpl.getById(workTypeId);
	            Technician technician = technicianDaoImpl.getById(technicianId);
	            workTypeTechnician = new WorkTypeTechnician(skillLevel, workType, technician);
				appointmentList.add(workTypeTechnician);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving workTypeTechnicians: " + e.getMessage());
			e.printStackTrace();
		}
		return appointmentList;
	}

	@Override
	public WorkTypeTechnician update(WorkTypeTechnician workTypeTechnician) {
		String query = "UPDATE work_type_technician SET skill_level=? WHERE work_type_id=? and technician_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
		     PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setInt(1, workTypeTechnician.getSkillLevel());
			
			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating workTypeTechnician: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeTechnician;
	}

	@Override
	public WorkTypeTechnician delete(WorkTypeTechnician workTypeTechnician) {
		String query = "DELETE from work_type_technician WHERE WHERE work_type_id=? and technician_id=?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			// Set the value for the prepared statement
			ps.setInt(1, workTypeTechnician.getWorkType().getWorkTypeId());
			ps.setInt(1, workTypeTechnician.getTechnician().getTechnicianId());
			
			int count = ps.executeUpdate();
			System.out.println("\n" + count + " row/s deleted.");
			if(count>0) {
				System.out.println("WorkTypeTechnician deleted successfully");
			} 
			else {
				System.out.println("No WorkTypeTechnician found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting WorkTypeTechnician: " + e.getMessage());
			e.printStackTrace();
		}
		return workTypeTechnician;
	}

}
