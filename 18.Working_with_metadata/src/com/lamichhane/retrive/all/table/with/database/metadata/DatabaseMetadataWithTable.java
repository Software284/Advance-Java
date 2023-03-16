package com.lamichhane.retrive.all.table.with.database.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataWithTable {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		java.sql.DatabaseMetaData dbmd = con.getMetaData();
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String[] types = null;
		ResultSet rs = dbmd.getTables(catalog,schemaPattern,tableNamePattern,types);
		int count = 0;
		while(rs.next()) {
			count++;
			System.out.println(rs.getString(3));
		}
		System.out.println("Number Table="+count);
		con.close();

	}

}
