package com.lamichhane.prepared.statement.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("insert into anonymous values(?,?,?)");
		pst.setInt(1,100);
		pst.setString(2,"superman@gmail.com");
		pst.setString(3,"mars");
		int x = pst.executeUpdate();
		System.out.println("No of row effected="+x);
		
	}

}
