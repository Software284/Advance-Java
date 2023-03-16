package com.lamichhane.parameter.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterMetaDataExample {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","software");
		PreparedStatement pst = con.prepareStatement("insert into anonymous values(?,?,?)");
		pst.setInt(1,34);
		pst.setString(2,"jljl");
		pst.setString(3,"lskjl");
		ParameterMetaData pmd = pst.getParameterMetaData();
		for(int i=1; i <= pmd.getParameterCount(); i++) {
			System.out.println("Parameter Count="+i);
			System.out.println("Parameter Mode="+pmd.getParameterMode(i));
			System.out.println("Parameter Type="+pmd.getParameterType(i));
			System.out.println("Parameter Type Name="+pmd.getParameterTypeName(i));
			System.out.println("Precision="+pmd.getPrecision(i));
			System.out.println("Scale="+pmd.getScale(i));
			System.out.println("Nullable="+pmd.isNullable(i));
			System.out.println("IsSigned="+pmd.isSigned(i));
			System.out.println("===============================================");
		}
	}

}
