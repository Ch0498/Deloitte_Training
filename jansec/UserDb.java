package jansec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import day6.DBConnecto;

public class UserDb{
	
	private static ArrayList<User> user1 = new ArrayList<User>();
	private static ArrayList<Role> role = new ArrayList<Role>();
	private static Map<Integer,Role> checkRoles = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllUser1();
		
	}

	private static void printAllUser1() {
		// TODO Auto-generated method stub
		Connection con=null;
		con = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		
		String sql = "select user_id,username,password,email,user1.role_id,contact_number,role_name,privs from user1 join role on user1.role_id=role.role_id";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Role r=null;
				if(checkRoles.containsKey(rs.getInt(5))) {
					r = checkRoles.get(rs.getInt(5));
				}
				else {
					r = new Role(rs.getInt(5),rs.getString(7),rs.getString(8));
					role.add(r);
				}
				user1.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),r,rs.getString(7)));
			}
			
			for(User u:user1) {
				System.out.println(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}