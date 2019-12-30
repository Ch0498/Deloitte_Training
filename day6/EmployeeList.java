package day6;


import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeList {

	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printEmployeesBeforeDate("01-JAN-10");
	}

	private static void printEmployeesBeforeDate(String date) {
		// TODO Auto-generated method stub
		Connection con=null;
		con = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		
		String sql = "select employee_id,first_name,last_name,salary,to_char(hire_date,'DD-MON-YYYY'),department_id from employees where hire_date<?";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1,date);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("DD-MMM-YYYY");
				String jDate = rs.getString(5);
				Date joinDate = sdf.parse(jDate);
				employeeList.add(new Employee(rs.getInt(1),rs.getString(2)+rs.getString(3),rs.getDouble(4),joinDate,rs.getInt(6)));
			}
			System.out.println("No of employees are: "+employeeList.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}