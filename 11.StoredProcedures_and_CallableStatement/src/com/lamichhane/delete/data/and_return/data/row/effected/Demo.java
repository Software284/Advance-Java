package com.lamichhane.delete.data.and_return.data.row.effected;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		CallableStatement cst = con.prepareCall("{? = call deleteById(?,?)}");
		cst.setInt(2,2);
		cst.registerOutParameter(1,OracleTypes.CURSOR);
		cst.registerOutParameter(3,Types.INTEGER);
		cst.execute();
		ResultSet rs  = (ResultSet) cst.getObject(1);
		System.out.println("No of rows effected="+cst.getInt(3));
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3));
		}
	}
	
//	create or replace function deleteById(id1 IN number,id3 OUT number) return SYS_REFCURSOR
//			as 
//			users SYS_REFCURSOR;
//			BEGIN
//			open users for 
//			select *  from anonymous where id = id1;
//			delete from anonymous where id = id1;
//			id3:= SQL %ROWCOUNT;
//			return users;
//			END;
//			/

}
