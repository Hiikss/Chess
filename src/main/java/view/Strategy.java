package view;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
	public int createFrame();
	
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
	
	/**
	 * Méthode de l'interface Strategy
	 * @see Swing#getX()
	 * @return la valeur horizontale en pixel
	 */
	public int getX();
	
	/**
	 * Méthode de l'interface Strategy
	 * @see Swing#getY()
	 * @return la valeur verticale en pixel
	 */
	public int getY();
	
	public int getSquareSize();
	
	public void addListener(MouseAdapter listener, ActionListener validateButtonListener, MouseAdapter switchLoggingListener, ActionListener newGameListener, ActionListener uploadImageListener,
			ActionListener parcourirListener, ActionListener saveGameListener, ActionListener loadGameListener);
	
	public void clearPossibilities();

	public void removeButton(JButton btnKilled);

	public JButton getPieceAt(int l, int c);
	
	public void gameEnd(String reason);
	
	public void deleteAllComponents();
	
	public void gameStart();

	public JTextField getUsernameField();
	
	public JTextField getPasswordField();
	
	public JLabel getCreerCompte();
	
	public JLabel getSeConnecter();
	
	public JLabel getInfo();
	
	public void setJDialogTitle(String title);

	public void setUploadImageVisible();
	
	public void setLoadGameVisible();
	
	public void setImageJ1(ImageIcon image);
	
	public void setImageJ2(ImageIcon image);
	
	public void setNameJ1(String name);
	
	public void setNameJ2(String name);
	
}
