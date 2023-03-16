package com.lamichhane.sum.of.id.with.function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public interface FunctionStoredProcedure {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{? = call getSumOfId(?,?)}");
		cst.setInt(2,100);
		cst.setInt(3,2);
		cst.registerOutParameter(1,OracleTypes.FLOAT);
		cst.execute();
		int sum = cst.getInt(1);
		System.out.println("Sum of id="+sum);
	}
	
//	create or replace function getSumOfId(id11 IN number,id22 IN number) return number
//			as 
//			id1 number;
//			id2 number;
//			BEGIN
//			select id into id1 from anonymous where id = id11;
//			select id into id2 from anonymous where id = id22;
//			return (id1+id2)/2;
//			END;
//			/
}
