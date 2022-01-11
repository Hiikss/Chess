package model;

import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.Display;

/** 
 * La classe <b>Game</b> appartient au package <b>model</b>.
 * Elle regroupe trois méthodes permettant de changer d'équipe à chaque coups, de mettre un curseur sur les pièces et d'afficher les possibilités des pièces sélectionnées.
 * @see <b>changeTeam<b>, <b>setCursor<b>, <b>piecePossibility<b>
 */

public class Game {
	
	public static ArrayList<JButton> piecesBlanches = new ArrayList<JButton>();
	public static ArrayList<JButton> piecesNoires = new ArrayList<JButton>();
	
	public static void gameEnd(String reason) {
		Chrono.timerNoir.stop();
		Chrono.timerBlanc.stop();
		JLabel label = new JLabel();
		label.setText(reason);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setBounds(50, 50, 300, 50);
		Main.fin.add(label);
		Main.fin.setVisible(true);
	}
	
	public static void changeTeam() {
		if(Main.team.equals("white")) {
				Main.team="black";
				Chrono.timerBlanc.stop();
				Chrono.timerNoir.start();
			}
			else {
				Main.team="white";
				Chrono.timerNoir.stop();
				Chrono.timerBlanc.start();
			}
		setCursor();
	}
	
	public static void setCursor() {
		if(Main.team.equals("white")) {
			for(int i=0;i<=15;i++) {
				piecesNoires.get(i).setCursor(null);
			}
			for(int i=0;i<=15;i++) {
				piecesBlanches.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
		if(Main.team.equals("black")) {
			for(int i=0;i<=15;i++) {
				piecesNoires.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			for(int i=0;i<=15;i++) {
				piecesBlanches.get(i).setCursor(null);
			}
		}
	}
	
	public static void piecePossibility(JButton piece) {
		
		JLabel possibility = null;
		
		
		int valeurPiece = Main.board[(piece.getY()-25)/75][(piece.getX()-200)/75];
		int x = piece.getX();
		int y = piece.getY();
		int l = (y-25)/75;
		int c = (x-200)/75;
		
		if(Display.buttonSelected!=null) {
			if(valeurPiece==1) {
			
				Movement.deplacementPionBlanc(x, y, l, c, possibility);
			}
			else if(valeurPiece==-1) {
				Movement.deplacementPionNoir(x, y, l, c, possibility);
			}
			else if(valeurPiece==2 || valeurPiece==-2) {
				
				Movement.deplacementCavalier(x,y,l,c,possibility);
			}
			else if(valeurPiece==3 || valeurPiece==-3) {

				Movement.deplacementDiag(x,y,l,c,possibility);
			}
			else if(valeurPiece==5 || valeurPiece==-5) {
				
				Movement.deplacementLigne(x,y,l,c,possibility);
			}
			else if(valeurPiece==9 || valeurPiece==-9) {
				
				Movement.deplacementDiag(x,y,l,c,possibility);
				Movement.deplacementLigne(x,y,l,c,possibility);
			}
			
			else if(valeurPiece==500 || valeurPiece==-500) {
				
				Movement.deplacementRoi(x,y,l,c,possibility);
			}
			
		}
		
	}

}
