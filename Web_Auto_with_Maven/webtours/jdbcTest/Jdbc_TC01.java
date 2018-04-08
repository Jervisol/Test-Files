package jdbcTest;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  

import org.testng.annotations.Test;
 
  
import com.mysql.jdbc.Driver;   

public class Jdbc_TC01 {
	@Test
	public void query() throws Exception{
	//register jdbc-mysql driver
	//DriverManager.registerDriver(new Driver());
		
	//set url(time zone): protocol:sub-protocol://localhost:3306/dbname?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	String dbaddr = "jdbc:mysql://localhost:3306/jdbctest?serverTimezone=GMT";
	//create connection
	Connection dbcon = DriverManager.getConnection(dbaddr, "root", "");
	//define statement
	Statement dbst = dbcon.createStatement();
	String sql = "select * from emp";
	//return query result
	ResultSet res = dbst.executeQuery(sql);
		while (res.next()) {  
			System.out.println(res.getString("ename")); 
			System.out.println(res.getString("sal"));
		}  
		res.close();  
		dbst.close();  
		dbcon.close();  
	}
}
