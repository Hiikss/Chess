package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Thomas
 *
 */
public class Event{
	
	private Controller controller;
	
	private MouseAdapter buttonListener;
	
	private MouseAdapter panelListener;
	
	private MouseAdapter moveLabelListener;
	
	private MouseAdapter killLabelListener;
	
	private JButton btnSelected = null;
	
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	public Event(Controller controller) {
		setController(controller);
		
		this.buttonListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	String team = getTeam();
            	JButton piece = (JButton) e.getSource();
            	int x = (piece.getX()-200)/75;
            	int y = (piece.getY()-25)/75;
            	int pieceValue = getIntInBoard(y, x);
            	logger.log(Level.INFO, "pièce cliquée");
            	if((team.equals("white") && pieceValue<0 || team.equals("black") && pieceValue>0) && btnSelected!=null) { //clique sur pièce de l'équipe adverse
            		btnSelected.setBackground(null);
            		btnSelected.setOpaque(false);
            		btnSelected=null;
            	}
            	else if(team.equals("white") && pieceValue>0 || team.equals("black") && pieceValue<0) { //clique sur une pièce de son équipe
            		if(btnSelected!=null) { //une pièce est déjà sélectionnée, on la désélectionne
            			btnSelected.setBackground(null);
            			btnSelected.setOpaque(false);
	 					if(btnSelected!=piece) { //la pièce cliquée est une pièce différente que celle qui était sélectionnée, on sélectionne la pièce cliquée
	 						piece.setBackground(Color.decode("#348339"));
	 						btnSelected = piece;
	 						piece.setOpaque(true);
	 					}
	 					else { 
	 						btnSelected = null;
	 					}
	 				}
	 				else { //aucune pièce n'est déjà sélectionnée, on selectionne la pièce cliquée
	 					piece.setBackground(Color.decode("#348339"));
	 					btnSelected = piece;
	 					piece.setOpaque(true);
            		}
            	}
            	controller.updateView();
            }
        };
        
        this.panelListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	
            	if(btnSelected!=null){ //la source est un panel
            		logger.log(Level.INFO, "panel cliqué");
            		btnSelected.setBackground(null);
            		btnSelected.setOpaque(false);
            		btnSelected=null;
            	}
            	controller.updateView();
            }
        };
        
        controller.setListener(buttonListener, panelListener, moveLabelListener, killLabelListener);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public String getTeam() {
		return controller.getTeam();
	}

	public void setTeam(String team) {
		controller.setTeam(team);
	}
	
	public int getIntInBoard(int x, int y) {
		return controller.getIntInBoard(y, x);
	}
}
