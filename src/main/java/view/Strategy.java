package view;

import java.awt.Component;
import java.awt.Image;

/** 
 * L'interface <b>Strategy</b> appartient au package <b>view</b>.
 * 
 */
public interface Strategy {

	public int createFrame(Image board);
	
	public int updateView();
	
	public int addComponent(Component component);
	
}
