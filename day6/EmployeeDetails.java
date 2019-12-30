package day6;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDetails {
	Connection con = null;
public EmployeeDetails() {}

public void listJoiningDate(String date) {
DBConnecto connector = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
con = connector.getConnection();
String sql = "select last_name, hire_date from employees where hire_date <'01-FEB-08'";


try {
PreparedStatement pst = con.prepareStatement(sql);

ResultSet rs = pst.executeQuery();
while(rs.next()) {
System.out.println(rs.getString(1)+":"+rs.getString(2));
}
}catch (SQLException e) {

System.out.println(e);
}}


public static void main(String[] args) {
// TODO Auto-generated method stub
new EmployeeDetails().listJoiningDate("01-FEB-08");

}

}