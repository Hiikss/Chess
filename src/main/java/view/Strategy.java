package view;

import java.awt.Component;
import java.awt.Image;

/** 
 * L'interface <b>Strategy</b> appartient au package <b>view</b>, elle définie les méthodes qui seront implémentées dans les classes concrètes
 * .
 * @author Thomas
 */
public interface Strategy {

	public int createFrame(Image board);
	
	public int updateView();
	
	public int addComponent(Component component);
	
}
