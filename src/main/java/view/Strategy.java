package view;

import java.awt.Component;
import java.awt.Image;

/** 
 * L'interface <b>Strategy</b> appartient au package <b>view</b>, elle définie les méthodes qui sont implémentées dans les classes concrètes.
 * @author Thomas
 */
public interface Strategy {

	/**
	  * Méthode de l'interface Strategy.
	  * @see Swing#createFrame(Image board)
	  * @param board image de l'échiquier à afficher sur le panel
	  * @return 1 si la méthode a bien été exécutée
	  */
	public int createFrame(Image board);
	
	/**
	  * Méthode de l'interface Strategy.
	  * @see Swing#updateView()
	  * @return 1 si la méthode a bien été exécutée
	  */
	public int updateView();
	
	/**
	  * Méthode de l'interface Strategy.
	  * @see Swing#addComponent(Component component)
	  * @param component composant à ajouter au panel
	  * @return 1 si la méthode a bien été exécutée
	  */
	public int addComponent(Component component);
	
}
