package repairshop.dataaccess.model.DeviceType;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// device_types
@XmlRootElement(name="device_types")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceTypes {

    @XmlElement(name = "device_type")
    private List<DeviceType> deviceTypes;

    public List<DeviceType> getDeviceTypes() {
        return deviceTypes;
    }
}
