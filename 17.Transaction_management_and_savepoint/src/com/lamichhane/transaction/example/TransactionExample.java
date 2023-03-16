package com.lamichhane.transaction.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionExample {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		Statement st = con.createStatement();
		System.out.println("Transaction Begins");
		con.setAutoCommit(false);
		st.executeUpdate("update account set balance = balance+1000 where name='mahesh'");
		st.executeUpdate("update account set balance = balance-1000 where name ='nabin'");
		Scanner sc = new Scanner(System.in);
		System.out.println("Can you please confirm this transaction of 1000 yes/no");
		String option = sc.next();
		if(option.equalsIgnoreCase("yes")) {
			con.commit();
			System.out.println("transaction committed");
		}
		else {
			con.rollback();
			System.out.println("transaction failed");
		}
		
	}

}
