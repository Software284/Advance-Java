package com.lamichhane.aggregate.function.nested.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NestedQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  ResultSet rs = st.executeQuery("select * from anonymous where id in (select max(id) from anonymous)");
		  if(rs.next()) {
			  System.out.println("Id="+rs.getInt(1)+" Email="+rs.getString(2));
		  }

	}

}
