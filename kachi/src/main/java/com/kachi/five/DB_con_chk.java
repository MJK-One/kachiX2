package com.kachi.five;

import java.sql.DriverManager;

import org.junit.Test;

import com.sun.jdi.connect.spi.Connection;

public class DB_con_chk {
	@Test
	public void test() throws Exception {
	    
	     Class.forName("com.mysql.cj.jdbc.Driver"); 

	   
	    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://gatchix2.cxfabflfb25n.ap-northeast-2.rds.amazonaws.com:3306/gatchix2","root","whfwkr123"); 
	    System.out.println(con);
	    }
}
