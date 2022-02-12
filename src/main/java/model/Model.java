package model;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

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
	
	private Controller controller;
	
	private int x;
	
	private int y;
	
	private int squareSize;
	
	private int [][] chessboard = new int [8][8];
	
	private ArrayList<JButton> piecesBlanches = new ArrayList<JButton>();
	
	private ArrayList<JButton> piecesNoires = new ArrayList<JButton>();
	
	private final Logger logger =  LogManager.getLogger(this);
	
	private String team = "white";
	
	private Timer timerBlanc;	
	private Timer timerNoir;
	

	
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
		setX(controller.getX());
		setY(controller.getY());
		setSquareSize(controller.getSquareSize());
		init.initBoard();
		chrono.countdownTimer();
		setCursor();
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
		
		if(value==1) {
			
			movement.deplacementPionBlanc(l, c, chessboard);
		}
		else if(value==-1) {
			movement.deplacementPionNoir(l, c, chessboard);
		}
		else if(value==2 || value==-2) {
			
			movement.deplacementCavalier(l,c,chessboard, team);
		}
		else if(value==3 || value==-3) {

			movement.deplacementDiag(l,c,chessboard, team);
		}
		else if(value==5 || value==-5) {
			
			movement.deplacementLigne(l,c,chessboard, team);
		}
		else if(value==9 || value==-9) {
			
			movement.deplacementDiag(l,c,chessboard, team);
			movement.deplacementLigne(l,c,chessboard, team);
		}
		else if(value==10 || value==-10) {
			
			movement.deplacementRoi(l,c,chessboard, team);
		}
	}

	public void pieceMove(JButton btn, JLabel possibility) {
		int xBtn = btn.getX();
		int yBtn = btn.getY();
		int xPossibility = possibility.getX();
		int yPossibility = possibility.getY();
		chessboard[(yPossibility-y)/squareSize][(xPossibility-x)/squareSize]=chessboard[(yBtn-y)/squareSize][(xBtn-x)/squareSize];
		chessboard[(yBtn-y)/squareSize][(xBtn-x)/squareSize]=0;
		btn.setLocation(xPossibility, yPossibility);
	}

	public void pieceKill(JButton btn, JLabel possibility) {
		JButton btnKilled = (JButton) possibility.getParent();
		int xBtn = btn.getX();
		int yBtn = btn.getY();
		int xBtnKilled = btnKilled.getX();
		int yBtnKilled = btnKilled.getY();
		chessboard[(yBtnKilled-y)/squareSize][(xBtnKilled-x)/squareSize]=chessboard[(yBtn-y)/squareSize][(xBtn-x)/squareSize];
		chessboard[(yBtn-y)/squareSize][(xBtn-x)/squareSize]=0;
		controller.removeButton(btnKilled);
		btn.setLocation(btnKilled.getLocation());
	}

	public JButton getPieceAt(int x, int y) {
		return controller.getPieceAt(x, y);
	}
	
	public void setWhitePieces(){
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(chessboard[l][c]>0) {
					JButton piece = getPieceAt(x+c*squareSize, y+l*squareSize);
					piecesBlanches.add(piece);
				}
			}
		}
	}
	
	public void setBlackPieces(){
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				if(chessboard[l][c]<0) {
					JButton piece = getPieceAt(x+c*squareSize, y+l*squareSize);
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
		timerNoir.stop();
		timerBlanc.stop();
		controller.gameEnd(reason);

	}
	
	public boolean isWhiteKingAttacked(int[][] board) {
		return checked.isWhiteKingAttacked(board);
	}
	
	public boolean isBlackKingAttacked(int[][] board) {
		return checked.isBlackKingAttacked(board);
	}
}
