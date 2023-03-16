package com.lamichhane.add.two.num.store.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class AddTwoNumberStoredProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{call addProc(?,?,?)}");
		cst.setInt(1,100);
		cst.setInt(2,200);
		cst.registerOutParameter(3,Types.INTEGER);
		cst.execute();
		int result = cst.getInt(3);
		System.out.println("Result="+result);
	}
	
//	create or replace procedure addProc(X IN number,Y IN number,Z OUT number) as 
//	BEGIN
//	z:=x+y;
//	END;
//	/

}
