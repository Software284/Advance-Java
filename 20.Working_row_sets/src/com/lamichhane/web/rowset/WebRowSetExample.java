package com.lamichhane.web.rowset;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetExample {

	public static void main(String[] args) throws SQLException, IOException {
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		WebRowSet rs = rsf.createWebRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rs.setUsername("sys as sysdba");
		rs.setPassword("software");
		rs.setCommand("select * from anonymous");
		rs.execute();
		FileWriter fw = new FileWriter("emp.xml");
		rs.writeXml(fw);
		System.out.println("Data written to emp.xml file");
		rs.close();
	}

}
