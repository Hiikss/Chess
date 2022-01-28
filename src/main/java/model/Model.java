package model;

import java.awt.Component;

import javax.swing.JButton;

import controller.Controller;

public class Model {

	private Init init = new Init(this);
	
	private Piece piece = new Piece();
	
	private Board board;
	
	private Controller controller;
	
	private int [][] chessboard = new int [8][8];
	
	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void addComponent(Component c) {
		controller = getController();
		controller.addComponentToPanel(c);
	}
	
	public void initBoard() {
		init.initBoard();
	}
	
	public JButton getButton(int value, int l, int c) {
		return piece.getButton(value, l, c);
	}
	
	public void updateView() {
		controller.updateView();
	}
	
	public int getBoard(int l, int c){
		chessboard = board.getBoard();
		return chessboard[l][c];
	} 
	
	public void createBoard() {
		board = new Board();
	}
}
