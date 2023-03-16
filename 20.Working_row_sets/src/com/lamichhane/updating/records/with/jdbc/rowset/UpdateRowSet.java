package com.lamichhane.updating.records.with.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class UpdateRowSet {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet rs = rsf.createJdbcRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		
		while(rs.next()) {
			String country = rs.getString(3);
			if(country.equals("norway")) {
				rs.updateString(3,"nepal");
				rs.updateRow();
			}
		}
		System.out.println("Records Inserted Successfully");
		rs.close();
		
		

	}

}
