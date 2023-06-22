package repairshop.dataaccess.model.CustomerDevice;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDevices {
	
	@JsonProperty("customer_device")
	private List<CustomerDevice> customerDeviceList;

	public List<CustomerDevice> getCustDeviceList() {
		return customerDeviceList;
	}
}
