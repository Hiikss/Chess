package chess;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import chess.game.Chrono;
import chess.game.Movement;
import chess.game.Piece;

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
			
				if(l==6) {
					for(int i=1;i<=2;i++) {
				
						if(Main.board[l-i][c]==0) {
							possibility=Display.casePossible();
							possibility.setLocation(x,y-(75*i));
							Main.panel.add(possibility);
						}
						else {
							i=3;
						}
					}
				}
				else if(l>0 && Main.board[l-1][c]==0){
					possibility=Display.casePossible();
					possibility.setLocation(x,y-75);
					Main.panel.add(possibility);
				}
				if(l>0) {
					if(c>0) {
						if(Main.board[l-1][c-1]<0) {				
							possibility=Display.casePossibleKill();
							Piece.getButtonTarget(x-75,y-75).add(possibility);
				
						}
					}
					if(c<7) {
						if(Main.board[l-1][c+1]<0) {			
							possibility=Display.casePossibleKill();
							Piece.getButtonTarget(x+75,y-75).add(possibility);
						}
					}
			
				}
				if(l==3) {
					Component[] components = Main.panel.getComponents();
		 			   for (Component component : components) {
		 				   if (component instanceof JButton) {
		 					   if(Display.pep.contains(component) && (component.getX()==x+75 || component.getX()==x-75)  && component.getY()==250) {
		 						  possibility=Display.casePossible();
		 							possibility.setLocation(component.getX(),175);
		 							Main.panel.add(possibility);
		 							Display.pepkill=true;
		 					   }
		 				   }
		 			   }
				}
			}
			else if(valeurPiece==-1) {
			
				if(l==1) {
					for(int i=1;i<=2;i++) {		
						if(Main.board[l+i][c]==0) {
							possibility=Display.casePossible();
							possibility.setLocation(x,y+(75*i));
							Main.panel.add(possibility);
						}
						else {
							i=3;
						}
				
					}
				}
				else if(l<7 && Main.board[l+1][c]==0){
					possibility=Display.casePossible();
					possibility.setLocation(x,y+75);
					Main.panel.add(possibility);
				}
				if(l<7) {
					if(c>0) {
						if(Main.board[l+1][c-1]>0) {		
							possibility=Display.casePossibleKill();
							Piece.getButtonTarget(x-75,y+75).add(possibility);			
						}
					}	
					if(c<7) {
						if(Main.board[l+1][c+1]>0) {
							possibility=Display.casePossibleKill();
							Piece.getButtonTarget(x+75,y+75).add(possibility);
						}
					}
			
				}
				if(l==4) {
					Component[] components = Main.panel.getComponents();
		 			   for (Component component : components) {
		 				   if (component instanceof JButton) {
		 					   if(Display.pep.contains(component) && (component.getX()==x+75 || component.getX()==x-75)  && component.getY()==325) {
		 						  possibility=Display.casePossible();
		 							possibility.setLocation(component.getX(),400);
		 							Main.panel.add(possibility);
		 							Display.pepkill=true;
		 					   }
		 				   }
		 			   }
				}
			
			}
			else if(valeurPiece==2 || valeurPiece==-2) {
				
				Movement.deplacementCavalier(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==3 || valeurPiece==-3) {

				Movement.deplacementDiag(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==5 || valeurPiece==-5) {
				
				Movement.deplacementLigne(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==9 || valeurPiece==-9) {
				
				Movement.deplacementDiag(valeurPiece,x,y,l,c,possibility);
				Movement.deplacementLigne(valeurPiece,x,y,l,c,possibility);
			}
			
			else if(valeurPiece==500 || valeurPiece==-500) {
				
				Movement.deplacementRoi(valeurPiece,x,y,l,c,possibility);
			}
			
		}
		
	}

}
