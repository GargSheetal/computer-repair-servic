package repairshop.dataaccess.model.DeviceBrand;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// device_brands
@XmlRootElement(name="device_brands")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceBrands {

    @XmlElement(name = "device_brand")
    private List<DeviceBrand> deviceBrands;

    public List<DeviceBrand> getDeviceBrands() {
        return deviceBrands;
    }
}
