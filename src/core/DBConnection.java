package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DBConnection 
{
	private static String dburl = "jdbc:mysql://jenna.bendiksens.net:3306/bob";
	
	public DBConnection()
	{
		
	}
	
	public void getSomething()
	{
		try{
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        }
	        catch (IllegalAccessException e)
	        {System.out.println(e);}
			catch(InstantiationException e)
	        {System.out.println(e);}
	        catch(ClassNotFoundException e)
	        {System.out.println(e);}

		try
		{ 
            Connection conn = DriverManager.getConnection(dburl,"bob","bob123"); 

            String sql_Q ="SELECT * FROM simulering";
    		PreparedStatement query = conn.prepareStatement(sql_Q);
    		ResultSet result = query.executeQuery();
    		System.err.println("Connection");
    		
    		while(result.next())
			{	
				String title = result.getString("title");
				System.out.println(title);
			}
		
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	


}
