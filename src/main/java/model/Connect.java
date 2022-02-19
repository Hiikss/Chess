package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon; 
   
public class Connect {  
	
	private File unknownImage = new File(Connect.class.getResource("/unknown.jpg").getFile());
	
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String bdd = "chess";
	private String url = "jdbc:mysql://localhost:3306/" + bdd;  
	private String user = "root";
	private String mdp = "mdp123";
	
    public int connect(String username, String password) {  

    	try{  
    		Class.forName(driverName);
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
        			con.close();
        			return 2;
        		}
        	}
        	else {
        		con.close();
        		return 3;
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return 4;
    }
    
    public int createAccount(String username, String password) {
    	FileInputStream input = null;
		try {
			input = new FileInputStream(unknownImage);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select username from user where username=?");   
        	stmt.setString(1, username);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()==false) {
        		stmt=con.prepareStatement("insert into user (username, password, image) values (?, MD5(?), ?);");
        		stmt.setString(1, username);
        		stmt.setString(2, password);
        		stmt.setBinaryStream(3,(InputStream)input,(int)unknownImage.length());
        		stmt.executeUpdate();
        		con.close();
        		return 1;
        	}
        	else {
        		con.close();
        		return 2;
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return 3;
    }
    
    public ImageIcon getImageAccount(String username) {
    	try{
    		Class.forName(driverName);
    	    Connection con = DriverManager.getConnection(url, user, mdp);
    	    PreparedStatement stmt=con.prepareStatement("select image from user where username=?");   
           	stmt.setString(1, username);
            ResultSet rs=stmt.executeQuery();
    	    byte[] i = null;
    	    	if(rs.next()) {
    	    		i = rs.getBytes(1);  
    	    		Image img = Toolkit.getDefaultToolkit().createImage(i);
    	    		ImageIcon image = new ImageIcon(img);
    	    		con.close();
    	    		return image;
    	        }
    	    	else {
    	    		con.close(); 
    	    	    return null;
    	       }
    	    }catch (Exception e){
    	      System.out.println(e.getMessage());
    	    }
    	return null;
    }
    
    public int setImageAccount(String username, File file) {
    	FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("update user set image=? where username=?");   
        	stmt.setBinaryStream(1,(InputStream)input,(int)file.length());
        	stmt.setString(2, username);
        	stmt.executeUpdate();  
        	con.close();
        	return 1;
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return 2;
    }
}