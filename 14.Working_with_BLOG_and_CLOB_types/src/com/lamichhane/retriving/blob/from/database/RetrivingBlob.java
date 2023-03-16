package com.lamichhane.retriving.blob.from.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrivingBlob {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba",
				"software");
		PreparedStatement pst = con.prepareStatement("select * from person");
		try (FileOutputStream fos = new FileOutputStream("hello.jpg")) {
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String name = rs.getString(1);
				System.out.println("Name=" + name);
				InputStream in = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				while (in.read(buffer) > 0) {
					fos.write(buffer);
				}
				fos.flush();
				System.out.println("Open hello.jpg file read the file");

			}
		}

	}

}
