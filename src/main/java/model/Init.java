package model;

import javax.swing.JButton;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Init</b> appartient au package <b>model</b>
 * @author Thomas
 */
public class Init {

	private final Logger logger =  LogManager.getLogger(this);
	
	private Model model;
	
	/**
	 * La méthode Init est la méthode principale de la classe Init. 
	 * Elle attribut la classe Model à la variable model
	 * @param model classe Model
	 */
	public Init(Model model) {
		this.model = model;
	}
	
	/**
	 * La méthode initBoard initialise l'échiquier en ajoutant chaque pièce par rapport au fichier chessboard.txt 
	 * @return 1 si la méthode a bien été exécutée
	 */
	public int initBoard() {
		JButton bouton;
		model.createBoard();
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = model.getIntInBoard(l,c) ;
				
				if(value!=0) {
					bouton = model.getButton(value, l, c);
					model.addComponent(bouton);
				}
			}
		}
		model.updateView();
		logger.log(Level.INFO, "Échiquier initialisé");
		return 1;
	}
	
}
