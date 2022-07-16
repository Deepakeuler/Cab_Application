package Module1;

public class Vehicle {
	
	private String vehicleID;
	
	private String number;
	
	private String type;
	
	private String color;
	
	private String name;

	public Vehicle(String carName, String carNumber) {
		this.vehicleID = carNumber;
		this.number = carNumber;
		this.name = carName;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	}
