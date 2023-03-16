package com.lamichhane.prepared.statement.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDelete {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("delete from anonymous where id=?");
		pst.setInt(1,1);
		int x = pst.executeUpdate();
		System.out.println("No of row effected="+x);

	}

}
