package model;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Movement {
	
	private Model model;
	
	private ImageIcon ipoint = new ImageIcon(Piece.class.getResource("/point.png"));
	
	private ImageIcon icercle = new ImageIcon(Piece.class.getResource("/cercle.png"));

	public Movement(Model model) {
		this.model = model;
	}
	
	public void createPossibilityKill(int l, int c) {
			int x = model.getX();
			int y = model.getY();
			int size = model.getSquareSize();
			JLabel possibility = new JLabel();
			possibility.setIcon(icercle);
			possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			possibility.addMouseListener(model.addKillLabelListener());
			possibility.setBounds(x+c*size, y+l*size, size, size);
			model.addComponent(possibility);
	}
	
	public void createPossibility(int l, int c) {
		int x = model.getX();
		int y = model.getY();
		int size = model.getSquareSize();
		JLabel possibility = new JLabel();
		possibility.setIcon(ipoint);
		possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		possibility.addMouseListener(model.addMoveLabelListener());
		possibility.setBounds(x+c*size, y+l*size, size, size);
		model.addComponent(possibility);
	}
	
	public void deplacementPionBlanc(int l, int c, int[][] board) {
		if(l==6) {
			for(int i=1;i<=2;i++) {
		
				if(board[l-i][c]==0) {
					createPossibility(l-i, c);
				}
				else {
					i=3;
				}
			}
		}
		else if(l>0 && board[l-1][c]==0){
			createPossibility(l-1, c);
		}
		if(l>0) {
			if(c>0) {
				if(board[l-1][c-1]<0) {		
					createPossibilityKill(l-1, c-1);
				}
			}
			if(c<7) {
				if(board[l-1][c+1]<0) {			
					createPossibilityKill(l-1, c+1);
				}
			}
	
		}
		/*if(l==3) {
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
		}*/
		
	}
	
	public void deplacementPionNoir(int l, int c, int[][] board) {
		
		if(l==1) {
			for(int i=1;i<=2;i++) {		
				if(board[l+i][c]==0) {
					createPossibility(l+i,c);
				}
				else {
					i=3;
				}
			}
		}
		else if(l<7 && board[l+1][c]==0){
			createPossibility(l+1, c);
		}
		if(l<7) {
			if(c>0) {
				if(board[l+1][c-1]>0) {
					createPossibilityKill(l+1, c-1);		
				}
			}	
			if(c<7) {
				if(board[l+1][c+1]>0) {
					createPossibilityKill(l+1, c+1);		
				}
			}
	
		}
		/*if(l==4) {
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
		}*/
		
	}
	
	public void deplacementDiag(int l, int c, int[][] board, String team) {

		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				if(team.equals("white") && board[l-i][c-i]<0) {
					createPossibilityKill(l-i, c-i);
					i=8;
				}
				else if(team.equals("black") && board[l-i][c-i]>0) {
					createPossibilityKill(l-i, c-i);
					i=8;
				}
				else if(board[l-i][c-i]==0){
					createPossibility(l-i, c-i);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				if(team.equals("white") && board[l+i][c-i]<0) {
					createPossibilityKill(l+i, c-i);
					i=8;
				}
				else if (team.equals("black") && board[l+i][c-i]>0) {
					createPossibilityKill(l+i, c-i);
					i=8;
				}
				else if(board[l+i][c-i]==0){
					createPossibility(l+i, c-i);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				if(team.equals("white") && board[l-i][c+i]<0) {
					createPossibilityKill(l-i, c+i);
					i=8;
				}
				else if (team.equals("black") && board[l-i][c+i]>0) {
					createPossibilityKill(l-i, c+i);
					i=8;
				}
				else if(board[l-i][c+i]==0){
					createPossibility(l-i, c+i);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				if(team.equals("white") && board[l+i][c+i]<0) {
					createPossibilityKill(l+i, c+i);
					i=8;
				}
				else if(team.equals("black") && board[l+i][c+i]>0) {
					createPossibilityKill(l+i, c+i);
					i=8;
				}
				else if(board[l+i][c+i]==0){
					createPossibility(l+i, c+i);
				}
				else {
					i=8;
				}
				
			}
			
		}
		
	}
	
	public void deplacementLigne(int l, int c, int[][] board, String team) {
		
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				if(team.equals("white") && board[l-i][c]<0) {
					createPossibilityKill(l-i, c);
					i=8;
				}
				else if(team.equals("black") && board[l-i][c]>0) {
					createPossibilityKill(l-i, c);
					i=8;
				}
				else if(board[l-i][c]==0){
					createPossibility(l-i, c);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				if(team.equals("white") && board[l+i][c]<0) {
					createPossibilityKill(l+i, c);
					i=8;
				}
				else if(team.equals("black") && board[l+i][c]>0) {
					createPossibilityKill(l+i, c);
					i=8;
				}
				else if(board[l+i][c]==0){
					createPossibility(l+i, c);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				if(team.equals("white") && board[l][c-i]<0) {
					createPossibilityKill(l, c-i);
					i=8;
				}
				else if(team.equals("black") && board[l][c-i]>0) {
					createPossibilityKill(l, c-i);
					i=8;
				}
				else if(board[l][c-i]==0){
					createPossibility(l, c-i);
				}
				else {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				if(team.equals("white") && board[l][c+i]<0) {
					createPossibilityKill(l, c+i);
					i=8;
				}
				else if(team.equals("black") && board[l][c+i]>0) {
					createPossibilityKill(l, c+i);
					i=8;
				}
				else if(board[l][c+i]==0){
					createPossibility(l, c+i);
				}
				else {
					i=8;
				}
				
			}
			
		}
	}
	
	public void deplacementCavalier(int l, int c, int[][] board, String team) {
		
		if(l>0) {
			if(c>1) {
				if(team.equals("white") && board[l-1][c-2]<0) {				
					createPossibilityKill(l-1, c-2);
				}
				else if(team.equals("black") && board[l-1][c-2]>0) {				
					createPossibilityKill(l-1, c-2);
				}
				else if(board[l-1][c-2]==0){
					createPossibility(l-1, c-2);
				}
			}
			if(c<6) {
				if(team.equals("white") && board[l-1][c+2]<0) {		
					createPossibilityKill(l-1, c+2);
				}
				else if(team.equals("black") && board[l-1][c+2]>0) {		
					createPossibilityKill(l-1, c+2);
				}
				else if(board[l-1][c+2]==0){
					createPossibility(l-1, c+2);
				}					
			}
		}
		if(l>1) {
			if(c>0) {
				if(team.equals("white") && board[l-2][c-1]<0) {				
					createPossibilityKill(l-2, c-1);
				}
				else if(team.equals("black") && board[l-2][c-1]>0) {				
					createPossibilityKill(l-2, c-1);
				}
				else if(board[l-2][c-1]==0){
					createPossibility(l-2, c-1);
				}
			}
			if(c<7) {
				if(team.equals("white") && board[l-2][c+1]<0) {				
					createPossibilityKill(l-2, c+1);
				}
				else if(team.equals("black") && board[l-2][c+1]>0) {				
					createPossibilityKill(l-2, c+1);
				}
				else if(board[l-2][c+1]==0){
					createPossibility(l-2, c+1);
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				if(team.equals("white") && board[l+1][c-2]<0) {				
					createPossibilityKill(l+1, c-2);
				}
				else if(team.equals("black") && board[l+1][c-2]>0) {				
					createPossibilityKill(l+1, c-2);
				}
				else if(board[l+1][c-2]==0){
					createPossibility(l+1, c-2);
				}
			}
			if(c<6) {
				if(team.equals("white") && board[l+1][c+2]<0) {				
					createPossibilityKill(l+1, c+2);
				}
				else if(team.equals("black") && board[l+1][c+2]>0) {				
					createPossibilityKill(l+1, c+2);
				}
				else if(board[l+1][c+2]==0){
					createPossibility(l+1, c+2);
				}
			}
		}
		if(l<6) {
			if(c>0) {
				if(team.equals("white") && board[l+2][c-1]<0) {				
					createPossibilityKill(l+2, c-1);
				}
				else if(team.equals("black") && board[l+2][c-1]>0) {				
					createPossibilityKill(l+2, c-1);
				}
				else if(board[l+2][c-1]==0){
					createPossibility(l+2, c-1);
				}			
			}
			if(c<7) {
				if(team.equals("white") && board[l+2][c+1]<0) {				
					createPossibilityKill(l+2, c+1);
				}
				else if(team.equals("black") && board[l+2][c+1]>0) {				
					createPossibilityKill(l+2, c+1);
				}
				else if(board[l+2][c+1]==0){
					createPossibility(l+2, c+1);
				}				
			}
		}
	}
}
