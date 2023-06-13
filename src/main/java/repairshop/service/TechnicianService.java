package repairshop.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repairshop.dataaccess.db.DatabaseConnectionManager;
import repairshop.dataaccess.model.WorkTypeTechnician.*;



public class TechnicianService {

	private WorkTypeTechnicianDaoImpl workTypeTechnicianDaoImpl;
	private DatabaseConnectionManager connectionManager;
	
	public TechnicianService() throws IOException {
		this.workTypeTechnicianDaoImpl = new WorkTypeTechnicianDaoImpl();
		this.connectionManager = new DatabaseConnectionManager();
	}
	
	public List<WorkTypeTechnician> getAllTechniciansByWorkTypeId(int workTypeId) throws SQLException {
		Connection connection = null;
		List<WorkTypeTechnician> workTypeTechnicianList = null;
		try {
            connection = connectionManager.getConnection();
            workTypeTechnicianList = workTypeTechnicianDaoImpl.getAllByWorkTypeId(connection, workTypeId);
        } finally {
        	this.connectionManager.closeConnection(connection);
        }
		return workTypeTechnicianList;
	}
}
