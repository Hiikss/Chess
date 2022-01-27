package controller;

import java.awt.Component;

import javax.swing.JPanel;

import model.Init;
import model.Model;
import view.Display;
import view.Swing;

public class Controller {
	
	private Display view;
	private Init init;
	private Model model;
	private Swing swing = new Swing();
	
	public Controller(Model model, Display view) {
		this.model = model;
		this.view = view;
		initBoard();
	}

	public void initBoard() {
		model.initBoard();
	}

	public int setBoard() {
		init.initBoard();
		return 1;
	}
	
	public void setDisplayView(int vue) {
		view.setView(vue);
	}
	
	public int getDisplayedView() {
		return view.getView();
	}
	
	public JPanel getSwingPanel() {
		return swing.getPanel();
	}
	
	public int addComponentToPanel(JPanel panel, Component component) {
		view.addComponent(panel, component);
		return 1;
	}
}
