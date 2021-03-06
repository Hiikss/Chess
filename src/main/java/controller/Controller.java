package controller;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	
	public void setListener(MouseAdapter buttonListener, MouseAdapter panelListener, MouseAdapter moveLabelListener, MouseAdapter killLabelListener, ActionListener validateButtonListener, 
			MouseAdapter switchLoggingListener, ActionListener newGameListener, ActionListener uploadImageListener, ActionListener parcourirListener, ActionListener saveGameListener,
			ActionListener loadGameListener, ActionListener loadButtonListener) {
		this.buttonListener = buttonListener;
		this.panelListener = panelListener;
		this.moveLabelListener = moveLabelListener;
		this.killLabelListener = killLabelListener;
		view.addListener(this.panelListener, validateButtonListener, switchLoggingListener, newGameListener, uploadImageListener, parcourirListener, saveGameListener, loadGameListener, loadButtonListener);
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
	
	public void piecePossibilities(int l, int c, int value) {
		model.piecePossibilities(l, c, value);
	}
	public int getSquareSize() {
		return view.getSquareSize();
	}
	
	public void clearPossibilities() {
		view.clearPossibilities();
	}
	
	public void pieceMove(JButton btnSelected, JLabel possibility) {
		model.pieceMove(btnSelected, possibility);
		
	}
	
	public void pieceKill(JButton btnSelected, JLabel possibility) {
		model.pieceKill(btnSelected, possibility);
	}
	
	public void removeButton(JButton btnKilled) {
		view.removeButton(btnKilled);
		
	}
	
	public JButton getPieceAt(int l, int c) {
		return view.getPieceAt(l, c);
	}
	
	public void changeTeam() {
		model.changeTeam();
	}
	
	public void gameEnd(String reason) {
		view.gameEnd(reason);
	}
	
	public void checkmate() {
		model.checkmate();
	}
	
	public void deleteAllComponents() {
		view.deleteAllComponents();
		
	}
	public JTextField getPasswordField() {
		return view.getPasswordField();
	}
	public JTextField getUsernameField() {
		return view.getUsernameField();
	}
	
	public JLabel getCreerCompte() {
		return view.getCreerCompte();
	}

	public JLabel getSeConnecter() {
		return view.getSeConnecter();
	}
	
	public JLabel getInfo() {
		return view.getInfo();
	}
	
	public int connect(String username, String password) {
		return model.connect(username, password);
	}
	public int createAccount(String username, String password) {
		return model.createAccount(username, password);
	}
	
	public void setJDialogTitle(String title) {
		view.setJDialogTitle(title);
	}
	public void createNewPlayer(int joueur, String name) {
		model.createNewPlayer(joueur, name);
	}
	public void setUploadImageVisible() {
		view.setUploadImageVisible();
	}
	
	public void setLoadGameVisible() {
		view.setLoadGameVisible();
	}
	
	public ImageIcon getIcon(String joueur) {
		return model.getResizedIcon(joueur);
	}
	
	public void setImageJ1(ImageIcon image) {
		view.setImageJ1(image);
	}

	public void setImageJ2(ImageIcon image) {
		view.setImageJ2(image);
	}
	public void setImageAccount(int joueur, File file) {
		model.setImageAccount(joueur, file);
	}
	
	public void setNameJ1(String name) {
		view.setNameJ1(name);
	}
	
	public void setNameJ2(String name) {
		view.setNameJ2(name);
	}
	
	public String getNameJ1() {
		return model.getNameJ1();
	}
	public void setGame() {
		model.setGame();
	}
	
	public void getGame(String item) {
		model.getGame(item);
	}
	
	public void addGamesToItem() {
		model.addGameToItem();
	}
	
	public void addItemsToList(List<String> items) {
		view.addItemsToList(items);
	}
	
	public String getItem() {
		return view.getItem();
	}
}
