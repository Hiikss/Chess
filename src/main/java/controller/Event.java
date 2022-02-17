package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	
	private ActionListener validateButtonListener;
	
	private ActionListener newGameListener;
	
	private MouseAdapter switchLoggingListener;
	
	private boolean createAccount = false;
	
	private JButton btnSelected = null;
	
	private int joueur = 1;
	
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	public Event(Controller controller) {
		setController(controller);  
			
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
        
        this.validateButtonListener = new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(!getUsernameField().getText().equals("") && !getPasswordField().getText().equals("")) {
					if(createAccount==false) {
						int connexion = controller.connect(getUsernameField().getText(), getPasswordField().getText());
						if(connexion==1) {
							logger.log(Level.INFO, "Connexion joueur " + joueur + " effectuée");
							getInfo().setText("<html><p style=color:green>Connexion effectuée</p></html>");
							if(joueur==1) {
								joueur=2;
								createAccount=false;
								getCreerCompte().setVisible(true);
				        		getSeConnecter().setVisible(false);
								setJDialogTitle("Connexion joueur " + joueur);
								controller.createNewPlayer(joueur, getUsernameField().getText());
								getUsernameField().setText(null);
								getPasswordField().setText(null);
							}
							else {
								controller.createNewPlayer(joueur, getUsernameField().getText());
								javax.swing.FocusManager.getCurrentManager().getActiveWindow().dispose();
								controller.initBoard();
							}
						}
						else if(connexion==2){
							logger.log(Level.ERROR, "Mot de passe erroné");
							getInfo().setText("<html><p style=color:red>Mot de passe erroné</p></html>");
						}
						else if(connexion==3){
							logger.log(Level.ERROR, "Nom d'utilisateur erroné ou compte inexistant");
							getInfo().setText("<html><p style=color:red>Nom d'utilisateur erroné ou compte inexistant</p></html>");
						}
						else if(connexion==4){
							logger.log(Level.ERROR, "Impossible de se connecter à la base de données");
						}
					}
					else {
						int connexion = controller.createAccount(getUsernameField().getText(), getPasswordField().getText());
						if(connexion==1) {
							logger.log(Level.INFO, "Création de compte effectuée");
							getInfo().setText("\"<html><p style=color:green>Le compte a bien été crée</p></html>");
							setJDialogTitle("Connexion joueur " + joueur);
			        		createAccount = false;
			        		getCreerCompte().setVisible(true);
			        		getSeConnecter().setVisible(false);
						}
						else if(connexion==2){
							logger.log(Level.ERROR, "Nom d'utilisateur déjà existant");
							getInfo().setText("<html><p style=color:red>Nom d'utilisateur déjà existant</p></html>");
						}
						else if(connexion==3){
							logger.log(Level.ERROR, "Impossible de se connecter à la base de données");
						}
					}
				}
			} 
		};
		
		this.switchLoggingListener = new MouseAdapter() {   
	        public void mouseClicked(MouseEvent e) {
	        	if(createAccount==false) {
	        		setJDialogTitle("Création compte joueur " + joueur);
	        		createAccount = true;
	        		getCreerCompte().setVisible(false);
	        		getSeConnecter().setVisible(true);
	        	}
	        	else {
	        		setJDialogTitle("Connexion joueur " + joueur);
	        		createAccount = false;
	        		getCreerCompte().setVisible(true);
	        		getSeConnecter().setVisible(false);
	        	}
	        }   
		};
		
		 this.newGameListener = new ActionListener(){  
				public void actionPerformed(ActionEvent e){ 
					controller.initBoard();
				}  
			}; 
        
        controller.setListener(buttonListener, panelListener, moveLabelListener, killLabelListener, validateButtonListener, switchLoggingListener, newGameListener);
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
	
	public JTextField getPasswordField() {
		return controller.getPasswordField();
	}
	public JTextField getUsernameField() {
		return controller.getUsernameField();
	}
	
	public JLabel getCreerCompte() {
		return controller.getCreerCompte();
	}

	public JLabel getSeConnecter() {
		return controller.getSeConnecter();
	}
	
	public JLabel getInfo() {
		return controller.getInfo();
	}
	
	public void setJDialogTitle(String title) {
		controller.setJDialogTitle(title);
	}
}
