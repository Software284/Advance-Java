package com.lamichhane.updatable.resultset;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from anonymous");
		rs.last();
		rs.deleteRow();
		System.out.println("Last Record delete successfully");
		con.close();
		
//		Note:This features is only supported by type-1 driver and type-2 with update but not by type-4
//same for update and delete operation
	}

}
