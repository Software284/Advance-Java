package com.lamichhane.get.user.by.id.stored.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class UserByIdStoredProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{call UserById(?,?)}");
		cst.setInt(1,100);
		cst.registerOutParameter(2,Types.VARCHAR);
		cst.execute();
		String email = cst.getString(2);
		System.out.println("Email="+email);

	}
	
//	create or replace procedure UserById(X IN number,Z OUT varchar2) as 
//	BEGIN
//	  select email into Z from anonymous where id=X;
//	END;
//	/

}
