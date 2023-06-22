package repairshop.dataaccess.model.WorkType;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// work_types
@XmlRootElement(name="work_types")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkTypes {

	@JsonProperty("work_type")
    @XmlElement(name = "work_type")
    private List<WorkType> workTypes;

    public List<WorkType> getWorkTypes() {
        return workTypes;
    }
}