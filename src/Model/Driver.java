package Model;

public class Driver {

	private String driverId;

	private String name;

	private String address;

	private String email;

	private Location driverLocation;

	private int age;

	private String contact;

	private String gender;

	private String idProof;

	private Vehicle car;

	private boolean status;
	
	private int earnings;

	
	public Driver(String driverId, String driverName, String gender, int age, String carName, String carNumber,
			Location driverLocation) {
		this.driverId = driverId;
		this.name = driverName;
		this.gender = gender;
		this.age = age;

		this.driverLocation = driverLocation;
		Vehicle newVehicle = new Vehicle(carName, carNumber);
		this.car = newVehicle;
		this.earnings = 0;
		this.status = true;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getDriverLocation() {
		return driverLocation;
	}

	public void setDriverLocation(Location driverLocation) {
		this.driverLocation = driverLocation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}


}
