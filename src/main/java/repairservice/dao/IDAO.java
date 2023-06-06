/**
 * 
 */
package repairservice.dao;

import java.util.List;

/**
 * @author sheetal
 *
 */
public interface IDAO<T> {
	
	void create(T t);
	T getById(int id);
	List<T> getAll();
	void update(T t, String[] params);
	void delete(int id);

}
