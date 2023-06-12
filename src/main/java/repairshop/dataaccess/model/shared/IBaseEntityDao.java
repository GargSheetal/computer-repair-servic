package repairshop.dataaccess.model.shared;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBaseEntityDao<T> {
	int create(Connection connection, T t) throws SQLException;		// returns newly created object
	List<T> getAll(Connection connection) throws SQLException;
	T getById(Connection connection, int id) throws SQLException;
	int updateById(Connection connection, T t) throws SQLException;		// returns updated object
	int deleteById(Connection connection, int id) throws SQLException;  // returns id of the deleted object

}
