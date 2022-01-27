package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Piece {
	
	private ImageIcon ipb = new ImageIcon(Piece.class.getResource("/pb.png"));
	private ImageIcon idb = new ImageIcon(Piece.class.getResource("/db.png"));
	private ImageIcon irb = new ImageIcon(Piece.class.getResource("/rb.png"));
	private ImageIcon ifb = new ImageIcon(Piece.class.getResource("/fb.png"));
	private ImageIcon icb = new ImageIcon(Piece.class.getResource("/cb.png"));
	private ImageIcon itb = new ImageIcon(Piece.class.getResource("/tb.png"));
	
	private ImageIcon ipn = new ImageIcon(Piece.class.getResource("/pn.png"));
	private ImageIcon idn = new ImageIcon(Piece.class.getResource("/dn.png"));
	private ImageIcon irn = new ImageIcon(Piece.class.getResource("/rn.png"));
	private ImageIcon ifn = new ImageIcon(Piece.class.getResource("/fn.png"));
	private ImageIcon icn = new ImageIcon(Piece.class.getResource("/cn.png"));
	private ImageIcon itn = new ImageIcon(Piece.class.getResource("/tn.png"));
	
	private ImageIcon icon = new ImageIcon();
	
	private JButton piece = new JButton();

	private int btn = 0;
	
	private final Logger logger =  LogManager.getLogger(this);	
	
	public ImageIcon getImage(int valPiece) {
		switch(valPiece){
		   
	       case 1: 
	    	   setImage(ipb);
	           break;
	   
	       case 9:
	    	   setImage(idb);
	           break;
	   
	       case 10:
	    	   setImage(irb);
	           break;
	           
	       case 3: 
	    	   setImage(ifb);
	           break;
	   
	       case 2:
	    	   setImage(icb);
	           break;
	   
	       case 5:
	    	   setImage(itb);
	           break;
	           
	       case -1:
	    	   setImage(ipn);
	           break;
	   
	       case -9:
	    	   setImage(idn);
	           break;
	  
	       case -10:
	    	   setImage(irn);
	           break;
	           
	       case -3: 
	    	   setImage(ifn);
	           break;
	   
	       case -2:
	    	   setImage(icn);
	           break;
	   
	       case -5:
	    	   setImage(itn);
	           break;

	   }
		return icon;
	}
	
	public void setImage(ImageIcon icon)
	{
		this.icon = icon;
	}
	
	public JButton getButton(int value) {
		piece.setName("b"+btn);
		/*if(btn<=15) {
			piecesNoires.add(piece);
		}
		else {
			piecesBlanches.add(piece);
		}*/
		btn++;
		piece.setLayout(null);
		piece.setIcon(getImage(value));
		piece.setContentAreaFilled(false);
		piece.setBorderPainted(false);
		logger.log(Level.INFO, "pièce retournée "+btn);
		return piece;
	}
}
