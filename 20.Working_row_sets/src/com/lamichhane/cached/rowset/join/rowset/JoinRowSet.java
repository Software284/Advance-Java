package com.lamichhane.cached.rowset.join.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JoinRowSet {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		RowSetFactory rsf = RowSetProvider.newFactory();
		
		javax.sql.rowset.CachedRowSet rs1 = rsf.createCachedRowSet();
		rs1.setCommand("select * from anonymous");
		rs1.execute(con);
		
		javax.sql.rowset.CachedRowSet rs2 = rsf.createCachedRowSet();
		rs2.setCommand("select * from anonymous2");
		rs2.execute(con);
		
		javax.sql.rowset.JoinRowSet rs = rsf.createJoinRowSet();
		rs.addRowSet(rs1,1);
		rs.addRowSet(rs2,1);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		

	}

}
