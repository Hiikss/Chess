package view;

import java.awt.Component;
import java.awt.Image;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/** 
 * La classe <b>Display</b> appartient au package <b>view</b>.
 * Il s'agit d'une classe Context qui utilise la strategy
 */
public class Display {
	
	private final Logger logger =  LogManager.getLogger(this);

	private Strategy strategy;

	public Display(Strategy strategy){
	   this.strategy = strategy;
	   logger.log(Level.INFO, "création vue");
	}

	public int executeStrategy(Image board){
	   strategy.performAction(board);
	   return 1;
	}
	
	public int addComponent(Component component) {
		strategy.addComponent(component);
		logger.log(Level.INFO, "Pièce ajoutée au panel");
		return 1;
	}
	
	public void updateView() {
		strategy.updateView();
	}
}
