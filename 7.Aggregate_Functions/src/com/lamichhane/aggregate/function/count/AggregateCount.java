package com.lamichhane.aggregate.function.count;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AggregateCount {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  ResultSet rs = st.executeQuery("select min(id) from anonymous");
		  if(rs.next()) {
			  System.out.println("Min row="+rs.getInt(1));
		  }

	}

}
