package test;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Piece;

class PieceTest {

	Piece piece = new Piece(null);
	
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
	
	@Test
	void testGetImage() {	//Fonction de test v�rifiant l'image attribu�e � la valeur de la piece
		Assertions.assertEquals(ipb, piece.getImage(1));
		Assertions.assertEquals(icb, piece.getImage(2));
		Assertions.assertEquals(ifb, piece.getImage(3));
		Assertions.assertEquals(itb, piece.getImage(5));
		Assertions.assertEquals(idb, piece.getImage(9));
		Assertions.assertEquals(irb, piece.getImage(10));
		Assertions.assertEquals(ipn, piece.getImage(-1));
		Assertions.assertEquals(icn, piece.getImage(-2));
		Assertions.assertEquals(ifn, piece.getImage(-3));
		Assertions.assertEquals(itn, piece.getImage(-5));
		Assertions.assertEquals(idn, piece.getImage(-9));
		Assertions.assertEquals(irn, piece.getImage(-10));
	}
	
}
