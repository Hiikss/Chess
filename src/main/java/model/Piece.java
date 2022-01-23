package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import log4j2.Log4j;

public class Piece {
	
	public static ImageIcon ipb = new ImageIcon(Piece.class.getResource("/pb.png"));
	public static ImageIcon idb = new ImageIcon(Piece.class.getResource("/db.png"));
	public static ImageIcon irb = new ImageIcon(Piece.class.getResource("/rb.png"));
	public static ImageIcon ifb = new ImageIcon(Piece.class.getResource("/fb.png"));
	public static ImageIcon icb = new ImageIcon(Piece.class.getResource("/cb.png"));
	public static ImageIcon itb = new ImageIcon(Piece.class.getResource("/tb.png"));
	
	public static ImageIcon ipn = new ImageIcon(Piece.class.getResource("/pn.png"));
	public static ImageIcon idn = new ImageIcon(Piece.class.getResource("/dn.png"));
	public static ImageIcon irn = new ImageIcon(Piece.class.getResource("/rn.png"));
	public static ImageIcon ifn = new ImageIcon(Piece.class.getResource("/fn.png"));
	public static ImageIcon icn = new ImageIcon(Piece.class.getResource("/cn.png"));
	public static ImageIcon itn = new ImageIcon(Piece.class.getResource("/tn.png"));
	
	private ImageIcon icon = new ImageIcon();
	
	private JButton piece = new JButton();

	private int btn = 0;
	
	private Log4j log = new Log4j();
	
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
		log.logInfo("pièce retournée "+btn);
		return piece;
	}
}
