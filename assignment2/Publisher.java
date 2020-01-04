package assignment2;

public class Publisher {
	
	private int publisherid;
	private String name;
	private String city;
	public Publisher(int publisherid, String name, String city) {
		this.publisherid = publisherid;
		this.name = name;
		this.city = city;
	}
	
	public int getpublisherid() {
		return publisherid;
	}
	
	public void setpublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Publisher [name=" + name + ", city=" + city + "]";
	}
	
	

}