package model;

public class Movement {
	
	private Model model;
	
	private String team;

	public Movement(Model model) {
		this.model = model;
	}
	
	public void displayPossibleKill(int l, int c) {
		possibility = Display.casePossibleKill();
		Piece.getButtonTarget(x,y).add(possibility);
	}
	
	public void displayPossibility(int x, int y) {
		JLabel possibility = Display.casePossible();
		possibility.setLocation(x,y);
		Main.panel.add(possibility);
	}
	
	public void deplacementPionBlanc(int l, int c, int[][] board) {
		if(l==6) {
			for(int i=1;i<=2;i++) {
		
				if(board[l-i][c]==0) {
					displayPossibility(l-i, c);
				}
				else {
					i=3;
				}
			}
		}
		else if(l>0 && board[l-1][c]==0){
			displayPossibility(l-1, c);
		}
		if(l>0) {
			if(c>0) {
				if(board[l-1][c-1]<0) {		
					displayPossibleKill(l-1, c-1);
		
				}
			}
			if(c<7) {
				if(board[l-1][c+1]<0) {			
					//possibility=Display.casePossibleKill();
					displayPossibleKill(l-1, c+1);
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
					displayPossibility(l+1,c);
				}
				else {
					i=3;
				}
		
			}
		}
		else if(l<7 && board[l+1][c]==0){
			displayPossibility(l+1, c);
		}
		if(l<7) {
			if(c>0) {
				if(board[l+1][c-1]>0) {
					displayPossibleKill(l+1, c-1);		
				}
			}	
			if(c<7) {
				if(board[l+1][c+1]>0) {
					//possibility=Display.casePossibleKill();
					displayPossibleKill(l+1, c+1);		
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
	
	public void deplacementDiag(int x, int y, int l, int c, JLabel possibility) {

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
	
	public void deplacementLigne(int x, int y, int l, int c, JLabel possibility) {
		
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
	
	public void deplacementCavalier(int x, int y, int l, int c, JLabel possibility) {
		
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
}
