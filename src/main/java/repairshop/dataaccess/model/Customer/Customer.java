package repairshop.dataaccess.model.Customer;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer {
	
	@JsonProperty("customer_id")
	@XmlAttribute(name = "customer_id", required = true)
	private int customerId;
	
	@JsonProperty("last_name")
	@XmlElement(name = "last_name")
	private String lastName;
	
	@JsonProperty("rest_of_name")
	@XmlElement(name = "rest_of_name")
	private String restOfName;
	
	@JsonProperty("email")
	@XmlElement(name = "email")
	private String email;
	
	@JsonProperty("phone")
	@XmlElement(name = "phone")
	private String phone;
	
	public Customer() {
	}

	public Customer(String lastName, String restOfName, String email, String phone) {
		this.lastName = lastName;
		this.restOfName = restOfName;
		this.email = email;
		this.phone = phone;
	}
	
	public Customer(int customerId, String lastName, String restOfName, String email, String phone) {
		this.customerId = customerId;
		this.lastName = lastName;
		this.restOfName = restOfName;
		this.email = email;
		this.phone = phone;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String customerName) {
		this.lastName = customerName;
	}

	public String getRestOfName() {
		return restOfName;
	}

	public void setRestOfName(String restOfName) {
		this.restOfName = restOfName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return ("Customer ID: " + this.getCustomerId() + "\n" + 
				"Customer Last name: " + this.getLastName() + "\n" + 
				"Customer Rest of name: " + this.getRestOfName() + "\n" + 
				"Customer Email: " + this.getEmail() + "\n" +  
				"Customer Phone: " + this.getPhone() + "\n");
	}
		
}












