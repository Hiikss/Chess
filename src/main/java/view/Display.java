package view;

import java.awt.Image;

public class Display {
	
	private Strategy strategy;

	public Display(Strategy strategy){
	   this.strategy = strategy;
	}

	public int executeStrategy(Image board){
	   return strategy.performAction(board);
	}

}
