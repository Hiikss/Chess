package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;

/** 
 * La classe <b>Model</b> appartient au package <b>model</b>, c'est la classe qui gère le modèle dans le modèle MVC.
 * @author Thomas
 */
public class Model {

	private Init init = new Init(this);
	
	private Piece piece = new Piece(this);
	
	private Board board;
	
	private Movement movement = new Movement(this);
	
	private Checked checked = new Checked();
	
	private Chrono chrono = new Chrono(this);
	
	private Connect connect = new Connect();
	
	private Controller controller;
	
	private int x;
	
	private int y;
	
	private int squareSize;
	
	private int [][] chessboard = new int [8][8];
	
	private ArrayList<JButton> piecesBlanches = new ArrayList<JButton>();
	
	private ArrayList<JButton> piecesNoires = new ArrayList<JButton>();
	
	private final Logger logger =  LogManager.getLogger(this);
	
	private String team;
	
	public boolean hasTA1Moved;
	public boolean hasTH1Moved;
	public boolean hasWhiteKingMoved;
	
	public boolean roqueBlancGauche;
	public boolean roqueBlancDroit;
	
	public boolean hasTA8Moved;
	public boolean hasTH8Moved;
	public boolean hasBlackKingMoved;
	
	public boolean roqueNoirGauche;
	public boolean roqueNoirDroit;
	
	private Timer timerBlanc;	
	private Timer timerNoir;
	
	private Joueur joueur1 = new Joueur();
	private Joueur joueur2 = new Joueur();
	
	/**
	  * la méthode getController retourne le controller.
	  * @return le controller 
	  */
	public Controller getController() {
		return controller;
	}
	
	/**
	  * la méthode setController définie la variable controller.
	  * @param controller controller
	  */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	  * la méthode addComponent appeller la méthode getController de la classe Controller
	  * @see Controller#addComponentToPanel(Component component)
	  * @param c composant à ajouter au panel
	  */
	public void addComponent(Component c) {
		controller = getController();
		controller.addComponentToPanel(c);
	}
	
	/**
	  * la méthode initBoard appelle la méthode initBoard de la classe Init
	  * @see Init#initBoard()
	  */
	public void initBoard() {
		team = "white";
		hasTA1Moved = false;
		hasTH1Moved = false;
		hasWhiteKingMoved = false;
		roqueBlancGauche = false;
		roqueBlancDroit = false;
		hasTA8Moved = false;
		hasTH8Moved = false;
		hasBlackKingMoved = false;
		roqueNoirGauche = false;
		roqueNoirDroit = false;
		setX(controller.getX());
		setY(controller.getY());
		setSquareSize(controller.getSquareSize());
		controller.deleteAllComponents();
		init.initBoard();
		chrono.countdownTimer();
		stopTimers();
		setCursor();
		displayPlayer(joueur1);
		displayPlayer(joueur2);
		updateView();
	}
	
	/**
	  * la méthode getButton appelle la méthode getController de la classe Controller et retourne un bouton.
	  * @see Piece#getButton(int value, int l, int c)
	  * @param value valeur de la pièce
	  * @param l ligne du tableau multidimentionnel
	  * @param c colonne du tableau multidimentionnel
	  * @return la pièce qui correspond à la valeur dans le tableau multidimentionnel 
	  */
	public JButton getButton(int value, int l, int c) {
		return piece.getButton(value, l, c, squareSize);
	}
	
	/**
	  * la méthode updateView appelle la méthode updateView de la classe Controller.
	  * @see Controller#updateView()
	  */
	public void updateView() {
		controller.updateView();
	}
	
	/**
	  * la méthode getBoard appelle la méthode getBoard de la classe Board et stock le tableau multidimentionnel retourné dans la variable chessboard.
	  * On retourne ensuite la valeur d'une case du tableau.
	  * @see Board#getBoard()
	  * @param l ligne du tableau multidimentionnel
	  * @param c colonne du tableau multidimentionnel
	  * @return la valeur dans le tableau à la ligne l et à la colonne c
	  */
	public int getIntInBoard(int l, int c){
		this.chessboard = board.getBoard();
		return chessboard[l][c];
	}
	
	public int[][] getChessboard(){
		return chessboard;
	}
	
	/**
	  * la méthode createBoard appelle la méthode Board de la classe Board et stock la valeur dans la variable board.
	  * @see Board#Board()
	  */
	public void createBoard() {
		this.board = new Board();
	}
	
	/**
	 * La méthode getX retourne la valeur de la variable x
	 * @return la valeur horizontale en pixel
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * La méthode setX attribue une valeur à la variable x
	 * @param x valeur horizontale en pixel
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * La méthode setY attribue une valeur à la variable y
	 * @param y valeur verticale en pixel
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * La méthode getX retourne la valeur de la variable y
	 * @return la valeur verticale en pixel
	 */
	public int getY() {
		return y;
	}
	
	public int getSquareSize() {
		return squareSize;
	}
	
	public void setSquareSize(int squareSize) {
		this.squareSize = squareSize;
	}
	
	public MouseAdapter addButtonListener() {
		return controller.getButtonListener();
	}
	
	public MouseAdapter addMoveLabelListener() {
		return controller.getMoveLabelListener();
	}
	
	public MouseAdapter addKillLabelListener() {
		return controller.getKillLabelListener();
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public void piecePossibilities(int l, int c, int value) {
		
		if(value==1 || value==-1) {
			
			movement.deplacementPion(l, c, chessboard, value);
		}
		else if(value==2 || value==-2) {
			
			movement.deplacementCavalier(l,c,chessboard, value);
		}
		else if(value==3 || value==-3) {

			movement.deplacementDiag(l,c,chessboard, value);
		}
		else if(value==5 || value==-5) {
			
			movement.deplacementLigne(l,c,chessboard, value);
		}
		else if(value==9 || value==-9) {
			
			movement.deplacementDiag(l,c,chessboard, value);
			movement.deplacementLigne(l,c,chessboard, value);
		}
		else if(value==10 || value==-10) {
			
			movement.deplacementRoi(l,c,chessboard, value);
		}
	}

	public void pieceMove(JButton btn, JLabel possibility) {
		int l = (possibility.getY()-y)/squareSize;
		int c = (possibility.getX()-x)/squareSize;
		int l1 = (btn.getY()-y)/squareSize;
		int c1 = (btn.getX()-x)/squareSize;
		if(roqueBlancGauche==true && l==7 && c==2) {
			JButton p = getPieceAt(7,0);
			p.setLocation(p.getX()+3*squareSize,p.getY());
			chessboard[7][3]=5;
			chessboard[7][0]=0;
		}
		else if(roqueBlancDroit==true && l==7 && c==6) {
			JButton p = getPieceAt(7,7);
			p.setLocation(p.getX()-2*squareSize,p.getY());
			chessboard[7][5]=5;
			chessboard[7][7]=0;
		}
		else if(roqueNoirGauche==true && l==0 && c==2) {
			JButton p = getPieceAt(0,0);
			p.setLocation(p.getX()+3*squareSize,p.getY());
			chessboard[0][3]=-5;
			chessboard[0][0]=0;
		}
		else if(roqueNoirDroit==true && l==0 && c==6) {
			JButton p = getPieceAt(0,7);
			p.setLocation(p.getX()-2*squareSize,p.getY());
			chessboard[0][5]=-5;
			chessboard[0][7]=0;
		}
		roque(l, c, l1, c1);
		btn.setLocation(possibility.getLocation());
		
		
	}

	public void pieceKill(JButton btn, JLabel possibility) {
		JButton btnKilled = (JButton) possibility.getParent();
		int l = (btnKilled.getY()-y)/squareSize;
		int c = (btnKilled.getX()-x)/squareSize;
		int l1 = (btn.getY()-y)/squareSize;
		int c1 = (btn.getX()-x)/squareSize;
		roque(l, c, l1, c1);
		controller.removeButton(btnKilled);
		btn.setLocation(btnKilled.getLocation());

	}
	
	public void roque(int l, int c, int l1, int c1) {
		chessboard[l][c]=chessboard[l1][c1];
		chessboard[l1][c1]=0;
		
		if(l1==7 && c1==0 && hasTA1Moved==false) {
			hasTA1Moved = true;
		}
		if(l1==7 && c1==7 && hasTH1Moved==false) {
			hasTH1Moved = true;
		}
		if(l1==7 && c1==4 && hasWhiteKingMoved==false) {
			hasWhiteKingMoved = true;
		}
		if(l1==0 && c1==0 && hasTA8Moved==false) {
			hasTA8Moved = true;
		}
		if(l1==0 && c1==7 && hasTH8Moved==false) {
			hasTH8Moved = true;
		}
		if(l1==0 && c1==4 && hasBlackKingMoved==false) {
			hasBlackKingMoved = true;
		}
	}

	public JButton getPieceAt(int l, int c) {
		return controller.getPieceAt(l, c);
	}
	
	public void setWhitePieces(){
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(chessboard[l][c]>0) {
					JButton piece = getPieceAt(l, c);
					piecesBlanches.add(piece);
				}
			}
		}
	}
	
	public void setBlackPieces(){
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(chessboard[l][c]<0) {
					JButton piece = getPieceAt(l, c);
					piecesNoires.add(piece);
				}
			}
		}
	}
	
	public void setCursor() {
		int sizePiecesBlanches = piecesBlanches.size();
		int sizePiecesNoires = piecesNoires.size();
		if(team.equals("white")) {
			for(int i=0;i<sizePiecesNoires;i++) {
				piecesNoires.get(i).setCursor(null);
			}
			for(int i=0;i<sizePiecesBlanches;i++) {
				piecesBlanches.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
		if(team.equals("black")) {
			for(int i=0;i<sizePiecesNoires;i++) {
				piecesNoires.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			for(int i=0;i<sizePiecesBlanches;i++) {
				piecesBlanches.get(i).setCursor(null);
			}
		}
	}

	public void changeTeam() {
		setTimerBlanc(getTimerBlanc());
		setTimerNoir(getTimerNoir());
		if(team.equals("white")) {
			team = "black";
			timerBlanc.stop();
			timerNoir.start();
		}
		else {
			team = "white";
			timerNoir.stop();
			timerBlanc.start();
		}
		setCursor();
	}

	public void check() {
		if(team.equals("white") && isBlackKingAttacked(chessboard)==true) {
			logger.log(Level.INFO, "Roi Noir attaqué");
		}
		else if(team.equals("black") && isWhiteKingAttacked(chessboard)==true) {
			logger.log(Level.INFO, "Roi Blanc attaqué");
		}
		
	}
	
	public void setTimerBlanc(Timer timerBlanc) {
		this.timerBlanc = timerBlanc;
	}
	
	public void setTimerNoir(Timer timerNoir) {
		this.timerNoir = timerNoir;
	}
	
	public Timer getTimerBlanc() {
		return chrono.getWhiteTimer();
	}
	
	public Timer getTimerNoir() {
		return chrono.getBlackTimer();
	}
	
	public  void gameEnd(String reason) {
		stopTimers();
		controller.gameEnd(reason);

	}
	
	public boolean isWhiteKingAttacked(int[][] board) {
		return checked.isWhiteKingAttacked(board);
	}
	
	public boolean isBlackKingAttacked(int[][] board) {
		return checked.isBlackKingAttacked(board);
	}
	
	public void checkmate() {
		if(team.equals("black") && checked.isWhiteKingAttacked(chessboard)==true && isKingCheckmate(chessboard, team)==true) {
			controller.clearPossibilities();
			controller.updateView();
			setKingBackground(10);
			gameEnd("Victoire des noirs par mat");
		}
		else if(team.equals("white") && checked.isBlackKingAttacked(chessboard)==true && isKingCheckmate(chessboard, team)==true) {
			controller.clearPossibilities();
			controller.updateView();
			setKingBackground(-10);
			gameEnd("Victoire des blancs par mat");
		}
	}
	
	public void setKingBackground(int value) {
		JButton p;
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(chessboard[l][c]==value) {
					p = getPieceAt(l, c);
					p.setBackground(Color.decode("#ff1111"));
					p.setOpaque(true);
					break;
				}
			}
		}
	}
	
	public boolean isKingCheckmate(int[][] board, String team) {
		boolean isKingCheckmate = true;
		int p=1;
		int f=2;
		int ca=3;
		int t=5;
		int d=9;
		int r=10;
		if(team.equals("white")) {
			p=-1;
			f=-2;
			ca=-3;
			t=-5;
			d=-9;
			r=-10;
		}
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(board[l][c]==p && movement.deplacementPion(l, c, chessboard, p)==true) {
					isKingCheckmate = false;
				}
				else if(board[l][c]==f && movement.deplacementCavalier(l, c, chessboard, f)==true) {
					isKingCheckmate = false;
				}
				else if(board[l][c]==ca && movement.deplacementDiag(l, c, chessboard, ca)==true) {
					isKingCheckmate = false;
				}
				else if(board[l][c]==t && movement.deplacementLigne(l, c, chessboard, t)==true) {
					isKingCheckmate = false;
				}
				else if(board[l][c]==d && (movement.deplacementLigne(l, c, chessboard, d)==true || movement.deplacementDiag(l, c, chessboard, d)==true)) {
					isKingCheckmate = false;
				}
				else if(board[l][c]==r && movement.deplacementRoi(l, c, chessboard, r)==true) {
					isKingCheckmate = false;
				}
			}
		}
		controller.clearPossibilities();
		return isKingCheckmate;
	}
	
	public void stopTimers() {
		if(timerNoir!=null && timerBlanc!=null) {
			timerNoir.stop();
			timerBlanc.stop();
		}
	}
	
	public int connect(String username, String password) {
		return connect.connect(username, password);
	}

	public int createAccount(String username, String password) {
		return connect.createAccount(username, password);
	}

	public void createNewPlayer(int joueur, String name) {
		switch(joueur) {
		case 1: 
			joueur1.setName(name);
			joueur1.setIcon(connect.getImageAccount(name));
		break;
		case 2: 
			joueur2.setName(name);
			joueur2.setIcon(connect.getImageAccount(name));
		break;
		}
	}
	
	public void displayPlayer(Joueur joueur) {
		JLabel label = new JLabel(joueur.getName());
		JLabel labelImage = new JLabel();
		ImageIcon img= new ImageIcon(joueur.getIcon().getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		labelImage.setIcon(img);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		if(joueur==joueur1) {
			label.setBounds(895, 580, 100, 30);
			labelImage.setBounds(895, 475, 100, 100);
		}
		else {
			label.setBounds(895, 155, 100, 30);
			labelImage.setBounds(895, 50, 100, 100);
		}
		controller.addComponentToPanel(label);
		controller.addComponentToPanel(labelImage);
	}
	
	public ImageIcon getIcon(String joueur) {
		if(joueur=="joueur 1") {
			ImageIcon img= new ImageIcon(joueur1.getIcon().getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			return img;
		}
		else {
			ImageIcon img= new ImageIcon(joueur2.getIcon().getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			return img;
		}
	}

	public void setImageAccount(int joueur, File file) {
		Image image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon img = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		switch(joueur) {
		case 1: 
			joueur1.setIcon(img);
			connect.setImageAccount(joueur1.getName(), file);
		break;
		case 2: 
			joueur2.setIcon(img);
			connect.setImageAccount(joueur2.getName(), file);
		break;
		}
	}
	
	public Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}
