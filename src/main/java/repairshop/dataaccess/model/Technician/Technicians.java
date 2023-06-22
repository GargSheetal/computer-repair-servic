package repairshop.dataaccess.model.Technician;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// technicians
@XmlRootElement(name="technicians")
@XmlAccessorType(XmlAccessType.FIELD)
public class Technicians {

	@JsonProperty("technician")
	@XmlElement(name = "technician")
	private List<Technician> technicians;

	public List<Technician> getTechnicians() {
		return technicians;
	}
}