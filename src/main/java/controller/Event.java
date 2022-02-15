package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

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
	
	private ActionListener newGameListener;
	
	private JButton btnSelected = null;
	
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	public Event(Controller controller) {
		setController(controller);
		
		this.newGameListener = new  ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				controller.initBoard();
			}  
		};  
			
		this.buttonListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	String team = getTeam();
            	JButton piece = (JButton) e.getSource();
            	int l = (piece.getY()-controller.getY())/controller.getSquareSize();
            	int c = (piece.getX()-controller.getX())/controller.getSquareSize();
            	int pieceValue = getIntInBoard(l, c);
            	logger.log(Level.INFO, "pièce cliquée");
            	controller.clearPossibilities();
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
	 						controller.piecePossibilities(l, c, pieceValue);
	 					}
	 					else { 
	 						btnSelected = null;
	 					}
	 				}
	 				else { //aucune pièce n'est déjà sélectionnée, on selectionne la pièce cliquée
	 					piece.setBackground(Color.decode("#348339"));
	 					btnSelected = piece;
	 					piece.setOpaque(true);
	 					controller.piecePossibilities(l, c, pieceValue);
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
            		update();
            	}
            }
        };
        
        this.moveLabelListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            	logger.log(Level.INFO, "label cliqué");
            	JLabel possibility =  (JLabel) e.getSource();
            	controller.pieceMove(btnSelected, possibility);    	
            	update();
            	controller.checkmate();
            	controller.changeTeam();
            }
        };
        
        this.killLabelListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	logger.log(Level.INFO, "label cliqué");
            	JLabel possibility =  (JLabel) e.getSource();
            	controller.pieceKill(btnSelected, possibility);
            	update();
            	controller.checkmate();
            	controller.changeTeam();
            }
        };
        
        controller.setListener(buttonListener, panelListener, moveLabelListener, killLabelListener, newGameListener);
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
	
	public void update() {
		btnSelected.setBackground(null);
		btnSelected.setOpaque(false);
		btnSelected=null;
    	controller.clearPossibilities();
    	controller.updateView();
	}
}
