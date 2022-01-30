package model;

import java.awt.Component;

import javax.swing.JButton;

import controller.Controller;

/** 
 * La classe <b>Model</b> appartient au package <b>model</b>, c'est la classe qui gère le modèle dans le modèle MVC.
 * @author Thomas
 */
public class Model {

	private Init init = new Init(this);
	
	private Piece piece = new Piece();
	
	private Board board;
	
	private Controller controller;
	
	private int [][] chessboard = new int [8][8];
	
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
	  * @param component composant à ajouter au panel
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
		init.initBoard();
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
		return piece.getButton(value, l, c);
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
	public int getBoard(int l, int c){
		this.chessboard = board.getBoard();
		return chessboard[l][c];
	} 
	
	/**
	  * la méthode createBoard appelle la méthode Board de la classe Board et stock la valeur dans la variable board.
	  * @see Board#Board()
	  */
	public void createBoard() {
		this.board = new Board();
	}
}
