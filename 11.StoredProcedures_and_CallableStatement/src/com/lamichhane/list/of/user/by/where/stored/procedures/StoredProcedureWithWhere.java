package com.lamichhane.list.of.user.by.where.stored.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class StoredProcedureWithWhere {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{call getAllUsersById(?,?)}");
		cst.setInt(1,100);
		cst.registerOutParameter(2,OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs  = (ResultSet) cst.getObject(2);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
	}
	
//	create or replace procedure getAllUsersById(X IN number,users OUT SYS_REFCURSOR) as 
//	BEGIN
//	open users for select * from anonymous where id=X;
//	END;
//	/

}
