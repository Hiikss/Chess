package chess.game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import chess.Main;
import chess.utils.Event;

public class Case
{

	private static int [][] board = Main.board;
	
	public static JButton buttonSelected=null;
	
	public static JLabel timerBlancLabel = new JLabel();
	public static JLabel timerNoirLabel = new JLabel();
	
	public static Timer timerBlanc;	
	public static Timer timerNoir;	
	public static int secondBlanc, minuteBlanc, secondNoir, minuteNoir, msBlanc, msNoir;
	public static String ddSecondBlanc, ddMinuteBlanc, ddSecondNoir, ddMinuteNoir;	
	public static DecimalFormat dFormat = new DecimalFormat("00");
	
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
		timerBlancLabel.setText("10:00");
		timerBlancLabel.setBounds(75, 575, 100, 30);
		timerBlancLabel.setFont(new Font("Arial",Font.PLAIN,29));
		msBlanc = 0;
		secondBlanc = 0;
		minuteBlanc = 10;
		Main.panel.add(timerBlancLabel);
		
		timerNoirLabel.setText("10:00");
		timerNoirLabel.setBounds(75, 50, 100, 30);
		timerNoirLabel.setFont(new Font("Arial",Font.PLAIN,29));
		msNoir = 0;
		secondNoir = 0;
		minuteNoir = 10;
		countdownTimer();
		Main.panel.add(timerNoirLabel);

	}
	
	public static void displayPossibilty(JButton piece) {
		int pieceValue = Main.board[(piece.getY()-25)/75][(piece.getX()-200)/75];
		Piece.clearPossibility();
		if((Main.team.equals("white")&& pieceValue>0) || (Main.team.equals("black")&& pieceValue<0)) {
			if(buttonSelected!=null) {
				buttonSelected.setBackground(null);
				buttonSelected.setOpaque(false);
				if(buttonSelected!=piece) {
					piece.setBackground(Color.decode("#348339"));
					buttonSelected = piece;
					piece.setOpaque(true);
				}
				else {
					buttonSelected = null;
				}
			
			}
			else {
				piece.setBackground(Color.decode("#348339"));
				buttonSelected = piece;
				piece.setOpaque(true);
			}
			Piece.piecePossibility(piece);
		
	}
		Main.panel.repaint();
		Main.panel.revalidate();
		
	}
	
public static void countdownTimer() {
		
	timerBlanc = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				msBlanc--;
				
				if(msBlanc==-1) {
					msBlanc = 59;
					secondBlanc--;
					ddSecondBlanc = dFormat.format(secondBlanc);
					ddMinuteBlanc = dFormat.format(minuteBlanc);	
					timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc);
				}
				if(secondBlanc==-1) {
					secondBlanc = 59;
					minuteBlanc--;
					ddSecondBlanc = dFormat.format(secondBlanc);
					ddMinuteBlanc = dFormat.format(minuteBlanc);	
					timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc);
				}
				if(minuteBlanc==0 && secondBlanc==0 && msBlanc==0) {
					gameEnd("Victoire des Noirs au temps");
				}
			}
		});	
	
	timerNoir = new Timer(10, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			msNoir--;
			
			if(msNoir==-1) {
				msNoir = 59;
				secondNoir--;
				ddSecondNoir = dFormat.format(secondNoir);
				ddMinuteNoir = dFormat.format(minuteNoir);	
				timerNoirLabel.setText(ddMinuteNoir + ":" + ddSecondNoir);
			}
			
			if(secondNoir==-1) {
				secondNoir = 59;
				minuteNoir--;
				ddSecondNoir = dFormat.format(secondNoir);
				ddMinuteNoir = dFormat.format(minuteNoir);	
				timerNoirLabel.setText(ddMinuteNoir + ":" + ddSecondNoir);
			}
			if(minuteNoir==0 && secondNoir==0 && msNoir==0) {
				gameEnd("Victoire des Blancs au temps");
			}
		}
	});	
	}

	public static void gameEnd(String reason) {
		timerNoir.stop();
		timerBlanc.stop();
		JLabel label = new JLabel();
		label.setText(reason);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setBounds(50, 50, 300, 50);
		Main.fin.add(label);
		Main.fin.setVisible(true);
	}
}
