package com.lamichhane.util.date.vs.sql.date;

public class UtilVsSqlDate {

	public static void main(String[] args) {
		
		java.util.Date uDate = new java.util.Date();
		System.out.println("UDate ="+uDate);
		long l = uDate.getTime();
		java.sql.Date sDate = new java.sql.Date(l);
		System.out.println("SqlDate="+sDate);

	}

}
