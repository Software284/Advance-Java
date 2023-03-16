package com.lamichhane.retriving.records.with.jdbc.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSet {

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet rs = rsf.createJdbcRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		
		System.out.println("Records In Forward Direction");
		while(rs.next()) {
			System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		System.out.println("======================================================");
		System.out.println("Records In Backward Direction");
		while(rs.previous()) {
			System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		System.out.println("======================================================");
		System.out.println("Accessing Randomly");
		rs.first();
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.last();
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.relative(-1);
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.absolute(2);
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		

	}

}
