package Service;
import Model.*;
import Service.*;

import java.util.*;

public class CabApplication {
	
	/*
	 * User database, 
	 * driver database
	 */
	
	private HashMap<String, User> allusers = new HashMap<>();
	private HashMap<String, Driver> allDrivers = new HashMap<>();
	private HashMap<User,Driver> ongoingRides = new HashMap<>();
	private HashMap<User, Location> locationChanges = new HashMap<>();
	
	public User addUser(String username, String phoneNumber, String gender, int age) {
		String generatedUserId = username + phoneNumber;
		return addUser(generatedUserId, phoneNumber, username, gender, age);
	} 
	
	private User addUser(String userId, String phoneNumber , String username, String gender, int age) {
		//HashMap<String>
		User newUser;
		if(allusers.containsKey(userId)) {
			newUser = allusers.get(userId);
			
		}
		else {
			 newUser  = new User(userId, username, gender, age);
			allusers.put(userId, newUser);
		}
		return newUser;
	}
	
	public void addDriver(String driverName,String phoneNumber, String gender, int age, String carName, String carNumber, Location driverLocation) {
		String generateDriverId = driverName+phoneNumber;
		addDriver(generateDriverId,phoneNumber,driverName,gender,age,carName,carNumber,driverLocation);
	}
	
	
	private void addDriver(String driverId,String phoneNumber, String driverName, String gender, int age, String carName, String carNumber, Location driverLocation) {
		if(allDrivers.containsKey(driverId)) {
			
		}else {
			Driver newDriver = new Driver(driverId, driverName, gender, age, carName, carNumber, driverLocation);
			allDrivers.put(driverId, newDriver);
		}
		
	}
	
	public void updateUserLocation(String username, String userId, Location user_location) {
		
		if(!this.allusers.containsKey(userId)) {
			System.out.println("Invalid userId");
			return;
		}
		User userObj = this.allusers.get(userId);
		userObj.setUserLocation(user_location);
		
	}
	
	public List<Driver> findRide(String user_name, String userPhoneNumber, Location startLocation, Location endlocation) {
		//assuming the threshold is 5kms or 5000 ms. 
		/*
		 * Returns all the drivers in 5000m vicinity of the user. 
		 */
		double thresholdKilometers = 5;
		List<Driver> output = new ArrayList<>();
		
		User user_id = allusers.get(user_name+userPhoneNumber);
		locationChanges.put(user_id, endlocation);
		
		for(String driverId : allDrivers.keySet()) {
			Driver driverObj = allDrivers.get(driverId);
			Location driverLocation = driverObj.getDriverLocation();
			double dist = findDistance(startLocation, driverLocation);
			if(driverObj.isStatus() == true && dist <= thresholdKilometers) {
				//
				output.add(driverObj);
			}
		}
		System.out.println("Total Available drivers: "+output.size());
		//System.out.println("Available drivers are : "+output);
		
		return output;
		
		
	}
	
	public double findDistance(Location startLocation, Location driverLocation) {
		// 
		float x1 = startLocation.getLatitude();
		float x2 = startLocation.getLongitude();
		
		float y1 = driverLocation.getLatitude();
		float y2 = driverLocation.getLongitude();
		
		return Math.sqrt(Math.pow((x2 - x1),2)*1.0 + Math.pow((y2 - y1),2)*1.0) ;
	}
	

	public void chooseRide(String userId, String userPhoneNumber,  String driverId, String driverPhoneNumber) {
		
		User u1 = allusers.get(userId+userPhoneNumber);
		Driver d1 = allDrivers.get(driverId+driverPhoneNumber);
		d1.setStatus(false);
		ongoingRides.put(u1, d1);
		System.out.println(u1.getName()+" is driving with "+d1.getName());
		//System.out.println(ongoingRides);
	}
	
	public int calculate_bill(String username, String userPhoneNumber) {
		/*
		 * if user is on a ride. then only calculate bill and remove him from ongoing rides.
		 * and make driver available. 
		 */
		int assumedBillAmountPerRide = 100;
		User currentUserObj = allusers.get(username+ userPhoneNumber);
		if(!ongoingRides.containsKey(currentUserObj)) return -1;
		
		Driver driverObj = ongoingRides.get(currentUserObj);
		
		driverObj.setStatus(true);
		int oldEarnigns = driverObj.getEarnings();
		driverObj.setEarnings(oldEarnigns+assumedBillAmountPerRide);
		
		System.out.println(" Your ride has ended , the bill amount is: "+assumedBillAmountPerRide );
		
		ongoingRides.remove(currentUserObj);
		
		Location locationToUpdate = locationChanges.get(currentUserObj);
		currentUserObj.setUserLocation(locationToUpdate);
		driverObj.setDriverLocation(locationToUpdate);
		
		return assumedBillAmountPerRide;
	}
	
	public void find_total_earning() {
		
		for(String driverId : allDrivers.keySet()) {
			Driver driverObj = allDrivers.get(driverId);
			System.out.println(driverObj.getName()+" : "+driverObj.getEarnings());
		}
		return;
		
		
	}

}
