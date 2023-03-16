package com.lamichhane.insert.single.row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleRow {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		 // Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  int updateCount = st.executeUpdate("insert into anonymous(id,email,country) values(1,'mahesh@gmail.com','nepal')");
		  System.out.println("One row inserted successfully"+updateCount);
		  con.close();
	}

	
}
