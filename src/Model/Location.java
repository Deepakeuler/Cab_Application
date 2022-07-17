package Model;

public class Location {

	public float latitude;
	public float longitude;

	public Location(float lat, float lon) {
		// TODO Auto-generated constructor stub
		this.latitude = lat;
		this.longitude = lon;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
