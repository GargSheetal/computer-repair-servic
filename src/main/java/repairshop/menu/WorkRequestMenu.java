package repairshop.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repairshop.dataaccess.model.Customer.Customer;
import repairshop.dataaccess.model.CustomerDevice.CustomerDevice;
import repairshop.dataaccess.model.Device.Device;
import repairshop.dataaccess.model.DeviceBrand.*;
import repairshop.dataaccess.model.DeviceType.*;
import repairshop.dataaccess.model.WorkRequest.WorkRequest;
import repairshop.dataaccess.model.WorkRequestPayment.WorkRequestPayment;
import repairshop.dataaccess.model.WorkType.WorkType;
import repairshop.service.*;
import repairshop.strategy.*;


public class WorkRequestMenu {
	
	private static final Logger logger = LogManager.getLogger(WorkRequestMenu.class);
	private static Scanner scanner = new Scanner(System.in);
	private DeviceService deviceService;
	private WorkService workService;
	private WorkRequestService workRequestService;
	private CustomerDeviceService customerDeviceService;
	
	public WorkRequestMenu() throws IOException {
		deviceService = new DeviceService();
		workService = new WorkService();
		workRequestService = new WorkRequestService();
		customerDeviceService = new CustomerDeviceService();
	}
	
	public static int requestInt(String prompt) {
		System.out.println(prompt);
		int val = scanner.nextInt();
		return val;
	}
	
	public static String requestString(String prompt) {
		System.out.println(prompt);
		scanner.nextLine(); 
		String val = scanner.nextLine();
		return val;
	}
	
	public Customer getCustomer() throws SQLException, IOException {
		logger.info("\n 1. Create New Account");
		logger.info("\n 2. Login");
		int selectedAccountOption = requestInt("\n Enter selection : ");
		
		CustomerMenu customerMenu = null;
		Customer customer = null;
		
		switch(selectedAccountOption) {
			case 1:
				customerMenu = new CustomerMenu();
				customer = customerMenu.createCustomer();
				break;
			case 2: 
				customerMenu = new CustomerMenu();
				customer = customerMenu.login();
				break;
			default: 
				throw new Error("Bad Input!");
		}
		return customer;
	}
	
	public CustomerDevice selectExistingCustomerDevice(Customer customer) throws IOException, SQLException {
		CustomerDeviceService customerDeviceService = new CustomerDeviceService();
		List<CustomerDevice> customerDeviceList = customerDeviceService.getAllCustomerDevicesByCustomerId(customer.getCustomerId());
		
		logger.info("\n ***** Customer Devices List ***** ");
		customerDeviceList.forEach(customerDevice -> System.out.println(customerDevice.toString()));
		
		int selectedCustomerDeviceId = requestInt("\nSelect Customer Device ID : ");
		CustomerDevice selectedCustomerDevice = null;
		
		for (CustomerDevice customerDevice : customerDeviceList) {
            if (customerDevice.getCustomerDeviceId() == selectedCustomerDeviceId) {
            	selectedCustomerDevice = customerDevice; break;
            }
        }
		return selectedCustomerDevice;
		
	}
	
	public Device selectNewDevice() throws SQLException {
		logger.info("\n ***** Select New Device ***** ");
		List<DeviceBrand> brandList = deviceService.getAllDeviceBrands();
		logger.info("\nDevice Brands : ");
		brandList.forEach(deviceBrand -> System.out.println(deviceBrand.toString()));
		
		int deviceBrandId = requestInt("\nEnter Device Brand ID : ");
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
		
		int deviceTypeId = requestInt("\nEnter Device Type ID : ");
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
		
		int deviceId = requestInt("\nEnter Device ID : ");
		Device selectedDevice = null;
		for (Device device : deviceList) {
            if (device.getDeviceId() == deviceId) {
            	selectedDevice = device; break;
            }
        }
		return selectedDevice;
	}
	
	public String inputSerialNumber() {
		logger.info("\nEnter Serial Number : ");
		String serialNumber = scanner.nextLine();
		return serialNumber;
	}
	
	public CustomerDevice createNewCustomerDevice(Customer customer, Device device, String serialNumber) throws SQLException {
		CustomerDevice customerDevice = new CustomerDevice();
		customerDevice.setCustomer(customer);
		customerDevice.setDevice(device);
		customerDevice.setSerialNumber(serialNumber);
		return customerDeviceService.createCustomerDevice(customerDevice);
	} 
	
	public WorkType selectWorkType(Device device) throws SQLException {
		List<WorkType> workTypeList = workService.getAllWorkTypesByDeviceId(device.getDeviceId());
		logger.info("\nWork Types for selected device : ");
		workTypeList.forEach(workType -> System.out.println(workType.toString()));
		
		int workTypeId = requestInt("\nSelect Work Type ID to create Work Request: ");
		WorkType selectedWorkType = null;
		for (WorkType workType : workTypeList) {
            if (workType.getWorkTypeId() == workTypeId) {
            	selectedWorkType = workType; break;
            }
        }
		return selectedWorkType;
	}
	
	public String inputWorkDescription() {
		String workDescription = requestString("\nEnter Work Description : ");
		return workDescription;
	}
	
	public WorkRequest createNewWorkRequest(CustomerDevice customerDevice, WorkType workType, String workDescription) throws SQLException {
		WorkRequest workRequest = new WorkRequest();
		workRequest.setCustomerDevice(customerDevice);
		workRequest.setWorkType(workType);
		workRequest.setWorkRequestDescription(workDescription);
		workRequest.setCreatedTimestamp(new Date(System.currentTimeMillis()));
		return workRequestService.createWorkRequest(workRequest);
	}
	
	public PaymentStrategy selectPaymentStrategy() {
		logger.info("\n ***** Select Payment Option ***** ");
		logger.info("\n 1. Paypal");
		logger.info("\n 2. Apple Pay");
		logger.info("\n 3. Google Pay");
		logger.info("\n 4. Credit Card");
		int selectedPaymentOption = requestInt("\n Enter selection : ");
		
		PaymentStrategy selectedPaymentStrategy = null;
		switch(selectedPaymentOption) {
			case 1: selectedPaymentStrategy = getPaypalPaymentStrategy(); break;
			case 2: selectedPaymentStrategy = getApplePayPaymentStrategy(); break;
			case 3: selectedPaymentStrategy = getGooglePayPaymentStrategy(); break;
			case 4: selectedPaymentStrategy = getCreditCardPaymentStrategy(); break;
			default: throw new Error("Bad Input!");
		}
		return selectedPaymentStrategy;
	}
	
	public PayPalPaymentStrategy getPaypalPaymentStrategy() {
		String paypalId = requestString("\nEnter Paypal ID : ");
		return new PayPalPaymentStrategy(paypalId);
	}
	
	public ApplePayPaymentStrategy getApplePayPaymentStrategy() {
		String applePayId = requestString("\nEnter ApplePay ID : ");
		return new ApplePayPaymentStrategy(applePayId);
	}
	
	public GooglePayPaymentStrategy getGooglePayPaymentStrategy() {
		String googlePayId = requestString("\nEnter GooglePay ID : ");
		return new GooglePayPaymentStrategy(googlePayId);
	}
	
	public CreditCardPaymentStrategy getCreditCardPaymentStrategy() {
		String creditCardNumber = requestString("\nEnter CreditCard Number : ");
		return new CreditCardPaymentStrategy(creditCardNumber);
	}

	public WorkRequestPayment createNewWorkRequestPayment(WorkRequest workRequest, double amount, PaymentStrategy paymentStrategy) throws SQLException {
		PaymentSystem paymentSystem = new PaymentSystem();
		paymentSystem.setPaymentStrategy(paymentStrategy);
		String confirmationNumber = paymentSystem.processPayment(amount);
		WorkRequestPayment workRequestPayment = new WorkRequestPayment();
		workRequestPayment.setAmount(amount);
		workRequestPayment.setWorkRequest(workRequest);
		workRequestPayment.setPaymentConfirmationNumber(confirmationNumber);
		workRequestPayment.setPaymentTimestamp(new Date(System.currentTimeMillis()));
		workRequestPayment.setPaymentGateway(paymentSystem.getPaymentGatewayName());
		return workRequestService.createWorkRequestPayment(workRequestPayment);
	}
}

