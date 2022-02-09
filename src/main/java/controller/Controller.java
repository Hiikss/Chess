package controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;

import model.Model;
import view.View;

/** 
 * La classe <b>Controller</b> appartient au package <b>controller</b>, c'est la classe qui gère le contrôleur dans le modèle MVC.
 * @author Thomas
 */
public class Controller {
	
	private View view;
	
	private Model model;
	
	private Event event;
	
	private MouseAdapter buttonListener;

	private MouseAdapter panelListener;
	
	private MouseAdapter moveLabelListener;
	
	private MouseAdapter killLabelListener;
	/**
	  * la méthode Controller permet de mettre en lien les 3 éléments du pattern MVC
	  * @param model classe Model
	  * @param view classe View
	  */
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.event = new Event(this);
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
	  * @return  si la méthode a bien été exécutée
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
	
	/**
	 * La méthode getX appelle la méthode getX de la classe View
	 * @see View#getX()
	 * @return la valeur horizontale en pixel
	 */
	public int getX() {
		return view.getX();
	}
	
	/**
	 * La méthode getY appelle la méthode getY de la classe View
	 * @see View#getX()
	 * @return la valeur horizontale en pixel
	 */
	public int getY() {
		return view.getY();
	}
	
	public void setListener(MouseAdapter buttonListener, MouseAdapter panelListener, MouseAdapter moveLabelListener, MouseAdapter killLabelListener) {
		this.buttonListener = buttonListener;
		this.panelListener = panelListener;
		this.moveLabelListener = moveLabelListener;
		this.killLabelListener = killLabelListener;
		view.addListener(this.panelListener);
	}
	
	public MouseAdapter getButtonListener() {
		return buttonListener;
	}
	
	public MouseAdapter getMoveLabelListener() {
		return moveLabelListener;
	}
	
	public MouseAdapter getKillLabelListener() {
		return killLabelListener;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public String getTeam() {
		return model.getTeam();
	}
	
	public void setTeam(String team) {
		model.setTeam(team);
	}
	
	public int getIntInBoard(int x, int y) {
		return model.getIntInBoard(y, x);
	}
}
