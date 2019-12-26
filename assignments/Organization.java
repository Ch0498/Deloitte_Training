package assignments;

public class Organization {
	
	public static Employee[] emps = new Employee[5];
	
	
	
	public static void main(String[] args) {
		
		Department hr = new Department("Hyderabad","HR");
		Department dev = new Department("Bengaluru","Dev");
		Department test = new Department("Chennai","Test");
		
		Address add1 = new Address(1,"Street1", "Hyderabad", "Telangana");		
		Address add2 = new Address(2,"Street2", "Hyderabad", "Telangana");
		Address add3 = new Address(3,"Street3", "Hyderabad", "Telangana");
		Address add4 = new Address(4,"Street4", "Hyderabad", "Telangana");
		Address add5 = new Address(5,"Street5", "Hyderabad", "Telangana");
		
		Employee e1 = new Employee(" Emp1", add1, 1, hr);
		Employee e2 = new Employee(" Emp1", add2, 2, dev);
		Employee e3 = new Employee(" Emp1", add3, 3, dev);
		Employee e4 = new Employee(" Emp1", add4, 4, dev);
		Employee e5 = new Employee(" Emp1", add5, 5,test);
		
		emps[0] = e1;
		emps[1] = e2;
		emps[2] = e3;
		emps[3] = e4;
		emps[4] = e5;
		
		printEmployees(dev);
		printDept(e1);
	
		
	}
	
	public static void printEmployees(Department d) {
		
		for (int i = 0; i < 5; i++) {
			if(emps[i].getDept() == d) {
				System.out.println(emps[i]);
			}
		}
	}
	
	
	public static void printDept (Employee e) {
		
		System.out.println(e.getDept().getName());
	}

	
	public static void noDeptEmployees() {
		for (int i = 0; i < 5; i++) {
			if(emps[i].getDept() == null) {
				System.out.println(emps[i]);
			}
		}
	}
	
}