package controller;

import javax.swing.JPanel;

import model.Init;
import view.Display;
import view.Swing;

public class Controller {
	
	private Display view;
	private Init init;
	private Swing swing;
	
	public Controller(Init init, Display view) {
		this.init = init;
		this.view = view;
	}

	public void updateView() {
		
	}

	public int setBoard() {
		init.initBoard();
		return 1;
	}
	
	public void setDisplayView(int vue) {
		view.setView(vue);
	}
	
	public int getDisplayView() {
		return view.getView();
	}
	
	public JPanel getSwingPanel() {
		return swing.getPanel();
	}
}
