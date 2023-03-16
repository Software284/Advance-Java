package com.lamichhane.aggregate.function.nthid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NthId {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		  Scanner sc = new Scanner(System.in);
		  System.out.println("number=");
		  int num = sc.nextInt();
		
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		  Statement st = con.createStatement();
		  String query = "select * from (select id,email,country,rank() over(order by id desc) ranking from anonymous) where ranking="+num;
		  ResultSet rs = st.executeQuery(query);
		  while(rs.next()) {
			  System.out.println("Id="+rs.getInt(1)+" Email="+rs.getString(2));
		  }

	}

}
