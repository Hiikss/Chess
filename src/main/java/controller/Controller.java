package controller;

import java.awt.Component;

import model.Model;
import view.View;

/** 
 * La classe <b>Controller</b> appartient au package <b>controller</b>, c'est la classe qui gère le contrôleur dans le modèle MVC.
 * @author Thomas
 */
public class Controller {
	
	private View view;
	
	private Model model;
	/**
	  * la méthode Controller permet de mettre en lien les 3 éléments du pattern MVC
	  * @param model classe Model
	  * @param view classe View
	  */
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	/**
	  * La méthode initBoard la méthode initBoard de la classe Model
	  * @see Model#initBoard()
	  */
	public void initBoard() {
		model.initBoard();
	}
	
	/**
	  * La méthode addComponentToPanel la méthode addComponent de la classe View
	  * @see View#addComponent(Component component)
	  * @param component composant à ajouter au panel
	  */
	public int addComponentToPanel(Component component) {
		view.addComponent(component);
		return 1;
	}
	
	/**
	  * La méthode updateView la méthode updateView de la classe View.
	  * @see View#updateView()
	  */
	public void updateView() {
		view.updateView();
	}
}
