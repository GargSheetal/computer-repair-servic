package repairshop.dataaccess.model.Technician;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// technicians
@XmlRootElement(name="technicians")
@XmlAccessorType(XmlAccessType.FIELD)
public class Technicians {

	@XmlElement(name = "technician")
	private List<Technician> technicians;

	public List<Technician> getTechnicians() {
		return technicians;
	}
}