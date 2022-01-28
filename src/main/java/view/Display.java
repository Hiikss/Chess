package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/** 
 * La classe <b>Display</b> appartient au package <b>view</b>.
 * Il s'agit d'une classe Context qui utilise la strategy
 */
public class Display {
	
	private final Logger logger =  LogManager.getLogger(this);
	
	private Swing swing;
	
	private JPanel panel;
	
	private Strategy strategy;

	public Display(Strategy strategy){
	   this.strategy = strategy;
	   logger.log(Level.INFO, "création vue");
	}

	public int executeStrategy(Image board){
	   strategy.performAction(board);
	   return 1;
	}
	
	public int setDisplay(Display view) {
		strategy.setDisplay(view);
		return 1;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public void setSwing(Swing swing) {
		this.swing = swing;
	}
	
	public int addComponent(Component component) {
		panel = getPanel();
		panel.add(component);
		logger.log(Level.INFO, "Pièce ajoutée au panel");
		return 1;
	}
	
	public void updateView() {
		panel.repaint();
		panel.revalidate();
	}
}
