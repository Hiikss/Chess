package model;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Piece</b> appartient au package <b>model</b>.
 * @author Thomas
 */
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

	private int btn = 0;
	
	private Model model;
	
	private final Logger logger =  LogManager.getLogger(this);
	
	/**
	 * La méthode Piece est la méthode principale de la classe Piece.
	 * Elle attribut la classe Model à la variable model
	 * @param model classe Model
	 */
	public Piece(Model model) {
		this.model = model;
	}
	
	/**
	 * La méthode getImage attribut une image de pièce en fonction de la valeur de la pièce.
	 * @param valPiece valeur de la pièce
	 * @return l'image de la pièce
	 */
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
	
	/**
	 * La méthode setImage permet de mettre l'image de paramètre dans la variable icon
	 * @param icon image à attribuer à la variable icon
	 */
	public void setImage(ImageIcon icon)
	{
		this.icon = icon;
	}
	
	/**
	 * La méthode getButton créer un nouveau bouton en lui attribuant une icon en fonction de sa valeur dans le tableau
	 * @param value valeur de la pièce
	 * @param l ligne du tableau multidimentionnel
	 * @param c colonne du tableau multidimentionnel
	 * @return un bouton qui correspond à la pièce
	 */
	public JButton getButton(int value, int l, int c) {
		JButton piece = new JButton();
		piece.setName("b"+btn);
		/*if(btn<=15) {
			piecesNoires.add(piece);
		}
		else {
			piecesBlanches.add(piece);
		}*/
		btn++;
		piece.setBounds(model.getX()+75*c, model.getY()+75*l, 75, 75);
		piece.setLayout(null);
		piece.setIcon(getImage(value));
		piece.setContentAreaFilled(false);
		piece.setBorderPainted(false);
		logger.log(Level.INFO, "pièce retournée "+btn);
		return piece;
	}
}
