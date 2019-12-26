package assignments;

public class Person {

	private String name;
	private Address add;
	
	
	
	public Person(String name, Address add) {
		super();
		this.name = name;
		this.add = add;
	}
	
	public Person(String name2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", add=" + add + "]";
	}
}
