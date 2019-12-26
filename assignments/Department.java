package assignments;

public class Department {

	private String location;
	private String name;
	
	public Department(String location) {
		super();
		this.location = location;
	}

	public Department(String string, String string2) {
		// TODO Auto-generated constructor stub
		location=string;
		name=string2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "Department [location=" +location + "]";
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
