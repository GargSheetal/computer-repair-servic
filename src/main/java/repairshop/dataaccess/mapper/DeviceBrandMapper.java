/**
 * 
 */
package repairshop.dataaccess.mapper;

import java.util.List;

import repairshop.dataaccess.model.DeviceBrand.DeviceBrand;

/**
 * @author sheetal
 *
 */

public interface DeviceBrandMapper {
	
	DeviceBrand selectDeviceBrandById(int deviceBrandId);
	
	DeviceBrand selectDeviceBrandByBrandName(String brandName);
	
	List<DeviceBrand> getAllDeviceBrands();
	
	void addDeviceBrand(DeviceBrand deviceBrand);
	
	void updateDeviceBrand(DeviceBrand deviceBrand);
	
	void deleteDeviceBrand(int deviceBrandId);

}
