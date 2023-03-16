package com.lamichhane.savepoint.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class SavepointExample {

	public static void main(String[] args) throws SQLException {
		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		st.executeUpdate("insert into anonymous values(300,'hello','world')");
		st.executeUpdate("insert into anonymous values(400,'wow','wow')");
		Savepoint point = con.setSavepoint();
		st.executeUpdate("insert into anonymous values(500,'zero','zero')");
		System.out.println("Oops wrong entry just rollback");
		con.rollback(point);
//		con.releaseSavepoint(point); this is not supported by type-4 driver
		System.out.println("All Operations are rollback from savepoint");
		con.commit();
		con.close();

	}

}
