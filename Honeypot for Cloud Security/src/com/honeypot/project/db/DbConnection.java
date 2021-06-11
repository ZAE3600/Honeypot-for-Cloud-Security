package com.honeypot.project.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public Connection getConnection(){
		Connection con=null;
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/honeypot";
            con=DriverManager.getConnection(url,"root","root");
            System.out.println("Data base---->"+con);
        }catch(Exception e)
         {
             e.printStackTrace();
         }
        return con;
    }
}