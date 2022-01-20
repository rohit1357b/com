package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

public class ExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// Register the driver
		Driver driver = new Driver(); 
		DriverManager.registerDriver(driver);
		//Establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
		//Issue the create statement
		Statement statement = connection.createStatement();
		//Execute the querry
		int result =statement.executeUpdate("insert into student values(103,'Tom','science');");	
		if(result==1) {
			System.out.println("Database has been updated");
			
		}
		else System.out.println("Database  not updated");
		
		//close the database connection
		
	
		connection.close();
	}

}
