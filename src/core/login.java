package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends JFrame 
{

	private static String dburl = "jdbc:mysql://jenna.bendiksens.net:3306/bob";
	String dbpassword = null;
	String dbusername = null;
	
	
	public static void main(String[] args) 
	{
		login frameTabel = new login();
	}

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);

	login()
	{
		super("Login Autentification");
		setSize(300,200);
		setLocation(300,280);
		panel.setLayout (null); 

		txuser.setBounds(70,30,150,20);
		pass.setBounds(70,65,150,20);
		blogin.setBounds(110,100,80,20);

		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	public void actionlogin(){
		blogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
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
						String puname = txuser.getText();
						String ppaswd = pass.getText();
						
			            Connection conn = DriverManager.getConnection(dburl,"bob","bob123"); 

			            String sql_Q ="SELECT * FROM brukere WHERE brukernavn='" + puname + "'";
			            // create the java statement
			            Statement st = conn.createStatement();
			            
			            // execute the query, and get a java resultset
			            ResultSet rs = st.executeQuery(sql_Q);
			    		System.out.println("Connection");
			    		
			    		if(rs.next())
			    		{
			    			dbpassword = rs.getString("passord");
			    			dbusername = rs.getString("brukernavn");
			    			System.err.println("Databasen sier at brukernavnet er: " + dbusername);
							System.err.println("Databasen sier at passordet er: " + dbpassword);
							System.err.println("Bruker sier at brukernavnet er: " + puname);
							System.err.println("Bruker sier at passordet er: " + ppaswd);
			    		}
			    		
			    		
			    		if(puname.equals(dbusername) && ppaswd.equals(dbpassword)) 
						{
							GUI regFace = new GUI();
							regFace.setVisible(true);
							dispose();
						} 
						else 
						{
							JOptionPane.showMessageDialog(null,"Feil Passord / Brukernavn");
							txuser.setText("");
							pass.setText("");
							txuser.requestFocus();
							System.out.println("Feil brukernavn og passord innskrevet.");
						}
					}
					
					catch (SQLException e)
					{
						System.out.println(e);
					}
			}
		}
		);
	}
}
