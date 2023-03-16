package com.lamichhane.dynamic.input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInput {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("Enter your country");
		String country = sc.next();
		System.out.println("Your Information Is Id="+id+" Email="+email+" Country="+country);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
//		String sqlQuery = "insert into anonymous values ("+id+",'"+email+"'"+",'"+country+"'"+")";
		String sqlQuery = String.format("insert into anonymous values (%d,'%s','%s')",id,email,country);
		st.executeUpdate(sqlQuery);
		System.out.println("Dynamic data inserted successfully");

	}

}
