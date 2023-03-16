package com.lamichhane.web.rowset.insertion.deletion;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetExample {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		con.setAutoCommit(false);
		RowSetFactory rsf = RowSetProvider.newFactory();
		WebRowSet rs = rsf.createWebRowSet();
		rs.setCommand("select * from anonymous");
		rs.execute();
		FileReader fr = new FileReader("emp.xml");
		rs.readXml(fr);
		rs.acceptChanges();
		System.out.println("emp data deleted successfully");
		fr.close();
		rs.close();
	}

}
