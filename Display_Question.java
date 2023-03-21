package com.velocity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Display_Question {


	public static void main(String[] args) {
		

	      Connection conn = null;
	      PreparedStatement ps = null;
	      ResultSet rst = null;
	      ResultSet rst1=null;
	      String sql = "select* from mcq_question";
	      
	      try {
	    	  int m=0;
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Akash@123");
	         ps = conn.prepareStatement(sql);
	         rst = ps.executeQuery();
	         while(rst.next()) {
	        	 int i= rst.getInt(1); 
	        	 String question= rst.getString(2);
	        	 String opt1=rst.getString(3);
	        	 String opt2= rst.getString(4);
	        	 String opt3= rst.getString(5);
	        	 String opt4=rst.getString(6);
	        	 String correct = rst.getString(7);
	         ArrayList<Object> arraylist = new ArrayList<>();
	         ArrayList<Object> arraylist1 = new ArrayList<>();
	         arraylist1.add(correct);
	         arraylist.add("Question No. :" +i +"\n" +question +"\n" +opt1 +"\n" +opt2 +"\n" +opt3 +"\n" +opt4); 
	         Iterator<Object> itr=arraylist.iterator();
	         Iterator<Object> itr1= arraylist1.iterator();
	         	while(itr1.hasNext()) {
	        	Object obj=itr1.next();
					while(itr.hasNext()) {
					System.out.println(itr.next());
					System.out.println("Enter your Option ");
					Scanner sc= new Scanner(System.in);
					String input=sc.nextLine();
					System.out.println(" ");
					Object obj1=input;
					
					if(obj.equals(obj1)) {
							m++;
				         }
					 }
	           
	              }
	         
	         }
	       
	     	// Storing marks into database with ID 
	         
	         String sql1="insert into result(marks,id) values( "+m+",'101') ;";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Akash@123");
			
			Statement statement1 = con.createStatement();
			
			
			statement1.execute(sql1);
			System.out.println("Result updated successfully");
			
			System.out.println();
			
			// Fetching result from database
			
			 String sql3="select  firstname as Firstname,lastname as Lastname,marks as Marks from registration right join result on registration.id=result.id ";
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Akash@123");
				
				Statement statement2 = con1.createStatement();
				rst1=statement2.executeQuery(sql3);
				while(rst1.next()) {
					
				System.out.println("Your Name is : " +rst1.getString(1) +" "+ rst1.getString(2) );
				
				System.out.println("Your Score out of 8 is : " +rst1.getString(3));
				
				}   
	         
	      }
	      
	      catch(Exception e) {
	          e.printStackTrace();
	      					}
	      
	}

}