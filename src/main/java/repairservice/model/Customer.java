package repairservice.model;

public class Customer {

	private int customerId;
	private String lastName;
	private String restOfName;
	private String email;
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

}

