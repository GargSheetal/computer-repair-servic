
package repairservice.idao;

import java.util.List;

/**
 * @author sheetal
 *
 */
public interface IDAO<T> {
	
	T create(T t);		// returns created object
	T getById(int id);
	List<T> getAll();
	T update(T t);		// returns updated object
	int delete(int id);  // returns id of the deleted object

}
