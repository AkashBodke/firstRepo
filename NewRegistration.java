package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewRegistration {
public static void insertRecords(int id, String firstname,String lastname,String username,String password,String city,String emailid) {

	
		
		try {
			Connection connection = CommonConnection.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("insert into registration(id,firstname,lastname,username,password,city,emailid)values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setString(6, city);
			ps.setString(7, emailid);
			
			ps.execute();
			System.out.println("Records inserted successfully...");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID");
		int id = sc.nextInt();

		
		System.out.println("Enter the FirstName");
		String firstname = sc.next();

		System.out.println("Enter the LastName");
		String lastname = sc.next();
		
		System.out.println("Enter the UserName");
		String username = sc.next();
		
		System.out.println("Enter the Password");
		String password = sc.next();
		
		System.out.println("Enter the City");
		String city = sc.next();
		
		System.out.println("Enter the EmailId");
		String emailid = sc.next();
		
		

		
		insertRecords(id,firstname,lastname,username,password,city,emailid);
		
		}
	

}


