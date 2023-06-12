package repairshop.dataaccess.model.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

// to convert Database Object into Data Transfer Object
public class CustomerAdapter{
	
    public Customer adaptFromDb(ResultSet record) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(record.getInt("customer_id"));
        customer.setLastName(record.getString("last_name"));
        customer.setRestOfName(record.getString("rest_of_name"));
        customer.setEmail(record.getString("email"));
        customer.setPhone(record.getString("phone"));
        return customer;
    }
}

