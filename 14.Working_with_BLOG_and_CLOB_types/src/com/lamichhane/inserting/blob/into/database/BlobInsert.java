package com.lamichhane.inserting.blob.into.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("insert into person values(?,?)");
		File f = new File("Screenshot.png");
		FileInputStream fis = new FileInputStream(f);
		pst.setString(1,"screenshot");
		pst.setBinaryStream(2,fis);
		int result = pst.executeUpdate();
		if(result == 0) {
			System.out.println("Data Insert Not Successful");
		}
		else {
			System.out.println("Data Insert Successful");
		}
		

	}

}
