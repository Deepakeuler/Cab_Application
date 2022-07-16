package Module1;


public class Main {
	
	/*
	 * User id has been kept as : username+phoneNumber to maintain the uniqueness. 
	 * Choosing username as userid will not maintain the unique constraint
	 */

	public static void main(String[] args) {

		CabApplication ola = new CabApplication();
		/*
		add_user(“Abhishek, M, 23”); update_userLocation(“Abhishek”,(0,0)) 
		add_user(“Rahul , M, 29”); update_userLocation(“Rahul”,(10,0))
		add_user(“Nandini, F, 22”) ;update_userLocation(“Nandini”,(15,6))
		 */
		User u1 = ola.addUser("Abhishek", "9034", "M", 21);
		User u2 = ola.addUser("Rahul", "5234", "M", 29);
		User u3 = ola.addUser("Nandini", "1010", "F", 22);
		System.out.println("user added");
		
		u1.setUserLocation(new Location(0,0));
		u2.setUserLocation(new Location(10,0));
		u3.setUserLocation(new Location(15,6));
				
		/*
		 * add_driver(“Driver1, M, 22”,“Swift, KA-01-12345”,(10,1))
add_driver(“Driver2, M, 29”,“Swift, KA-01-12345”,(11,10))
add_driver(“Driver3, M, 24”,“Swift, KA-01-12345”,(5,3))

		 */
		
		ola.addDriver("Driver1","720", "M", 22, "Swift", "KA-01-12345", new Location(10,1));
		ola.addDriver("Driver2","990", "M", 29, "Swift", "KA-01-12345", new Location(11,10));
		ola.addDriver("Driver3","1920", "M", 24, "Swift", "KA-01-12345", new Location(5,3));
		System.out.println("Driver added");
//		find_ride(“Abhishek” ,(0,0),(20,1))
		
		System.out.println("Finding ride added");
		ola.findRide("Abhishek", "9034", new Location(0,0), new Location(20,1));
		//find_ride(“Rahul” ,(10,0),(15,3))
		
		
		/*
		 * choose_ride(“Rahul”,”Driver1”)

		 */
		ola.chooseRide("Rahul","5234",  "Driver1", "720");
		ola.calculate_bill("Rahul", "5234");
		ola.find_total_earning();
		
		
	}

}
