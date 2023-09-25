package com.kachi.five;

import java.sql.DriverManager;

import org.junit.Test;

import com.sun.jdi.connect.spi.Connection;

public class DB_con_chk {
	@Test
	public void test() throws Exception {
	    
	     Class.forName("com.mysql.cj.jdbc.Driver"); 

	   
	    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gatchix2","root","1921"); 
	    System.out.println(con);
	    }
}
