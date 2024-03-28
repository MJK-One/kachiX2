package com.kachi.five;

import java.sql.DriverManager;

import org.junit.Test;

import com.sun.jdi.connect.spi.Connection;

public class DB_con_chk {
	@Test
	public void test() throws Exception {
	    
	     Class.forName("com.mysql.cj.jdbc.Driver"); 

	   
	    java.sql.Connection con = DriverManager.getConnection("","",""); 
	    System.out.println(con);
	    }
}
