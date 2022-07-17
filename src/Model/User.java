package Model;

public class User {
	private String user_id;
	
	private String name;
	
	private Location userLocation;
	
	private String contact;
	
	private String email;
	
	private String gender;
	
	private int age;
	
	
	
	private boolean is_active;

	public User(String userId, String username, String gender, int age) {
		this.user_id = userId;
		this.name = username;
		this.gender = gender;
		this.age = age;
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



}
