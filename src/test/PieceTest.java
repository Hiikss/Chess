package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Piece;

class PieceTest {

	Piece c = new Piece();
	
	@Test
	void testValueToPieceIcon() {	//Fonction de test vérifiant l'image attribuée à la valeur de la piece
		Assertions.assertEquals(Piece.ipb, Piece.valueToPieceIcon(1));
		Assertions.assertEquals(Piece.icb, Piece.valueToPieceIcon(2));
		Assertions.assertEquals(Piece.ifb, Piece.valueToPieceIcon(3));
		Assertions.assertEquals(Piece.itb, Piece.valueToPieceIcon(5));
		Assertions.assertEquals(Piece.idb, Piece.valueToPieceIcon(9));
		Assertions.assertEquals(Piece.irb, Piece.valueToPieceIcon(500));
		Assertions.assertEquals(Piece.ipn, Piece.valueToPieceIcon(-1));
		Assertions.assertEquals(Piece.icn, Piece.valueToPieceIcon(-2));
		Assertions.assertEquals(Piece.ifn, Piece.valueToPieceIcon(-3));
		Assertions.assertEquals(Piece.itn, Piece.valueToPieceIcon(-5));
		Assertions.assertEquals(Piece.idn, Piece.valueToPieceIcon(-9));
		Assertions.assertEquals(Piece.irn, Piece.valueToPieceIcon(-500));
	}

}
