package org.sdet38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromExecuteUpdate
{
	public static void main(String[] args) throws SQLException
	{
			//Step 1:-object for DB driver class//
				Driver dbDriver=new Driver();
				
			//Step 2:-register the driver to the jdbc//
				DriverManager.registerDriver(dbDriver);
				Connection connection=null;
				
			//Step 3:- establish the connection-provide database name//
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
	
				
			//Step 4:- create statement //
				Statement state=connection.createStatement();
					
			//Stpe 5:- excecute the query//
				String query="insert into empdetails(empId,empName,phone_number)values(15,'priya',24544556);";
				int result=state.executeUpdate(query);
				System.out.println(result);
				
				
			//Step 6:-validate
				if(result==1)
				{
					System.out.println("data added sucesffully");
				}
				else
				{
					System.out.println("data not added");
				}
				
			//Step 7:-close connection
				connection.close();
				System.out.println("connection closed");	
	}

}



