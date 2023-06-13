package repairshop.dataaccess.model.WorkTypeTechnician;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkTypeTechnicianDaoImpl implements IWorkTypeTechnicianDao {
    // create 
    public int create(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException {
        int generatedId = -1;
        String command = "INSERT into work_type_technicians (work_type_id, technician_id, skill_level) values(?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(command)){
            ps.setInt(1, workTypeTechnician.getWorkType().getWorkTypeId());
            ps.setInt(2, workTypeTechnician.getTechnician().getTechnicianId());
            ps.setInt(3, workTypeTechnician.getSkillLevel());

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

 // getAllByWorkTypeId
    public List<WorkTypeTechnician> getAllByWorkTypeId(Connection connection, int workTypeId) throws SQLException {
        List<WorkTypeTechnician> workTypeTechnicianList = new ArrayList<>();
        String query = "SELECT * from work_type_technicians WHERE work_type_id = ?"; 
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workTypeId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
                    WorkTypeTechnicianAdapter workTypeTechnicianAdapter = new WorkTypeTechnicianAdapter();
                    WorkTypeTechnician workTypeTechnician = workTypeTechnicianAdapter.adaptFromDb(resultSet);
                    workTypeTechnicianList.add(workTypeTechnician);
                }
            }
            
        }
        return workTypeTechnicianList;
    }

    // getAllByTechnicianId
    public List<WorkTypeTechnician> getAllByTechnicianId(Connection connection, int technicianId) throws SQLException {
        List<WorkTypeTechnician> workTypeTechnicianList = new ArrayList<>();
        String query = "SELECT * from work_type_technicians WHERE technician_id = ?"; 
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, technicianId);
            
            try(ResultSet resultSet = ps.executeQuery()){
            	while (resultSet.next()) {
                    WorkTypeTechnicianAdapter workTypeTechnicianAdapter = new WorkTypeTechnicianAdapter();
                    WorkTypeTechnician workTypeTechnician = workTypeTechnicianAdapter.adaptFromDb(resultSet);
                    workTypeTechnicianList.add(workTypeTechnician);
                }
            }
            
        }
        return workTypeTechnicianList;
    }

    // update
    public int update(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE work_type_technicians SET skill_level=? WHERE work_type_id=? and technician_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, workTypeTechnician.getSkillLevel());
            ps.setInt(2, workTypeTechnician.getWorkType().getWorkTypeId());
            ps.setInt(3, workTypeTechnician.getTechnician().getTechnicianId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // delete
    public int delete(Connection connection, WorkTypeTechnician workTypeTechnician) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE FROM work_type_technicians WHERE work_type_id=? and technician_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
        	ps.setInt(1, workTypeTechnician.getWorkType().getWorkTypeId());
            ps.setInt(2, workTypeTechnician.getTechnician().getTechnicianId());

            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }
}