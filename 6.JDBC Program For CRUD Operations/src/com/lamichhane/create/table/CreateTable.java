package com.lamichhane.create.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
	  Statement st = con.createStatement();
	  st.executeUpdate("create table anonymous(id number(10),email varchar2(100),country varchar2(100))");
	  System.out.println("Table created successfully");

	}

}
