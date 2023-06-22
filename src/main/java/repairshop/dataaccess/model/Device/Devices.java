package repairshop.dataaccess.model.Device;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

// devices
@XmlRootElement(name="devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class Devices {

	@JsonProperty("device")
    @XmlElement(name = "device")
    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }
}