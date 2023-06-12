package repairservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDevices {
	
	@XmlElement(name = "customer_device")
	private List<CustomerDevice> custDeviceList;

	public List<CustomerDevice> getCustDeviceList() {
		return custDeviceList;
	}
}
