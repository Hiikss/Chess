package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;

import log4j2.Log4j;

/** 
 * La classe <b>Display</b> appartient au package <b>view</b>.
 * Il s'agit d'une classe Context qui utilise la strategy
 */
public class Display {
	
	private Log4j log = new Log4j();
	
	private Swing swing = new Swing();
	
	private int vue = 0;
	
	private Strategy strategy;

	public Display(Strategy strategy){
	   this.strategy = strategy;
	   log.logInfo("création vue");
	}

	public int executeStrategy(Image board){
	   return strategy.performAction(board);
	}
	
	public int getView() {
		return vue;
	}
	
	public void setView(int vue) {
		this.vue = vue;
	}
	
	public JPanel getPanel() {
		return swing.getPanel();
	}
	
	public int addComponent(JPanel panel, Component component) {
		swing.addComponent(panel, component);
		return 1;
	}
}
