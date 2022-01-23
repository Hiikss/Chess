package model;

import javax.swing.JButton;

import log4j2.Log4j;

public class Init {

	Log4j log = new Log4j();
	
	Piece piece = new Piece();
	
	public int initBoard() {
		JButton bouton;
		Board board = new Board();
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = board.getBoard(l,c) ;
				
				if(value!=0) {
					bouton = piece.getButton();
				}
			}
		}
		log.logInfo("Échiquier initialisé");
		return 1;
	}
	
}
