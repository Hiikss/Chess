package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	
	private MouseAdapter mouseAdapter;
	
	private JButton btnSelected = null;
	
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	public Event(Controller controller) {
		setController(controller);
		
		this.mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	if(e.getSource() instanceof JButton) {
            		String team = getTeam();
            		JButton piece = (JButton) e.getSource();
            		int x = (piece.getX()-200)/75;
            		int y = (piece.getY()-25)/75;
            		int pieceValue = getBoard(y, x);
            		logger.log(Level.INFO, "pièce cliquée");
            		if((team.equals("white") && pieceValue<0 || team.equals("black") && pieceValue>0) && btnSelected!=null) {
            			btnSelected.setBackground(null);
            			btnSelected.setOpaque(false);
            			btnSelected=null;
            		}
            		else if(team.equals("white") && pieceValue>0 || team.equals("black") && pieceValue<0) {
            			if(btnSelected!=null) {
            				btnSelected.setBackground(null);
            				btnSelected.setOpaque(false);
	 						if(btnSelected!=piece) {
	 							piece.setBackground(Color.decode("#348339"));
	 							btnSelected = piece;
	 							piece.setOpaque(true);
	 						}
	 						else {
	 							btnSelected = null;
	 						}
	 					
	 					}
	 					else {
	 						piece.setBackground(Color.decode("#348339"));
	 						btnSelected = piece;
	 						piece.setOpaque(true);
	 					}
            		}
            	}
            	else if(e.getSource() instanceof JPanel && btnSelected!=null){
            		logger.log(Level.INFO, "panel cliqué");
            	}
            	controller.updateView();
            }
        };
        controller.setListener(mouseAdapter);
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
	
	public int getBoard(int x, int y) {
		return controller.getBoard(y, x);
	}
}
