package com.lamichhane.inserting.date.to.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertingDateIntoDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		java.util.Date utilDate = format.parse("20-04-1994");
		java.util.Date utilDate = format.parse("20/04/1994");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("insert into info values(?,?)");
		pst.setString(1,"Zero");
		pst.setDate(2,new java.sql.Date(utilDate.getTime()));
//		pst.setDate(2,new java.sql.Date(new java.util.Date().getTime()));
		int x = pst.executeUpdate();
		if(x == 1) {
			System.out.println("Insertion Successful");
		}

	}

}
