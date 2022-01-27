package model;

import javax.swing.JButton;
import javax.swing.JPanel;

import log4j2.Log4j;

public class Init {

	private Log4j log = new Log4j();

	private Piece piece = new Piece();
	
	private JPanel panel;
	
	//Display swing = new Display(null);
	
	public int initBoard() {
		JButton bouton;
		Board board = new Board();
		log.logInfo(""+panel);
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = board.getBoard(l,c) ;
				
				if(value!=0) {
					bouton = piece.getButton(value);
				}
			}
		}
		log.logInfo("Échiquier initialisé");
		return 1;
	}
	
}
