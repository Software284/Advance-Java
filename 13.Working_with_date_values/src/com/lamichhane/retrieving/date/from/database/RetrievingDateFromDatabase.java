package com.lamichhane.retrieving.date.from.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RetrievingDateFromDatabase {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("select * from info");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
//			System.out.println(rs.getString(1)+"..."+rs.getDate(2));
			System.out.println(rs.getString(1)+"..."+format.format(rs.getDate(2)));
		}

	}

}
