package com.lamichhane.cached.rowset.retriving;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RetrivingCachedRowSet {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		javax.sql.rowset.CachedRowSet rs = rsf.createCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		System.out.println("Retriving in Forward Direction");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		System.out.println("Retriving in backward direction");
		while(rs.previous()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		

	}

}
