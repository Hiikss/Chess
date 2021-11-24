package chess;

import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import chess.game.Chrono;

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

}
