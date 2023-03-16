package com.lamichhane.inserting.clob.into.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("insert into animal values(?,?)");
		File f = new File("Screenshot.txt");
		FileReader fis = new FileReader(f);
		pst.setString(1,"screen");
		pst.setCharacterStream(2,fis);
		int result = pst.executeUpdate();
		if(result == 0) {
			System.out.println("Data Insert Not Successful");
		}
		else {
			System.out.println("Data Insert Successful");
		}

	}

}
