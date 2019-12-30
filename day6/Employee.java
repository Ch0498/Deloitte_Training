package day6;

import java.util.Date;

public class Employee {
	
	private int id;
	private String full_name;
	private double salary;
	private Date join_date;
	private int dept_id;
	
	public Employee(int id, String full_name, double salary, Date join_date, int dept_id) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.salary = salary;
		this.join_date = join_date;
		this.dept_id = dept_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", full_name=" + full_name + ", salary=" + salary + ", join_date=" + join_date
				+ ", dept_id=" + dept_id + "]";
	}
	
	

}