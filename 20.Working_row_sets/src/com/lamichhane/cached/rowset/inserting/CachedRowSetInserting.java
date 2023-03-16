package com.lamichhane.cached.rowset.inserting;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetInserting {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		javax.sql.rowset.CachedRowSet rs = rsf.createCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter id");
			int id = sc.nextInt();
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter country");
			String country = sc.next();
			
			rs.moveToInsertRow();
			rs.updateInt(1,id);
			rs.updateString(2,email);
			rs.updateString(3,country);
			rs.insertRow();
			
			System.out.println("Records Inserted Successfully");
			System.out.println("Do you want to insert more records yes/no");
			String decision = sc.next();
			if(decision.equalsIgnoreCase("No")) {
				break;
			}
			
		}
		rs.moveToCurrentRow();
		rs.acceptChanges();
		rs.close();
		
		//same for deleting and updating cached row set like in jdbc rowset
	
		

	}

}
