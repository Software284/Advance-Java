package com.lamichhane.list.of.user.between.id.function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class ListOfUserByProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{? = call getUserBetweenId(?,?)}");
		cst.setInt(2,1);
		cst.setInt(3,100);
		cst.registerOutParameter(1,OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs  = (ResultSet) cst.getObject(1);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
		
//		create or replace function getUserBetweenId(id1 IN number,id2 IN number) return SYS_REFCURSOR
//				as 
//				users SYS_REFCURSOR;
//				BEGIN
//				open users for 
//				select *  from anonymous where id >id1 and id <100;
//				return users;
//				END;
//				/
		
		

	}

}
