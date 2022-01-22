package controller;

import model.Init;
import view.Display;

public class Controller {
	
	private Display view;
	private Init init;
	
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
}
