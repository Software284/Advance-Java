package com.lamichhane.updatable.with.scroll.sensitive;

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
		System.out.println("Records In Forward Direction");
		while(rs.next()) {
			System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		System.out.println("Application is going to pause please update database");
		System.in.read();
		rs.beforeFirst();
		System.out.println("Records After Updation");
		while(rs.next()) {
			rs.refreshRow();
			System.out.println(rs.getRow()+"..."+rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		con.close();
		
//		Note:This features is only supported by type-1 driver and type-2 with update but not by type-4

	}

}
