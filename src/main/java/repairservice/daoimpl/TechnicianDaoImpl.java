package repairservice.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairservice.db.ConnectionPool;
import repairservice.idao.ITechnicianDao;
import repairservice.model.Technician;

public class TechnicianDaoImpl implements ITechnicianDao {

	ResultSet rs = null;
	Technician technician = null;
	@Override
	public Technician create(Technician technician) {
		String query = "INSERT into technician(last_name, rest_of_name, email, phone) values(?,?,?,?)";

		// get connection
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, technician.getLastName());
			ps.setString(2, technician.getRestOfName());
			ps.setString(3, technician.getEmail());
			ps.setString(4, technician.getPhone());

			//execute query
			int rowsAffected = ps.executeUpdate();
			System.out.println("\n" + rowsAffected + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error creating technician: " + e.getMessage());
			e.printStackTrace();
		}
		return technician;
	}

	@Override
	public Technician getById(int technicianId) {
		String query = "SELECT * from technician where technician_id=?"; 
		try(Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, technicianId);
			// execute the query
			rs = ps.executeQuery();

			// create a Technician object and populate its data
			if(rs.next()) {
				technician = new Technician();
				technician.setTechnicianId(rs.getInt("technician_id"));
				technician.setLastName(rs.getString("last_name"));
				technician.setRestOfName(rs.getString("rest_of_name"));
				technician.setEmail(rs.getString("email"));
				technician.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving technician: " + e.getMessage());
			e.printStackTrace();
		}
		return technician;
	}

	@Override
	public List<Technician> getAll() {
		List<Technician> techList = new ArrayList<>();
		String query = "SELECT * from technician"; 

		try(Connection conn = ConnectionPool.getConnection();
			   PreparedStatement st = conn.prepareStatement(query)) {
			rs = st.executeQuery();
			while(rs.next())
			{
				technician = new Technician(rs.getInt("technician_id"), rs.getString("last_name"), rs.getString("rest_of_name"), rs.getString("email"), rs.getString("phone"));
				techList.add(technician);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving technicians: " + e.getMessage());
			e.printStackTrace();
		}
		return techList;
	}

	@Override
	public Technician update(Technician technician) {
		String query = "UPDATE technician SET last_name=?, rest_of_name=?, email=?, phone=? WHERE technician_id=?"; 
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {		
			ps.setString(1, technician.getLastName());
			ps.setString(2, technician.getRestOfName());
			ps.setString(3, technician.getEmail());
			ps.setString(4, technician.getPhone());

			//execute query
			int count = ps.executeUpdate();
			System.out.println(count + " row/s affected");
		} catch (SQLException e) {
			System.out.println("Error updating technician: " + e.getMessage());
			e.printStackTrace();
		}
		return technician;
	}

	@Override
	public int delete(int technicianId) {
		String query = "DELETE from technician WHERE technician_id = ?";
		try (Connection conn = ConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
			// Set the value for the prepared statement
			ps.setInt(1, technicianId);
			int count = ps.executeUpdate();
			System.out.println("\n" + count + " row/s deleted.");
			if(count>0) {
				System.out.println("Technician with ID: " + technicianId + " deleted successfully");
			} 
			else {
				System.out.println("No technician with ID: " + technicianId + " found");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting technician: " + e.getMessage());
			e.printStackTrace();
		}
		return technicianId;
	}

}
