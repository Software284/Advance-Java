package com.lamichhane.prepared.statement.sql.injection.attack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionAttack {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String user = sc.nextLine();
		System.out.println("Enter Password");
		String pass = sc.nextLine();
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select count(*) from users_info where username='"+user+"' and  password='"+pass+"'");
		int rowCount = 0;
		while(rs.next()) {
			rowCount = rs.getInt(1);
		}
		if(rowCount == 0) {
			System.out.println("Invalid Credential");
		}
		else {
			System.out.println("Valid Credential");
		}
	
		// username = mahesh'--
		// password = lami still return valid credential when exact data is username = mahesh and password = lamichhane
		// because -- indicates single line comment in sql

	}

}
