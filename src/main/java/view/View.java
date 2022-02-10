package view;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>View</b> appartient au package <b>view</b>, c'est la classe context de l'interface Strategy.
 * C'est la classe qui gère la vue dans le modèle MVC.
 * @author Thomas
 */
public class View {
	
	private final Logger logger =  LogManager.getLogger(this); //log4j2

	private Strategy strategy; //interface Strategy

	/**
	  * La méthode View est la méthode principale de la classe View.
	  * Elle sert à mettre l'interface Strategy dans la variable strategy.
	  * @param strategy interface Strategy
	  */
	public View(Strategy strategy){
	   this.strategy = strategy;
	   logger.log(Level.INFO, "création vue");
	}

	/**
	  * La méthode View appelle la méthode createFrame de l'interface Strategy.
	  * @see Strategy#createFrame(Image board)
	  * @param board image de l'échiquier à afficher sur le panel
	  * @return 1 si la méthode a bien été exécutée
	  */
	public int createFrame(){
	   strategy.createFrame();
	   return 1;
	}
	
	/**
	  * La méthode addComponent appelle la méthode addComponent de l'interface Strategy.
	  * @see Strategy#addComponent(Component component)
	  * @param component composant à ajouter au panel
	  * @return 1 si la méthode a bien été exécutée
	  */
	public int addComponent(Component component) {
		strategy.addComponent(component);
		logger.log(Level.INFO, "Élément ajouté au panel");
		return 1;
	}
	
	/**
	  * La méthode updateView appelle la méthode updateView de l'interface Strategy.
	  * @see Strategy#updateView()
	  */
	public void updateView() {
		strategy.updateView();
	}
	
	/**
	 * La méthode getX appelle la méthode getX de l'interface Strategy
	 * @see Strategy#getX()
	 * @return la valeur horizontale en pixel
	 */
	public int getX() {
		return strategy.getX();
	}
	
	/**
	 * La méthode getY appelle la méthode getY de l'interface Strategy
	 * @see Strategy#getY()
	 * @return la valeur verticale en pixel
	 */
	public int getY() {
		return strategy.getY();
	}
	
	public void addListener(MouseAdapter listener) {
		strategy.addListener(listener);
	}

	public int getSquareSize() {
		return strategy.getSquareSize();
	}
	
	public void clearPossibilities() {
		strategy.clearPossibilities();
	}
}
