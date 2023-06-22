package repairshop.dataaccess.model.Technician;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "technician")
@XmlRootElement(name = "technician")
@XmlAccessorType(XmlAccessType.FIELD)
public class Technician {

	@JsonProperty("technician_id")
	@XmlAttribute(name = "technician_id", required = true)
	private int technicianId;
	
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

	@Override
	public String toString() {
		return "Technician [technicianId=" + technicianId + ", lastName=" + lastName + ", restOfName=" + restOfName
				+ ", email=" + email + ", phone=" + phone + "]";
	}
}
