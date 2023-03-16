package com.lamichhane.row.id.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

public class RowIdExample {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select rowid,id,email,country from anonymous");
		while(rs.next()) {
			RowId id = rs.getRowId(1);
			byte[] b = id.getBytes();
			String rowId = new String(b);
			System.out.println(rowId+"..."+rs.getInt(2)+"..."+rs.getString(3)+"..."+rs.getString(4));
		}
		con.close();
	}
	

}
