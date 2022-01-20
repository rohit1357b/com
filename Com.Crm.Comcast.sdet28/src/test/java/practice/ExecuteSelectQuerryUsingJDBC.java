package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class ExecuteSelectQuerryUsingJDBC {

	public static void main(String[] args) throws SQLException {
		//Register The driver
		Driver driver = new Driver(); 
		DriverManager.registerDriver(driver);
		//Establish the database connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
		//Issue the create statement
		Statement statement = connection.createStatement();
		//Execute the Query
		 ResultSet result = statement.executeQuery("select * from student");
		while (result. next()){
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			
		}
		//close the database connection
		connection.close();
		
			
		
		}
			
	
	}


	
