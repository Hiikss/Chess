package view;

import java.awt.Image;

/** 
 * La classe <b>Display</b> appartient au package <b>view</b>.
 * Il s'agit d'une classe Context qui utilise la strategy
 */
public class Display {
	
	private Strategy strategy;

	public Display(Strategy strategy){
	   this.strategy = strategy;
	}

	public int executeStrategy(Image board){
	   return strategy.performAction(board);
	}

}
