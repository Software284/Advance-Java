package com.lamichhane.batch.updates.with.simple.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdatesWithPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement st = con.prepareStatement("insert into anonymous values(?,?,?)");
		while(true) {
			System.out.println("Enter Id");
			int x = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Email");
			String email = sc.nextLine();
			System.out.println("Enter Country");
			String country = sc.nextLine();
			
			st.setInt(1,x);
			st.setString(2,email);
			st.setString(3,country);
			
			st.addBatch();
			
			
			System.out.println("Enter do you want to continue yes/no");
			String decision = sc.nextLine();
			if(decision.equals("no")) {
				break;
			}
		}
		st.executeBatch();
		System.out.println("Records Inserted Successfully");
	}

	
}
