package com.lamichhane.database.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaData {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		java.sql.DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("Database Product Name:"+dbmd.getDatabaseProductName());
		System.out.println("Database Product Version:"+dbmd.getDatabaseProductVersion());
		System.out.println("Database Major Version:"+dbmd.getDatabaseMajorVersion());
		System.out.println("Database Minor Version::"+dbmd.getDatabaseMinorVersion());
		System.out.println("JDBC Major Version:"+dbmd.getJDBCMajorVersion());
		System.out.println("JDBC Minor Version:"+dbmd.getJDBCMinorVersion());
		System.out.println("Driver Name:"+dbmd.getDriverName());
		System.out.println("URL:"+dbmd.getURL());
		System.out.println("Username:"+dbmd.getUserName());
		System.out.println("Max Columns In Table:"+dbmd.getMaxColumnsInTable());
		System.out.println("Max Row Size:"+dbmd.getMaxRowSize());
		System.out.println("Max Statement Length:"+dbmd.getMaxStatementLength());
		System.out.println("Max Tables In Select:"+dbmd.getMaxTablesInSelect());
		System.out.println("Max Table Name Length:"+dbmd.getMaxTableNameLength());
		System.out.println("SQL Keywords:"+dbmd.getSQLKeywords());
		System.out.println("Numeric Functions:"+dbmd.getNumericFunctions());
		System.out.println("String Functions:"+dbmd.getStringFunctions());
		System.out.println("System Functions:"+dbmd.getSystemFunctions());
		System.out.println("Supports Full Outer Joins:"+dbmd.supportsFullOuterJoins());
		System.out.println("Supports Stored Procedures:"+dbmd.supportsStoredProcedures());
		con.close();
		

	}

}
