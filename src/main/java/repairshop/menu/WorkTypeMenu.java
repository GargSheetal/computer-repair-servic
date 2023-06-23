package repairshop.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repairshop.dataaccess.model.Device.Device;
import repairshop.dataaccess.model.DeviceBrand.*;
import repairshop.dataaccess.model.DeviceType.*;
import repairshop.dataaccess.model.WorkType.WorkType;
import repairshop.service.*;



public class WorkTypeMenu {
	
	private static final Logger logger = LogManager.getLogger(WorkTypeMenu.class);
	private static Scanner scanner = new Scanner(System.in);
	private DeviceService deviceService;
	private WorkService workService;
	
	public WorkTypeMenu() throws IOException {
		deviceService = new DeviceService();
		workService = new WorkService();
	}
	
	public static int requestId(String prompt) {
		System.out.println(prompt);
		int id = scanner.nextInt();
		return id;
	}
	
	
	public void queryDeviceWorkType() throws SQLException {
		List<DeviceBrand> brandList = deviceService.getAllDeviceBrands();
		logger.info("\nDevice Brands : ");
		brandList.forEach(deviceBrand -> System.out.println(deviceBrand.toString()));
		
		int deviceBrandId = requestId("\nEnter Device Brand ID : ");
		DeviceBrand selectedDeviceBrand = null;
		for (DeviceBrand deviceBrand : brandList) {
            if (deviceBrand.getDeviceBrandId() == deviceBrandId) {
            	selectedDeviceBrand = deviceBrand; break;
            }
        }
		String selectedDeviceBrandName = selectedDeviceBrand.getBrandName();
		
		List<DeviceType> deviceTypeList = deviceService.getAllDeviceTypesByDeviceBrandId(deviceBrandId);
		logger.info("\nDevice Types for [" + selectedDeviceBrandName + "] : ");
		deviceTypeList.forEach(deviceType -> System.out.println(deviceType.toString()));
		
		int deviceTypeId = requestId("\nEnter Device Type ID : ");
		DeviceType selectedDeviceType = null;
		for (DeviceType deviceType : deviceTypeList) {
            if (deviceType.getDeviceTypeId() == deviceTypeId) {
            	selectedDeviceType = deviceType; break;
            }
        }
		String selectedDeviceTypeName = selectedDeviceType.getDeviceTypeName();
		
		List<Device> deviceList =  deviceService.getAllDevicesByDeviceTypeId(deviceTypeId);
		logger.info("\nDevices for [" + selectedDeviceBrandName + " | " + selectedDeviceTypeName + "]: ");
		deviceList.forEach(device -> System.out.println(device.toString()));
		
		int deviceId = requestId("\nEnter Device ID : ");
		Device selectedDevice = null;
		for (Device device : deviceList) {
            if (device.getDeviceId() == deviceId) {
            	selectedDevice = device; break;
            }
        }
		String selectedDeviceName = selectedDevice.getDeviceName();
		
		List<WorkType> workTypeList = workService.getAllWorkTypesByDeviceId(deviceId);
		logger.info("\nWork Types for [" + selectedDeviceBrandName + " | " + selectedDeviceTypeName + " | " + selectedDeviceName + "]: ");
		workTypeList.forEach(workType -> System.out.println(workType.toString()));
		
		int workTypeId = requestId("\nEnter Work Type ID : ");
		WorkType selectedWorkType = null;
		for (WorkType workType : workTypeList) {
            if (workType.getWorkTypeId() == workTypeId) {
            	selectedWorkType = workType; break;
            }
        }
		String selectedWorkTypeName = selectedWorkType.getWorkDescription();
		WorkType workType = workService.getWorkTypeById(workTypeId);
		logger.info("\nDetails of selected Work Type :");
		logger.info("\nDetails of selected Work Type [" + selectedDeviceBrandName + " | " + selectedDeviceTypeName + " | " + selectedDeviceName + " | " + selectedWorkTypeName + "]: ");
		logger.info(workType.toString());
	}
	
	public void createWorkRequest() {
		
	}
	
}

