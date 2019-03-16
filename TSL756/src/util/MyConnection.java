package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection
{
	private static Connection connRef; // just a reference , default value is null
	
	private MyConnection() 
	{ 
		System.out.println("MyConnection ctor...");
	}
	public static Connection getMyConnection() 
	{ // class's function  , and not the object's function
		if(connRef == null) 
		{
			try {
				//System.out.println("Trying to register the Driver ...");
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				//System.out.println("Driver registered...");
				
				//2. connect to the database
				//System.out.println("Trying to connect the database.....");
				connRef  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
				//System.out.println("Connected to the database....."+connRef);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return connRef;
	}
}