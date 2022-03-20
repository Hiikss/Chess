package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon; 
   
public class Connect {  

	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String bdd = "chess";
	private String url = "jdbc:mysql://localhost:3306/" + bdd;  
	private String user = "root";
	private String mdp = "mdp123";
	
    public int connect(String username, String password) {

    	try{
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select username from user where binary username=?");  
        	stmt.setString(1, username);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()) {
        		stmt=con.prepareStatement("select * from user where password=MD5(?) and binary username=?");
        		stmt.setString(1, password);
        		stmt.setString(2, username);
        		rs=stmt.executeQuery();
        		if(rs.next()) {
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
    	URL imageURL = null;
		try {
			imageURL = Connect.class.getResource("/unknown.jpg").toURI().toURL();
		} catch (MalformedURLException | URISyntaxException e2) {
			e2.printStackTrace();
		}
    	File unknownImage = null;
		try {
			unknownImage = new File(URLDecoder.decode(imageURL.getFile(), "UTF-8"));
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
    	FileInputStream input = null;
		try {
			input = new FileInputStream(unknownImage);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select username from user where binary username=?");   
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
    	    PreparedStatement stmt=con.prepareStatement("select image from user where binary username=?");   
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
        	PreparedStatement stmt=con.prepareStatement("update user set image=? where binary username=?");   
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
    
    public List<String> getGameList(String player1, String player2) {  
    	
    	try{
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select id,date from game where (binary player1=? and binary player2=?) or (binary player1=? and binary player2=?)");  
        	stmt.setString(1, player1);
        	stmt.setString(2, player2);
        	stmt.setString(3, player2);
        	stmt.setString(4, player1);
        	ResultSet rs=stmt.executeQuery();
        	List<String> items = new ArrayList<String>();
        	while (rs.next()) {
        		items.add(rs.getString(1) + " - " + rs.getString(2));
        	}
        	con.close();
        	return items;
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return null;
    }	
    
    public String getGame(String id) {  
    	
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select chessboard from game where id=?");  
        	stmt.setString(1, id);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()) {
        		String board = rs.getString(1);
       			con.close();
       			return board;
        	}
        	else {
        		con.close();
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return null;
    }
    
    public int getGameSide(String player1, String player2) {
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("select * from game where binary player1=? and binary player2=?");  
        	stmt.setString(1, player2);
        	stmt.setString(2, player1);
        	ResultSet rs=stmt.executeQuery();  
        	if(rs.next()) {
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
    
    public String setGame(String id, String player1, String player2, String board) {
    	try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);
        	if(id!=null) {
        		PreparedStatement stmt=con.prepareStatement("update game set chessboard=?, date=CURRENT_TIMESTAMP where id=?;");
        		stmt.setString(1, board);
        		stmt.setString(2, id);
            	stmt.executeUpdate(); 
        		con.close();
        		return id;
        	}
        	else {
        		PreparedStatement stmt=con.prepareStatement("insert into game (player1, player2, chessboard) values (?, ?, ?);");     
        		stmt.setString(1, player1);
        		stmt.setString(2, player2);
        		stmt.setString(3, board);
        		stmt.executeUpdate();  
        		stmt=con.prepareStatement("select max(id) from game;");
        		stmt.executeQuery();
        		ResultSet rs=stmt.executeQuery();
        		if(rs.next()) {
        			id = rs.getString(1);
            		con.close();
           			return id;
            	}
        	}
    	}
        catch(Exception e) { 
    		System.out.println(e);
    	}
		return null;
    }

	public int deleteGame(String gameid) {
		try{  
    		Class.forName(driverName);
        	Connection con =DriverManager.getConnection(url, user, mdp);    
        	PreparedStatement stmt=con.prepareStatement("delete from game where id=?");   
        		stmt.setString(1, gameid);
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