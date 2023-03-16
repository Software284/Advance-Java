package com.lamichhane.inserting.records.with.jdbc.rowset;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class InsertWithRowSet {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet rs = rsf.createJdbcRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		
		try (Scanner sc = new Scanner(System.in)) {
			rs.moveToInsertRow();
			while(true) {
				System.out.println("Enter Id=");
				int userno = sc.nextInt();
				System.out.println("Enter Name=");
				String name = sc.nextLine();
				System.out.println("Enter Country=");
				String country = sc.nextLine();
				
				rs.updateInt(1,userno);
				rs.updateString(2,name);
				rs.updateString(3,country);
				rs.insertRow();
				
				System.out.println("User Record Inserted Successfully");
				System.out.println("Do you want to insert more records yes/no");
				String decision = sc.nextLine();
				if(decision.equalsIgnoreCase("No")) {
					break;
				}
			}
		}
		rs.close();

	}

}
