package com.lamichhane.execute.select.nonselect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelect {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your query");
		String sqlQuery = sc.nextLine();
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		boolean bool = st.execute(sqlQuery);
		if(bool) {
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println("Id="+rs.getInt(1)+" Email="+rs.getString(2)+" Country="+rs.getString(3));
			}
		}
		else {
			int updateCount = st.getUpdateCount();
			System.out.println("The no of rows effected="+updateCount);
		}
		

	}

}
