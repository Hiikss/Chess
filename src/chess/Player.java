package chess;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

import chess.game.Chrono;
import chess.game.Piece;
import chess.utils.Event;

public class Player {
	
	private static int [][] board = Main.board;
	
	
	
	public static void initBoard() {
		JButton piece;
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = board[l][c];
				
				if(value!=0) {
					piece = Piece.createPieceButton();
					piece.setBounds(200+75*c, 25+75*l, 75, 75);
					piece.setLayout(null);
					piece.setIcon(Piece.valueToPieceIcon(value));
					piece.setContentAreaFilled(false);
					piece.setBorderPainted(false);
					piece.addActionListener(Event.btnclicked);
					if((l==7 || l==6) && Main.team.equals("white")) {
						piece.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					else if((l==0 || l==1) && Main.team.equals("black")) {
						piece.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					Main.panel.add(piece);
				}
			}
		}
		Chrono.timerBlancLabel.setText("10:00");
		Chrono.timerBlancLabel.setBounds(75, 575, 100, 30);
		Chrono.timerBlancLabel.setFont(new Font("Arial",Font.PLAIN,29));
		Chrono.msBlanc = 0;
		Chrono.secondBlanc = 0;
		Chrono.minuteBlanc = 10;
		Main.panel.add(Chrono.timerBlancLabel);
		
		Chrono.timerNoirLabel.setText("10:00");
		Chrono.timerNoirLabel.setBounds(75, 50, 100, 30);
		Chrono.timerNoirLabel.setFont(new Font("Arial",Font.PLAIN,29));
		Chrono.msNoir = 0;
		Chrono.secondNoir = 0;
		Chrono.minuteNoir = 10;
		Chrono.countdownTimer();
		Main.panel.add(Chrono.timerNoirLabel);

	}

}
