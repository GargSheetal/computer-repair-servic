package repairshop.dataaccess.model.Technician;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDaoImpl implements ITechnicianDao {
    // create
    public int create(Connection connection, Technician technician) throws SQLException {
        int generatedId = -1;
        String query = "INSERT into technicians (last_name, rest_of_name, email, phone) values(?, ?, ?, ?)";
        
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
        	ps.setString(1, technician.getLastName());
			ps.setString(2, technician.getRestOfName());
			ps.setString(3, technician.getEmail());
			ps.setString(4, technician.getPhone());

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

    // getById
    public Technician getById(Connection connection, int technicianId) throws SQLException {
        Technician technician = null;
        String query = "SELECT * from technicians where technician_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, technicianId);
            
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    TechnicianAdapter technicianAdapter = new TechnicianAdapter();
                    technician = technicianAdapter.adaptFromDb(resultSet);
                }
            }
            
        }
        return technician;
    }

    // getAll
    public List<Technician> getAll(Connection connection) throws SQLException {
        List<Technician> technicianList = new ArrayList<>();
        String query = "SELECT * from technicians"; 

        try(
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet resultSet = ps.executeQuery();
            ){
            while (resultSet.next()) {
                TechnicianAdapter technicianAdapter = new TechnicianAdapter();
                Technician technician = technicianAdapter.adaptFromDb(resultSet);
                technicianList.add(technician);
            }
        }
        return technicianList;
    }

    // updateById
    public int updateById(Connection connection, Technician technician) throws SQLException {
        int rowsAffected = 0;
        String query = "UPDATE technicians SET last_name=?, rest_of_name=?, email=?, phone=? WHERE technician_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
        	ps.setString(1, technician.getLastName());
			ps.setString(2, technician.getRestOfName());
			ps.setString(3, technician.getEmail());
			ps.setString(4, technician.getPhone());
			ps.setInt(5, technician.getTechnicianId());
            
            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

    // deleteById
    public int deleteById(Connection connection, int technicianId) throws SQLException {
        int rowsAffected = 0;
        String query = "DELETE from technicians WHERE technician_id=?";
        
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, technicianId);
            
            rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        }
        return rowsAffected;
    }

}