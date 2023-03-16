package com.lamichhane.batch.updates.with.simple.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdatesWithSimpleStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		st.addBatch("insert into anonymous values(200,'halland@gmail.com','norway')");
		st.addBatch("update anonymous set email='goalmachine@gmail.com'");
		st.addBatch("insert into anonymous values(300,'mambappe@gmail.com','franche')");
		int[] result = st.executeBatch();
		for(int i: result) {
			System.out.println(i+ " ROWS UPDATED");
		}
	}

	
}
