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
	private static String dburl = "jdbc:mysql://sandbox.kiiw.org:3306/gruppe2";
	
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
            Connection conn = DriverManager.getConnection(dburl,"gruppe2","gruppe2"); 

            String sql_Q ="SELECT * FROM news";
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
