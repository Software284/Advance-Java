package com.lamichhane.navigating.records.with.scrollable.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NavigatingRecordsWithScrollable {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery("select * from anonymous");
		System.out.println("Records In Forward Direction");
		while(rs.next()) {
			System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		System.out.println("======================================================");
		rs.first();
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.last();
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.relative(-1);
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		rs.absolute(2);
		System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		con.close();
		
	}

}
