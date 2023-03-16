package com.lamichhane.retriving.clob.from.database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetriveClob {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba",
				"software");
		PreparedStatement pst = con.prepareStatement("select * from animal");
		try (FileWriter fw = new FileWriter("hello.txt")) {
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String name = rs.getString(1);
				System.out.println("Name=" + name);
				Reader r = rs.getCharacterStream(2);
				char[] buffer = new char[1024];
				while (r.read(buffer) > 0) {
					fw.write(buffer);
				}
				fw.flush();
				System.out.println("Open hello.txt file read the file");

			}
		}
	}
}
