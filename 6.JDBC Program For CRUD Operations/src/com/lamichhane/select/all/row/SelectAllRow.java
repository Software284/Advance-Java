package com.lamichhane.select.all.row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRow {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  ResultSet rs = st.executeQuery("select * from anonymous where id=999");
//		  ResultSet rs = st.executeQuery("select * from anonymous order by country desc");
		  System.out.println("All Table Data");
		  boolean flag=false;
		  while(rs.next()) {
			  flag = true;
			  System.out.println("Id="+rs.getInt(1)+" Email="+rs.getString(2)+" Country="+rs.getString(3));
		  }
		  
		  if(!flag) {
		  System.out.println("No Records Found");
		  }

	}

}
