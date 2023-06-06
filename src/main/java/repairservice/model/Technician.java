package repairservice.model;

public class Technician {

	private int technicianId;
	private String lastName;
	private String restOfName;
	private String email;
	private String phone;
	
	public Technician(){}
	
	public Technician(int technicianId, String lastName, String restOfName, String email, String phone) {
		this.technicianId = technicianId;
		this.lastName = lastName;
		this.restOfName = restOfName;
		this.email = email;
		this.phone = phone;
	}

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
