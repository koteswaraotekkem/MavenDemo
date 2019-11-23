package com.db.coonectMsSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.freecrm.base.CrmTestBase;

public class ConnectToMsSQLTests {
	
	@Test
	public void connectTomsSql() throws Throwable{
		CrmTestBase vv= new CrmTestBase();
		
		String url = "jdbc:sqlserver://WINCTRL-L53BSHI;databaseName=userAccesDB;integratedSecurity=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conns = DriverManager.getConnection(url);
		
//		Connection conn = DriverManager.getConnection("jdbc:sqlserver://HOSP_SQL1.company.com;user=name;password=abcdefg;database=Test");
		System.out.println("test");
		Statement sta = conns.createStatement();
		String Sql = "select * from userAccesDB.dbo.Person;";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}

}
