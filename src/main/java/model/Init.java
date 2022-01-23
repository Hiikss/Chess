package model;

import javax.swing.JButton;

import controller.Controller;
import log4j2.Log4j;
import view.Display;
import view.Swing;

public class Init {

	private Log4j log = new Log4j();

	private Piece piece = new Piece();
	
	//Display swing = new Display(null);

	//Init init = new Init();
	
	//Controller controller = new Controller(init, swing);
	
	public int initBoard() {
		JButton bouton;
		Board board = new Board();
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
