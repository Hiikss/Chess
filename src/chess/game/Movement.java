package chess.game;

import javax.swing.JLabel;

import chess.Main;

import chess.Display;

public class Movement {
	
	public static void deplacementDiag(int valeurDisplay, int x, int y, int l, int c, JLabel possibility) {

		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				if(Main.team.equals("white") && Main.board[l-i][c-i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y-(75*i)).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l-i][c-i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y-(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l-i][c-i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-(75*i),y-(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				if(Main.team.equals("white") && Main.board[l+i][c-i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y+(75*i)).add(possibility);
					i=8;
				}
				else if (Main.team.equals("black") && Main.board[l+i][c-i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y+(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l+i][c-i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-(75*i),y+(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				if(Main.team.equals("white") && Main.board[l-i][c+i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y-(75*i)).add(possibility);
					i=8;
				}
				else if (Main.team.equals("black") && Main.board[l-i][c+i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y-(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l-i][c+i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+(75*i),y-(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				if(Main.team.equals("white") && Main.board[l+i][c+i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y+(75*i)).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l+i][c+i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y+(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l+i][c+i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+(75*i),y+(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
			
		}
		
	}
	
	public static void deplacementLigne(int valeurDisplay, int x, int y, int l, int c, JLabel possibility) {
		
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				if(Main.team.equals("white") && Main.board[l-i][c]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x,y-(75*i)).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l-i][c]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x,y-(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l-i][c]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x,y-(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				if(Main.team.equals("white") && Main.board[l+i][c]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x,y+(75*i)).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l+i][c]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x,y+(75*i)).add(possibility);
					i=8;
				}
				else if(Main.board[l+i][c]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x,y+(75*i));
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				if(Main.team.equals("white") && Main.board[l][c-i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l][c-i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-(75*i),y).add(possibility);
					i=8;
				}
				else if(Main.board[l][c-i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-(75*i),y);
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				if(Main.team.equals("white") && Main.board[l][c+i]<0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y).add(possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l][c+i]>0) {
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+(75*i),y).add(possibility);
					i=8;
				}
				else if(Main.board[l][c+i]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+(75*i),y);
					Main.panel.add(possibility);
				}
				else {
					i=8;
				}
				
			}
			
		}
	}
	
	public static void deplacementCavalier(int valeurDisplay, int x, int y, int l, int c, JLabel possibility) {
		
		if(l>0) {
			if(c>1) {
				if(Main.team.equals("white") && Main.board[l-1][c-2]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-150,y-75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c-2]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-150,y-75).add(possibility);
				}
				else if(Main.board[l-1][c-2]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-150,y-75);
					Main.panel.add(possibility);
				}
			}
			if(c<6) {
				if(Main.team.equals("white") && Main.board[l-1][c+2]<0) {		
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+150,y-75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c+2]>0) {		
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+150,y-75).add(possibility);
				}
				else if(Main.board[l-1][c+2]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+150,y-75);
					Main.panel.add(possibility);
				}					
			}
		}
		if(l>1) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l-2][c-1]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y-150).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-2][c-1]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y-150).add(possibility);
				}
				else if(Main.board[l-2][c-1]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-75,y-150);
					Main.panel.add(possibility);
				}
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l-2][c+1]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y-150).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-2][c+1]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y-150).add(possibility);
				}
				else if(Main.board[l-2][c+1]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+75,y-150);
					Main.panel.add(possibility);
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				if(Main.team.equals("white") && Main.board[l+1][c-2]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-150,y+75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c-2]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-150,y+75).add(possibility);
				}
				else if(Main.board[l+1][c-2]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-150,y+75);
					Main.panel.add(possibility);
				}
			}
			if(c<6) {
				if(Main.team.equals("white") && Main.board[l+1][c+2]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+150,y+75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c+2]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+150,y+75).add(possibility);
				}
				else if(Main.board[l+1][c+2]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+150,y+75);
					Main.panel.add(possibility);
				}
			}
		}
		if(l<6) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l+2][c-1]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y+150).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+2][c-1]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y+150).add(possibility);
				}
				else if(Main.board[l+2][c-1]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x-75,y+150);
					Main.panel.add(possibility);
				}			
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l+2][c+1]<0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y+150).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+2][c+1]>0) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y+150).add(possibility);
				}
				else if(Main.board[l+2][c+1]==0){
					possibility = Display.casePossible();
					possibility.setLocation(x+75,y+150);
					Main.panel.add(possibility);
				}				
			}
		}
	}
	
	public static void deplacementRoi(int valeurDisplay, int x, int y, int l, int c, JLabel possibility) {
		if(l>0) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l-1][c-1]<0 && Checked.isWhiteKingAttacked(-1, -1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y-75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c-1]>0  && Checked.isBlackKingAttacked(-1, -1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y-75).add(possibility);
				}
				else if(Main.board[l-1][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, -1)==false))){
					possibility = Display.casePossible();
					possibility.setLocation(x-75,y-75);
					Main.panel.add(possibility);
				}
				
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l-1][c+1]<0 && Checked.isWhiteKingAttacked(-1, 1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y-75).add(possibility);
					
				}
				else if(Main.team.equals("black") && Main.board[l-1][c+1]>0 && Checked.isBlackKingAttacked(-1, 1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y-75).add(possibility);
				}
				else if(Main.board[l-1][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, 1)==false))){
					possibility = Display.casePossible();
					possibility.setLocation(x+75,y-75);
					Main.panel.add(possibility);
				}
				
			}
			if(Main.team.equals("white") && Main.board[l-1][c]<0 && Checked.isWhiteKingAttacked(-1, 0)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x,y-75).add(possibility);
			}
			else if(Main.team.equals("black") && Main.board[l-1][c]>0 && Checked.isBlackKingAttacked(-1, 0)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x,y-75).add(possibility);
			}
			else if(Main.board[l-1][c]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, 0)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, 0)==false))){
				possibility = Display.casePossible();
				possibility.setLocation(x,y-75);
				Main.panel.add(possibility);
			}
			
		}
		if(l<7) {
			
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l+1][c-1]<0 && Checked.isWhiteKingAttacked(1, -1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y+75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c-1]>0 && Checked.isBlackKingAttacked(1, -1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x-75,y+75).add(possibility);
				}
				else if(Main.board[l+1][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, -1)==false))){
					possibility = Display.casePossible();
					possibility.setLocation(x-75,y+75);
					Main.panel.add(possibility);
				}
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l+1][c+1]<0 && Checked.isWhiteKingAttacked(1, 1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y+75).add(possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c+1]>0 && Checked.isBlackKingAttacked(1, 1)==false) {				
					possibility = Display.casePossibleKill();
					Piece.getButtonTarget(x+75,y+75).add(possibility);
				}
				else if(Main.board[l+1][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, 1)==false))){
					possibility = Display.casePossible();
					possibility.setLocation(x+75,y+75);
					Main.panel.add(possibility);
				}		
			}
			if(Main.team.equals("white") && Main.board[l+1][c]<0 && Checked.isWhiteKingAttacked(1, 0)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x,y+75).add(possibility);
			}
			else if(Main.team.equals("black") && Main.board[l+1][c]>0 && Checked.isBlackKingAttacked(1, 0)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x,y+75).add(possibility);
			}
			else if(Main.board[l+1][c]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, 0)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, 0)==false))){
				possibility = Display.casePossible();
				possibility.setLocation(x,y+75);
				Main.panel.add(possibility);
			}
		}
		if(c>0) {
			if(Main.team.equals("white") && Main.board[l][c-1]<0 && Checked.isWhiteKingAttacked(0, -1)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x-75,y).add(possibility);
			}
			else if(Main.team.equals("black") && Main.board[l][c-1]>0 && Checked.isBlackKingAttacked(0, -1)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x-75,y).add(possibility);
			}
			else if(Main.board[l][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(0, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(0, -1)==false))){
				possibility = Display.casePossible();
				possibility.setLocation(x-75,y);
				Main.panel.add(possibility);
			}
		}
		if(c<7) {
			if(Main.team.equals("white") && Main.board[l][c+1]<0 && Checked.isWhiteKingAttacked(0, 1)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x+75,y).add(possibility);
			}
			else if(Main.team.equals("black") && Main.board[l][c+1]>0 && Checked.isBlackKingAttacked(0, 1)==false) {				
				possibility = Display.casePossibleKill();
				Piece.getButtonTarget(x+75,y).add(possibility);
			}
			else if(Main.board[l][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(0, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(0, 1)==false))){
				possibility = Display.casePossible();
				possibility.setLocation(x+75,y);
				Main.panel.add(possibility);
			}
		}
		if(Main.team.equals("white") && Display.hasTA1Moved==false && Display.hasWhiteKingMoved==false && Main.board[7][1]==0 && Main.board[7][2]==0 && Main.board[7][3]==0 && Checked.isWhiteKingAttacked(0, 0)==false) {
			possibility = Display.casePossible();
			possibility.setLocation(x-150,y);
			Main.panel.add(possibility);
		}
		if(Main.team.equals("white") && Display.hasTH1Moved==false && Display.hasWhiteKingMoved==false && Main.board[7][5]==0 && Main.board[7][6]==0 && Checked.isWhiteKingAttacked(0, 0)==false) {
			possibility = Display.casePossible();
			possibility.setLocation(x+150,y);
			Main.panel.add(possibility);
		}
		if(Main.team.equals("black") && Display.hasTA8Moved==false && Display.hasBlackKingMoved==false && Main.board[0][1]==0 && Main.board[0][2]==0 && Main.board[0][3]==0 && Checked.isBlackKingAttacked(0,0)==false) {
			possibility = Display.casePossible();
			possibility.setLocation(x-150,y);
			Main.panel.add(possibility);
		}
		if(Main.team.equals("black") && Display.hasTH8Moved==false && Display.hasBlackKingMoved==false && Main.board[0][5]==0 && Main.board[0][6]==0 && Checked.isBlackKingAttacked(0,0)==false) {
			possibility = Display.casePossible();
			possibility.setLocation(x+150,y);
			Main.panel.add(possibility);
		}
	}
}
