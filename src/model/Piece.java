package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece {
	
	private static int btn = 0;
	
	public static int p = 0;
	
	public static ImageIcon ipb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"pb.png"));
	public static ImageIcon idb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"db.png"));
	public static ImageIcon irb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"rb.png"));
	public static ImageIcon ifb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"fb.png"));
	public static ImageIcon icb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"cb.png"));
	public static ImageIcon itb = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"tb.png"));
	
	public static ImageIcon ipn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"pn.png"));
	public static ImageIcon idn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"dn.png"));
	public static ImageIcon irn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"rn.png"));
	public static ImageIcon ifn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"fn.png"));
	public static ImageIcon icn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"cn.png"));
	public static ImageIcon itn = new ImageIcon(Piece.class.getResource(Main.RES_PATH+"tn.png"));
	
	public static JButton b24 = null;
	public static JButton b31 = null;
	public static JButton b0 = null;
	public static JButton b7 = null;
	public static JButton b4 = null;
	public static JButton b28 = null;
	
	/**
	 * Cette fonction permet d'attribuer une image de type ImageIcon à une valeur de type int
	 * <p>
	 */
	
	public static ImageIcon valueToPieceIcon(int valPiece)
	{
		ImageIcon piece = null;
		switch(valPiece){
		   
	       case 1: 
	           piece = ipb;
	           break;
	   
	       case 9:
	    	   piece = idb;
	           break;
	   
	       case 500:
	    	   piece = irb;
	           break;
	           
	       case 3: 
	    	   piece = ifb;
	           break;
	   
	       case 2:
	    	   piece = icb;
	           break;
	   
	       case 5:
	    	   piece = itb;
	           break;
	           
	       case -1: 
	           piece = ipn;
	           break;
	   
	       case -9:
	    	   piece = idn;
	           break;
	   
	       case -500:
	    	   piece = irn;
	           break;
	           
	       case -3: 
	    	   piece = ifn;
	           break;
	   
	       case -2:
	    	   piece = icn;
	           break;
	   
	       case -5:
	    	   piece = itn;
	           break;

	   }
		return piece;
	}
	
	
	public static JButton createPieceButton(){
		JButton piece = new JButton();
		
		piece.setName("b"+btn);
		if(btn==24) {
			b24=piece;
		}
		if(btn==31) {
			b31=piece;
		}
		if(btn==0) {
			b0=piece;
		}
		if(btn==7) {
			b7=piece;
		}
		if(btn==4) {
			b4=piece;
		}
		if(btn==28) {
			b28=piece;
		}
		if(btn<=15) {
			Game.piecesNoires.add(piece);
		}
		else {
			Game.piecesBlanches.add(piece);
		}
		btn++;
		return piece;
	}
	
	public static JButton getButtonTarget(int x, int y) {
		JButton button = null;
		if(Main.team.equals("white")) {
			for(int i=0;i<=15;i++) {
				if(Game.piecesNoires.get(i).getX()==x && Game.piecesNoires.get(i).getY()==y) {
					button = Game.piecesNoires.get(i);
				}
			}
		}
		else {
			for(int i=0;i<=15;i++) {
				if(Game.piecesBlanches.get(i).getX()==x && Game.piecesBlanches.get(i).getY()==y) {
					button = Game.piecesBlanches.get(i);
				}
			}
		}
		return button;
	}
	
}
