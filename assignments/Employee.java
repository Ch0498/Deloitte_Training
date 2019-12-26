package assignments;

public class Employee extends Person {
	
	private int id;
	private Department dept;
	
	
	public Employee (String name, int id, Department dept) {
		super(name);
		this.id = id;
		this.dept = dept;
	
	}


	public Employee(String string, Address add1, int i, Department hr) {
		// TODO Auto-generated constructor stub
		super(string,add1);
		id=i;
		dept=hr;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
}
