package controller;

import java.awt.Component;

import model.Model;
import view.View;

public class Controller {
	
	private View view;
	private Model model;
	
	public Controller(Model model, View view) {
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
	
	public void updateView() {
		view.updateView();
	}
}
