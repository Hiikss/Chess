package model;

import java.awt.Component;

import controller.Controller;

public class Model {

	private Init init = new Init(this);
	
	private Controller controller;
	
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
}
