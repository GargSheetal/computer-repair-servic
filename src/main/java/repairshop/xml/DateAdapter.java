package repairshop.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	
	@Override
	public Date unmarshal(String dateStr) throws Exception {
		return dateFormat.parse(dateStr);
	}

	@Override
	public String marshal(Date date) throws Exception {
		return dateFormat.format(date);
	}

}
