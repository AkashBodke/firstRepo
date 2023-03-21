package com.velocity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
	public static void main(String[] args) throws SQLException {
		try {
		String sql="insert into mcq_question (QUESTION_NO,QUESTION,OPTION1,OPTION2,OPTION3,OPTION4,Corr_Option) values(1,'Who invented Java Programming?', 'a. Guido van Rossum', 'b. James Gosling', 'c. Dennis Ritchie', 'd. none', 'b'),(2,'Who invented Java Programming?', 'a. Guido van Rossum', 'b. James Gosling', 'c. Dennis Ritchie', 'd. none', 'b'),(3,'Which component is used to compile debug and execute the java programs?','a. JRE','b. JIT', 'c. JDK','d. JVM','c'),(4,'Which one of the following is not a Java feature?','a. Object-oriented','b. Use of pointers','c. Portable','d. Dynamic and Extensible','b'),(5,'Which of these cannot be used for a variable name in Java?','a. identifier & keyword','b. identifier','c. keyword','d. none of the mentioned','c'),(6,'What is the extension of java code files?','a. .js','b. .txt','c. .class','d. .java','d'),(7,'Which environment variable is used to set the java path?','a. MAVEN_Path','b. JavaPATH','c. JavaPATH','d. JAVA_HOME','d'),(8,'Which of the following is not an OOPS concept in Java?','a. Polymorphism','b. Inheritance','c. Compilation','d. Encapsulation','c')";
			
			
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Akash@123");
				
				Statement statement1 = con.createStatement();
				
				
				statement1.execute(sql);
				
			
				
				System.out.println("Insertion success");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
				

	}

}
