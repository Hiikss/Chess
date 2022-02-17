package model;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
   
public class Connect {  
     /** 
     * Connect to a sample database 
     */  
    public int connect(String username, String password) {  

    	try{  
    		String driverName = "com.mysql.cj.jdbc.Driver";
    		 
    		Class.forName(driverName);
        	String bdd = "chess";
        	String url = "jdbc:mysql://localhost:3306/" + bdd;  
        	String user = "root";
        	String mdp = "mdp123";
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select username from user where username=?");  
        	stmt.setString(1, username);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()) {
        		stmt=con.prepareStatement("select * from user where password=MD5(?)");
        		stmt.setString(1, password);
        		rs=stmt.executeQuery();
        		if(rs.next()) {
        			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+ rs.getString(3)); 
        			con.close();
        			return 1;
        		}
        		else {
        			return 2;
        		}
        	}
        	else {
        		return 3;
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return 4;
    } 
    
    public int createAccount(String username, String password) {
    	try{  
    		String driverName = "com.mysql.cj.jdbc.Driver";
    		 
    		Class.forName(driverName);
        	String bdd = "chess";
        	String url = "jdbc:mysql://localhost:3306/" + bdd;  
        	String user = "root";
        	String mdp = "mdp123";
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select username from user where username=?");   
        	stmt.setString(1, username);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()==false) {
        		stmt=con.prepareStatement("insert into user (username, password) values (?, MD5(?));");
        		stmt.setString(1, username);
        		stmt.setString(2, password);
        		stmt.executeUpdate();
        		return 1;
        	}
        	else {
        		return 2;
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return 3;
    }
}  