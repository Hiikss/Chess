package model;

import javax.swing.JButton;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Init {

	private final Logger logger =  LogManager.getLogger(this);

	private Piece piece = new Piece();
	
	private Model model;
	
	public Init(Model model) {
		this.model = model;
	}
	
	public int initBoard() {
		JButton bouton;
		model.createBoard();
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = model.getBoard(l,c) ;
				
				if(value!=0) {
					bouton = piece.getButton(value, l, c);
					model.addComponent(bouton);
				}
			}
		}
		model.updateView();
		logger.log(Level.INFO, "Échiquier initialisé");
		return 1;
	}
	
}
