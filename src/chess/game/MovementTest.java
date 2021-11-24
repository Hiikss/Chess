package chess.game;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import chess.Main;

class MovementTest {

	Movement c = new Movement();
	Main d = new Main();
	
	@Test
	void testDeplacementLigne() {
		Assertions.assertTrue(Main.board[3][3], c.deplacementLigne(5, 0, 0, 0, 0, null));
	}
	
	/*
	void testDeplacementDiag() {
		Assertions.assertSame(1, c.deplacementDiag(3, 0, 0, 0, 0, null));
	}
	
	void testDeplacementCavalier() {
		Assertions.assertSame(1, c.deplacementCavalier(3, 0, 0, 0, 0, null));
	}
	
	void testDeplacementRoi() {
		Assertions.assertSame(1, c.deplacementRoi(3, 0, 0, 0, 0, null));
	}
	*/
	
}