package model;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.Display;

/** 
 * La classe <b>Movement</b> appartient au package <b>model</b>.
 * Elle comprend 8 méthodes relatives aux différents types de déplacements et d'affichages de deéplacements.
 * @see <b>displayPossibleKill<b>, <b>displayPossibility<b>
 * @see <b>deplacementPionBlanc<b>, <b>deplacementPionNoir<b>, <b>deplacementDiag<b>, <b>deplacementLigne<b>,  <b>deplacementCavalier<b>, <b>deplacementRoi<b>,
 */

public class Movement {
	
	public static void displayPossibleKill(int x, int y, JLabel possibility) {
		possibility = Display.casePossibleKill();
		Piece.getButtonTarget(x,y).add(possibility);
	}
	
	public static void displayPossibility(int x, int y, JLabel possibility) {
		possibility = Display.casePossible();
		possibility.setLocation(x,y);
		Main.panel.add(possibility);
	}
	
	public static void deplacementPionBlanc(int x, int y, int l, int c, JLabel possibility) {
		
		if(l==6) {
			for(int i=1;i<=2;i++) {
		
				if(Main.board[l-i][c]==0) {
					displayPossibility(x,y-(75*i),possibility);
				}
				else {
					i=3;
				}
			}
		}
		else if(l>0 && Main.board[l-1][c]==0){
			displayPossibility(x,y-75,possibility);
		}
		if(l>0) {
			if(c>0) {
				if(Main.board[l-1][c-1]<0) {		
					displayPossibleKill(x-75,y-75, possibility);
		
				}
			}
			if(c<7) {
				if(Main.board[l-1][c+1]<0) {			
					possibility=Display.casePossibleKill();
					displayPossibleKill(x+75,y-75, possibility);
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
	
	public static void deplacementPionNoir(int x, int y, int l, int c, JLabel possibility) {
		
		if(l==1) {
			for(int i=1;i<=2;i++) {		
				if(Main.board[l+i][c]==0) {
					displayPossibility(x,y+(75*i),possibility);
				}
				else {
					i=3;
				}
		
			}
		}
		else if(l<7 && Main.board[l+1][c]==0){
			displayPossibility(x,y+75,possibility);
		}
		if(l<7) {
			if(c>0) {
				if(Main.board[l+1][c-1]>0) {
					displayPossibleKill(x-75,y+75,possibility);		
				}
			}	
			if(c<7) {
				if(Main.board[l+1][c+1]>0) {
					possibility=Display.casePossibleKill();
					displayPossibleKill(x+75,y+75,possibility);		
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
	
	public static void deplacementDiag(int x, int y, int l, int c, JLabel possibility) {

		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				if(Main.team.equals("white") && Main.board[l-i][c-i]<0) {
					displayPossibleKill(x-(75*i),y-(75*i), possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l-i][c-i]>0) {
					displayPossibleKill(x-(75*i),y-(75*i), possibility);
					i=8;
				}
				else if(Main.board[l-i][c-i]==0){
					displayPossibility(x-(75*i),y-(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				if(Main.team.equals("white") && Main.board[l+i][c-i]<0) {
					displayPossibleKill(x-(75*i),y+(75*i), possibility);
					i=8;
				}
				else if (Main.team.equals("black") && Main.board[l+i][c-i]>0) {
					displayPossibleKill(x-(75*i),y+(75*i), possibility);
					i=8;
				}
				else if(Main.board[l+i][c-i]==0){
					displayPossibility(x-(75*i),y+(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				if(Main.team.equals("white") && Main.board[l-i][c+i]<0) {
					displayPossibleKill(x+(75*i),y-(75*i), possibility);
					i=8;
				}
				else if (Main.team.equals("black") && Main.board[l-i][c+i]>0) {
					displayPossibleKill(x+(75*i),y-(75*i), possibility);
					i=8;
				}
				else if(Main.board[l-i][c+i]==0){
					displayPossibility(x+(75*i),y-(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				if(Main.team.equals("white") && Main.board[l+i][c+i]<0) {
					displayPossibleKill(x+(75*i),y+(75*i), possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l+i][c+i]>0) {
					displayPossibleKill(x+(75*i),y+(75*i), possibility);
					i=8;
				}
				else if(Main.board[l+i][c+i]==0){
					displayPossibility(x+(75*i),y+(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
			
		}
		
	}
	
	public static void deplacementLigne(int x, int y, int l, int c, JLabel possibility) {
		
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				if(Main.team.equals("white") && Main.board[l-i][c]<0) {
					displayPossibleKill(x,y-(75*i), possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l-i][c]>0) {
					displayPossibleKill(x,y-(75*i), possibility);
					i=8;
				}
				else if(Main.board[l-i][c]==0){
					displayPossibility(x,y-(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				if(Main.team.equals("white") && Main.board[l+i][c]<0) {
					displayPossibleKill(x,y+(75*i), possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l+i][c]>0) {
					displayPossibleKill(x,y+(75*i), possibility);
					i=8;
				}
				else if(Main.board[l+i][c]==0){
					displayPossibility(x,y+(75*i), possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				if(Main.team.equals("white") && Main.board[l][c-i]<0) {
					displayPossibleKill(x-(75*i),y, possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l][c-i]>0) {
					displayPossibleKill(x-(75*i),y, possibility);
					i=8;
				}
				else if(Main.board[l][c-i]==0){
					displayPossibility(x-(75*i),y, possibility);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				if(Main.team.equals("white") && Main.board[l][c+i]<0) {
					displayPossibleKill(x+(75*i),y, possibility);
					i=8;
				}
				else if(Main.team.equals("black") && Main.board[l][c+i]>0) {
					displayPossibleKill(x+(75*i),y, possibility);
					i=8;
				}
				else if(Main.board[l][c+i]==0){
					displayPossibility(x+(75*i),y, possibility);
				}
				else {
					i=8;
				}
				
			}
			
		}
	}
	
	public static void deplacementCavalier(int x, int y, int l, int c, JLabel possibility) {
		
		if(l>0) {
			if(c>1) {
				if(Main.team.equals("white") && Main.board[l-1][c-2]<0) {				
					displayPossibleKill(x-150,y-75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c-2]>0) {				
					displayPossibleKill(x-150,y-75, possibility);
				}
				else if(Main.board[l-1][c-2]==0){
					displayPossibility(x-150,y-75, possibility);
				}
			}
			if(c<6) {
				if(Main.team.equals("white") && Main.board[l-1][c+2]<0) {		
					displayPossibleKill(x+150,y-75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c+2]>0) {		
					displayPossibleKill(x+150,y-75, possibility);
				}
				else if(Main.board[l-1][c+2]==0){
					displayPossibility(x+150,y-75, possibility);
				}					
			}
		}
		if(l>1) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l-2][c-1]<0) {				
					displayPossibleKill(x-75,y-150, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-2][c-1]>0) {				
					displayPossibleKill(x-75,y-150, possibility);
				}
				else if(Main.board[l-2][c-1]==0){
					displayPossibility(x-75,y-150, possibility);
				}
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l-2][c+1]<0) {				
					displayPossibleKill(x+75,y-150, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-2][c+1]>0) {				
					displayPossibleKill(x+75,y-150, possibility);
				}
				else if(Main.board[l-2][c+1]==0){
					displayPossibility(x+75,y-150, possibility);
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				if(Main.team.equals("white") && Main.board[l+1][c-2]<0) {				
					displayPossibleKill(x-150,y+75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c-2]>0) {				
					displayPossibleKill(x-150,y+75, possibility);
				}
				else if(Main.board[l+1][c-2]==0){
					displayPossibility(x-150,y+75, possibility);
				}
			}
			if(c<6) {
				if(Main.team.equals("white") && Main.board[l+1][c+2]<0) {				
					displayPossibleKill(x+150,y+75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c+2]>0) {				
					displayPossibleKill(x+150,y+75, possibility);
				}
				else if(Main.board[l+1][c+2]==0){
					displayPossibility(x+150,y+75, possibility);
				}
			}
		}
		if(l<6) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l+2][c-1]<0) {				
					displayPossibleKill(x-75,y+150, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+2][c-1]>0) {				
					displayPossibleKill(x-75,y+150, possibility);
				}
				else if(Main.board[l+2][c-1]==0){
					displayPossibility(x-75,y+150, possibility);
				}			
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l+2][c+1]<0) {				
					displayPossibleKill(x+75,y+150, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+2][c+1]>0) {				
					displayPossibleKill(x+75,y+150, possibility);
				}
				else if(Main.board[l+2][c+1]==0){
					displayPossibility(x+75,y+150, possibility);
				}				
			}
		}
	}
	
	public static void deplacementRoi(int x, int y, int l, int c, JLabel possibility) {
		if(l>0) {
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l-1][c-1]<0 && Checked.isWhiteKingAttacked(-1, -1)==false) {				
					displayPossibleKill(x-75,y-75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l-1][c-1]>0  && Checked.isBlackKingAttacked(-1, -1)==false) {				
					displayPossibleKill(x-75,y-75, possibility);
				}
				else if(Main.board[l-1][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, -1)==false))){
					displayPossibility(x-75,y-75, possibility);
				}
				
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l-1][c+1]<0 && Checked.isWhiteKingAttacked(-1, 1)==false) {				
					displayPossibleKill(x+75,y-75, possibility);					
				}
				else if(Main.team.equals("black") && Main.board[l-1][c+1]>0 && Checked.isBlackKingAttacked(-1, 1)==false) {				
					displayPossibleKill(x+75,y-75, possibility);
				}
				else if(Main.board[l-1][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, 1)==false))){
					displayPossibility(x+75,y-75, possibility);
				}
				
			}
			if(Main.team.equals("white") && Main.board[l-1][c]<0 && Checked.isWhiteKingAttacked(-1, 0)==false) {				
				displayPossibleKill(x,y-75, possibility);
			}
			else if(Main.team.equals("black") && Main.board[l-1][c]>0 && Checked.isBlackKingAttacked(-1, 0)==false) {				
				displayPossibleKill(x,y-75, possibility);
			}
			else if(Main.board[l-1][c]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(-1, 0)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(-1, 0)==false))){
				displayPossibility(x,y-75, possibility);
			}
			
		}
		if(l<7) {
			
			if(c>0) {
				if(Main.team.equals("white") && Main.board[l+1][c-1]<0 && Checked.isWhiteKingAttacked(1, -1)==false) {				
					displayPossibleKill(x-75,y+75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c-1]>0 && Checked.isBlackKingAttacked(1, -1)==false) {				
					displayPossibleKill(x-75,y+75, possibility);
				}
				else if(Main.board[l+1][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, -1)==false))){
					displayPossibility(x-75,y+75, possibility);
				}
			}
			if(c<7) {
				if(Main.team.equals("white") && Main.board[l+1][c+1]<0 && Checked.isWhiteKingAttacked(1, 1)==false) {				
					displayPossibleKill(x+75,y+75, possibility);
				}
				else if(Main.team.equals("black") && Main.board[l+1][c+1]>0 && Checked.isBlackKingAttacked(1, 1)==false) {				
					displayPossibleKill(x+75,y+75, possibility);
				}
				else if(Main.board[l+1][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, 1)==false))){
					displayPossibility(x+75,y+75, possibility);
				}		
			}
			if(Main.team.equals("white") && Main.board[l+1][c]<0 && Checked.isWhiteKingAttacked(1, 0)==false) {				
				displayPossibleKill(x,y+75, possibility);
			}
			else if(Main.team.equals("black") && Main.board[l+1][c]>0 && Checked.isBlackKingAttacked(1, 0)==false) {				
				displayPossibleKill(x,y+75, possibility);
			}
			else if(Main.board[l+1][c]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(1, 0)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(1, 0)==false))){
				displayPossibility(x,y+75, possibility);
			}
		}
		if(c>0) {
			if(Main.team.equals("white") && Main.board[l][c-1]<0 && Checked.isWhiteKingAttacked(0, -1)==false) {				
				displayPossibleKill(x-75,y, possibility);
			}
			else if(Main.team.equals("black") && Main.board[l][c-1]>0 && Checked.isBlackKingAttacked(0, -1)==false) {				
				displayPossibleKill(x-75,y, possibility);
			}
			else if(Main.board[l][c-1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(0, -1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(0, -1)==false))){
				displayPossibility(x-75,y, possibility);
			}
		}
		if(c<7) {
			if(Main.team.equals("white") && Main.board[l][c+1]<0 && Checked.isWhiteKingAttacked(0, 1)==false) {				
				displayPossibleKill(x+75,y, possibility);
			}
			else if(Main.team.equals("black") && Main.board[l][c+1]>0 && Checked.isBlackKingAttacked(0, 1)==false) {				
				displayPossibleKill(x+75,y, possibility);
			}
			else if(Main.board[l][c+1]==0 && ((Main.team.equals("white") && Checked.isWhiteKingAttacked(0, 1)==false) || (Main.team.equals("black") && Checked.isBlackKingAttacked(0, 1)==false))){
				displayPossibility(x+75,y, possibility);
			}
		}
		if(Main.team.equals("white") && Display.hasTA1Moved==false && Display.hasWhiteKingMoved==false && Main.board[7][1]==0 && Main.board[7][2]==0 && Main.board[7][3]==0 && Checked.isWhiteKingAttacked(0, 0)==false) {
			displayPossibility(x-150,y, possibility);
		}
		if(Main.team.equals("white") && Display.hasTH1Moved==false && Display.hasWhiteKingMoved==false && Main.board[7][5]==0 && Main.board[7][6]==0 && Checked.isWhiteKingAttacked(0, 0)==false) {
			displayPossibility(x+150,y, possibility);
		}
		if(Main.team.equals("black") && Display.hasTA8Moved==false && Display.hasBlackKingMoved==false && Main.board[0][1]==0 && Main.board[0][2]==0 && Main.board[0][3]==0 && Checked.isBlackKingAttacked(0,0)==false) {
			displayPossibility(x-150,y, possibility);
		}
		if(Main.team.equals("black") && Display.hasTH8Moved==false && Display.hasBlackKingMoved==false && Main.board[0][5]==0 && Main.board[0][6]==0 && Checked.isBlackKingAttacked(0,0)==false) {
			displayPossibility(x+150,y, possibility);
		}
	}
}
