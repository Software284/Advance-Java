package com.lamichhane.delete.multiple.row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteMultipleRow {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  st.executeUpdate("delete from anonymous where id>3");
		  System.out.println("Table data deleted successfully");

	}

}
