package day6;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBReader {

public static void main(String[] args) {
// TODO Auto-generated method stub

// 1.Load the driver
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
System.out.println("Driver Not Found "+e.getMessage());
}
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String username = "hr";
String password = "hr";
Connection con = null;
// 2.Get connection
try {
con = DriverManager.getConnection(url, username, password);
} catch (SQLException e) {
// TODO Auto-generated catch block
System.out.println("Connection failed. "+e.getMessage());
}

DatabaseMetaData dbmeta = null;
try {
dbmeta = con.getMetaData();
System.out.println(dbmeta.toString());
System.out.println(dbmeta.getDatabaseMajorVersion());
System.out.println(dbmeta.getDatabaseProductName());
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}



//3. Create a statement object

String sql = "select first_name,last_name,employee_id from employees";

try {
Statement st = con.createStatement();
//4. Pass sql query string and execute statement
ResultSet rs = st.executeQuery(sql);
ResultSetMetaData rsmd = rs.getMetaData();
int colCount = rsmd.getColumnCount();
System.out.println(colCount);


int type = rsmd.getColumnType(1);
if(type == Types.INTEGER) {
System.out.println("Col 1 has Integer type");
}
else if(type == Types.VARCHAR) {
System.out.println("Col 1 is a string(varchar)");
}
else if(type == Types.NUMERIC) {
System.out.println("Col 1 is numeric");
}


while(rs.next()) {
int id = rs.getInt(1);
String fname = rs.getString(1);
String lname = rs.getString(2);
System.out.println(id+" "+fname+" "+lname);
}

rs.close();
st.close();
con.close();
}
catch(SQLException sqle) {
System.out.println(sqle.getMessage());
}
}

}