package com.lamichhane.resultset.metadata;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataExample {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from anonymous");
		ResultSetMetaData rsmd = rs.getMetaData();
		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println("Column Number="+i);
			System.out.println("Column Name="+rsmd.getColumnName(i));
			System.out.println("Column Type="+rsmd.getColumnType(i));
			System.out.println("Column Size="+rsmd.getColumnDisplaySize(i));
			System.out.println("------------------------------------");
		}
		
	}

}
