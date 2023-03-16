package com.lamichhane.cached.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSet {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from anonymous");
		RowSetFactory rsf = RowSetProvider.newFactory();
		javax.sql.rowset.CachedRowSet crs = rsf.createCachedRowSet();
		crs.populate(rs);
		con.close();
		//after this line rs won't be accessible while crs can be access
		while(crs.next()) {
			System.out.println(crs.getInt(1)+"..."+crs.getString(2)+"..."+crs.getString(3));
		}
		

	}

}
