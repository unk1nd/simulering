
	/**
	 * 		Systemutvikling 2013
	 * 		Gruppe 2
	 * 		simuleringscore for str¿m
	 */


package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame 
{

	public static void main(String[] args) 
	{
		GUI frameTabel = new GUI();
	}

	JLabel welcome = new JLabel("Welcome to a New Frame");
	JPanel panel = new JPanel();

	GUI()
	{
		super("Welcome");
		setSize(800,500);
		setLocation(500,280);
		panel.setLayout (null); 

		welcome.setBounds(70,50,150,60);

		panel.add(welcome);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		DBConnection test = new DBConnection();
		test.getSomething();
	}

}
