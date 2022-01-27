package controller;

import java.awt.Component;

import model.Model;
import view.Display;

public class Controller {
	
	private Display view;
	private Model model;
	
	public Controller(Model model, Display view) {
		this.model = model;
		this.view = view;
	}

	public void initBoard() {
		model.initBoard();
	}
	
	public int addComponentToPanel(Component component) {
		view.addComponent(component);
		return 1;
	}
}
