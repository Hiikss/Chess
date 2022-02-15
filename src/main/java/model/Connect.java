package model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
   
public class Connect {  
     /** 
     * Connect to a sample database 
     */  
    public static void connect() {  
    	try{  
    		String driverName = "com.mysql.cj.jdbc.Driver";
    		 
    		  Class.forName(driverName);
        	String bdd = "chess";
        	String url = "jdbc:mysql://localhost:3306/" + bdd;  
        	String user = "root";
        	String mdp = "mdp123";
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	Statement stmt=con.createStatement();  
        	//stmt.executeUpdate("insert into user (username, password) values ('Hiiks', MD5('mdp123'));");  
        	ResultSet rs=stmt.executeQuery("select * from user");  
        	while(rs.next())
        	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+ rs.getString(3)); 
        	con.close();  
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
    }  
}  