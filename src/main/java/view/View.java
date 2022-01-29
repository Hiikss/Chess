package view;

import java.awt.Component;
import java.awt.Image;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/** 
 * La classe <b>View</b> appartient au package <b>view</b>.
 * Il s'agit d'une classe Context qui utilise les différentes strategies. 
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
	  */
	public int createFrame(Image board){
	   strategy.createFrame(board);
	   return 1;
	}
	
	/**
	  * La méthode addComponent appelle la méthode addComponent de l'interface Strategy.
	  * @see Strategy#addComponent(Component component)
	  * @param component composant à ajouter au panel
	  */
	public int addComponent(Component component) {
		strategy.addComponent(component);
		logger.log(Level.INFO, "Pièce ajoutée au panel");
		return 1;
	}
	
	/**
	  * La méthode updateView appelle la méthode updateView de l'interface Strategy.
	  * @see Strategy#updateView()
	  */
	public void updateView() {
		strategy.updateView();
	}
}
