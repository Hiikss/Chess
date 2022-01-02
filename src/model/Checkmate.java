package model;

import java.util.ArrayList;

import javax.swing.JButton;

/** 
 * La classe <b>Checkmate</b> appartient au package <b>model</b>.
 * Elle comprend 2 méthodes vérifiant si un roi est en échec et mat
 * @see <b>isWhiteKingCheckmate<b>, <b>isBlackKingCheckmate<b>
 */

public class Checkmate {

	public static boolean isWhiteKingCheckmate(ArrayList<JButton> pieces) {
		
		ArrayList<JButton> piecesCanBeKilled = new ArrayList<JButton>();
		boolean canWhiteKingMove = false;
		for(int j=0; j<pieces.size(); j++) {
			JButton btn = pieces.get(j);
			int l = (btn.getY()-25)/75;
			int c = (btn.getX()-200)/75;
			for(int i=1;i<=7;i++) {
				if(l-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c]==9 || Main.board[l-i][c]==5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c]<0 || (Main.board[l-i][c]>0 && Main.board[l-i][c]!=9 && Main.board[l-i][c]!=5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					else if(Main.board[l+i][c]==9 || Main.board[l+i][c]==5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c]<0 || (Main.board[l+i][c]>0 && Main.board[l+i][c]!=9 && Main.board[l+i][c]!=5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l][c-i]==9 || Main.board[l][c-i]==5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l][c-i]<0 || (Main.board[l][c-i]>0 && Main.board[l][c-i]!=9 && Main.board[l][c-i]!=5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l][c+i]==9 || Main.board[l][c+i]==5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l][c+i]<0 || (Main.board[l][c+i]>0 && Main.board[l][c+i]!=9 && Main.board[l][c+i]!=5)) {
						i=8;
					}
				}	
			}
			for(int i=1;i<=7;i++) {
				if(l-i>=0 && c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c-i]==9 || Main.board[l-i][c-i]==3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c-i]<0 || (Main.board[l-i][c-i]>0 && Main.board[l-i][c-i]!=9 && Main.board[l-i][c-i]!=3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7 && c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l+i][c-i]==9 || Main.board[l+i][c-i]==3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c-i]<0 || (Main.board[l+i][c-i]>0 && Main.board[l+i][c-i]!=9 && Main.board[l+i][c-i]!=3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l-i>=0 && c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c+i]==9 || Main.board[l-i][c+i]==3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c+i]<0 || (Main.board[l-i][c+i]>0 && Main.board[l-i][c+i]!=9 && Main.board[l-i][c+i]!=3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7 && c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l+i][c+i]==9 || Main.board[l+i][c+i]==3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c+i]<0 || (Main.board[l+i][c+i]>0 && Main.board[l+i][c+i]!=9 && Main.board[l+i][c+i]!=3)) {
						i=8;
					}
				}
			}
			if(l>0 && !piecesCanBeKilled.contains(btn)) {
				if(c>1) {
					if(Main.board[l-1][c-2]==2 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<6) {
					if(Main.board[l-1][c+2]==2 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
				}
				if(c>0) {
					if(Main.board[l-1][c-1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(1, 1)==false) {				
						piecesCanBeKilled.add(btn);
					}
				}	
				if(c<7) {
					if(Main.board[l-1][c+1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(1, -1)==false) {				
						piecesCanBeKilled.add(btn);
					}
				}
				if(Main.board[l-1][c]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(1, 0)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(l>1 && !piecesCanBeKilled.contains(btn)) {
				if(c>0) {
					if(Main.board[l-2][c-1]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<7) {
					if(Main.board[l-2][c+1]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}			
				}
			}
			if(l<7 && !piecesCanBeKilled.contains(btn)) {
				if(c>1) {
					if(Main.board[l+1][c-2]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<6) {
					if(Main.board[l+1][c+2]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c>0) {
					if(Main.board[l+1][c-1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(-1, 1)==false) {				
						piecesCanBeKilled.add(btn);
					}
					if(Main.board[l+1][c-1]==1 && !piecesCanBeKilled.contains(btn)) {		
						piecesCanBeKilled.add(btn);		
					}
				}
				if(c<7) {
					if(Main.board[l+1][c+1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(-1, -1)==false) {				
						piecesCanBeKilled.add(btn);
					}
					if(Main.board[l+1][c+1]==1 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
				}
				if(Main.board[l+1][c]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(-1, 0)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(l<6 && !piecesCanBeKilled.contains(btn)) {
				if(c>0) {
					if(Main.board[l+2][c-1]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<7) {
					if(Main.board[l+2][c+1]==2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}			
				}
			}
			if(c>0 && !piecesCanBeKilled.contains(btn)) {
				if(Main.board[l][c-1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(0, 1)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(c<7) {
				if(Main.board[l][c+1]==500 && !piecesCanBeKilled.contains(btn) && Checked.isWhiteKingAttacked(0, -1)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
		}
		
		int l = (Piece.b28.getY()-25)/75;
		int c = (Piece.b28.getX()-200)/75;
		if(l>0) {
			if(c>0) {
				if(Main.board[l-1][c-1]<=0 && Checked.isWhiteKingAttacked(-1, -1)==false) {	
					canWhiteKingMove = true;
				}
			}
			if(c<7) {
				if(Main.board[l-1][c+1]<=0 && Checked.isWhiteKingAttacked(-1, 1)==false) {		
					canWhiteKingMove = true;
				}
			}
			if(Main.board[l-1][c]<=0 && Checked.isWhiteKingAttacked(-1, 0)==false) {	
				canWhiteKingMove = true;
			}
		}
		if(l<7) {
			
			if(c>0) {
				if(Main.board[l+1][c-1]<=0 && Checked.isWhiteKingAttacked(1, -1)==false) {	
					canWhiteKingMove = true;
				}
			}
			if(c<7) {
				if(Main.board[l+1][c+1]<=0 && Checked.isWhiteKingAttacked(1, 1)==false) {
					canWhiteKingMove = true;
				}	
			}
			if(Main.board[l+1][c]<=0 && Checked.isWhiteKingAttacked(1, 0)==false) {
				canWhiteKingMove = true;
			}
		}
		if(c>0) {
			if(Main.board[l][c-1]<=0 && Checked.isWhiteKingAttacked(0, -1)==false) {
				canWhiteKingMove = true;
			}
		}
		if(c<7) {
			if(Main.board[l][c+1]<=0 && Checked.isWhiteKingAttacked(0, 1)==false) {	
				canWhiteKingMove = true;
			}
		}
		
		if(piecesCanBeKilled.size()==0 && canWhiteKingMove==false) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean isBlackKingCheckmate(ArrayList<JButton> pieces) {
		
		ArrayList<JButton> piecesCanBeKilled = new ArrayList<JButton>();
		boolean canBlackKingMove = false;
		for(int j=0; j<pieces.size(); j++) {
			JButton btn = pieces.get(j);
			int l = (btn.getY()-25)/75;
			int c = (btn.getX()-200)/75;
			for(int i=1;i<=7;i++) {
				if(l-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c]==-9 || Main.board[l-i][c]==-5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c]>0 || (Main.board[l-i][c]<0 && Main.board[l-i][c]!=-9 && Main.board[l-i][c]!=-5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					else if(Main.board[l+i][c]==-9 || Main.board[l+i][c]==-5) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c]>0  || (Main.board[l+i][c]<0 && Main.board[l+i][c]!=-9 && Main.board[l+i][c]!=-5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l][c-i]==-9 || Main.board[l][c-i]==-5) {
						piecesCanBeKilled.add(btn);
						System.out.println("tour");
					}
					else if(Main.board[l][c-i]>0 || (Main.board[l][c-i]<0 && Main.board[l][c-i]!=-9 && Main.board[l][c-i]!=-5)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l][c+i]==-9 || Main.board[l][c+i]==-5) {
						piecesCanBeKilled.add(btn);
						System.out.println("tour");
					}
					else if(Main.board[l][c+i]>0 || (Main.board[l][c+i]<0 && Main.board[l][c+i]!=-9 && Main.board[l][c+i]!=-5)) {
						i=8;
					}
				}	
			}
			for(int i=1;i<=7;i++) {
				if(l-i>=0 && c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c-i]==-9 || Main.board[l-i][c-i]==-3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c-i]>0 || (Main.board[l-i][c-i]<0 && Main.board[l-i][c-i]!=-9 && Main.board[l-i][c-i]!=-3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7 && c-i>=0) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l+i][c-i]==-9 || Main.board[l+i][c-i]==-3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c-i]>0 || (Main.board[l+i][c-i]<0 && Main.board[l+i][c-i]!=-9 && Main.board[l+i][c-i]!=-3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l-i>=0 && c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l-i][c+i]==-9 || Main.board[l-i][c+i]==-3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l-i][c+i]>0 || (Main.board[l-i][c+i]<0 && Main.board[l-i][c+i]!=-9 && Main.board[l-i][c+i]!=-3)) {
						i=8;
					}
				}
			}
			for(int i=1;i<=7;i++) {
				if(l+i<=7 && c+i<=7) {
					if(piecesCanBeKilled.contains(btn)) {
						break;
					}
					if(Main.board[l+i][c+i]==-9 || Main.board[l+i][c+i]==-3) {
						piecesCanBeKilled.add(btn);
					}
					else if(Main.board[l+i][c+i]>0 || (Main.board[l+i][c+i]<0 && Main.board[l+i][c+i]!=-9 && Main.board[l+i][c+i]!=-3)) {
						i=8;
					}
				}
			}
			if(l>0 && !piecesCanBeKilled.contains(btn)) {
				if(c>1) {
					if(Main.board[l-1][c-2]==-2 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<6) {
					if(Main.board[l-1][c+2]==-2 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
				}
				if(c>0) {
					if(Main.board[l-1][c-1]==-1 && !piecesCanBeKilled.contains(btn)) {		
						piecesCanBeKilled.add(btn);
					}
					if(Main.board[l-1][c-1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(1, 1)==false) {				
						piecesCanBeKilled.add(btn);
					}
				}	
				if(c<7) {
					if(Main.board[l-1][c+1]==-1 && !piecesCanBeKilled.contains(btn)) {
						piecesCanBeKilled.add(btn);
					}
					if(Main.board[l-1][c+1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(1, -1)==false) {				
						piecesCanBeKilled.add(btn);
					}
				}
				if(Main.board[l-1][c]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(1, 0)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(l>1 && !piecesCanBeKilled.contains(btn)) {
				if(c>0) {
					if(Main.board[l-2][c-1]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<7) {
					if(Main.board[l-2][c+1]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}			
				}
			}
			if(l<7 && !piecesCanBeKilled.contains(btn)) {
				if(c>1) {
					if(Main.board[l+1][c-2]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<6) {
					if(Main.board[l+1][c+2]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c>0) {
					if(Main.board[l+1][c-1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(-1, 1)==false) {				
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<7) {
					if(Main.board[l+1][c+1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(-1, -1)==false) {				
						piecesCanBeKilled.add(btn);
					}	
				}
				if(Main.board[l+1][c]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(-1, 0)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(l<6 && !piecesCanBeKilled.contains(btn)) {
				if(c>0) {
					if(Main.board[l+2][c-1]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}
				}
				if(c<7) {
					if(Main.board[l+2][c+1]==-2 && !piecesCanBeKilled.contains(btn)) {	
						piecesCanBeKilled.add(btn);
					}			
				}
			}
			if(c>0 && !piecesCanBeKilled.contains(btn)) {
				if(Main.board[l][c-1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(0, 1)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
			if(c<7) {
				if(Main.board[l][c+1]==-500 && !piecesCanBeKilled.contains(btn) && Checked.isBlackKingAttacked(0, -1)==false) {				
					piecesCanBeKilled.add(btn);
				}
			}
		}
		
		int l = (Piece.b4.getY()-25)/75;
		int c = (Piece.b4.getX()-200)/75;
		if(l>0) {
			if(c>0) {
				if(Main.board[l-1][c-1]>=0 && Checked.isBlackKingAttacked(-1, -1)==false) {	
					canBlackKingMove = true;
				}
			}
			if(c<7) {
				if(Main.board[l-1][c+1]>=0 && Checked.isBlackKingAttacked(-1, 1)==false) {		
					canBlackKingMove = true;
				}
			}
			if(Main.board[l-1][c]>=0 && Checked.isBlackKingAttacked(-1, 0)==false) {	
				canBlackKingMove = true;
			}
		}
		if(l<7) {
			
			if(c>0) {
				if(Main.board[l+1][c-1]>=0 && Checked.isBlackKingAttacked(1, -1)==false) {	
					canBlackKingMove = true;
				}
			}
			if(c<7) {
				if(Main.board[l+1][c+1]>=0 && Checked.isBlackKingAttacked(1, 1)==false) {
					canBlackKingMove = true;
				}	
			}
			if(Main.board[l+1][c]>=0 && Checked.isBlackKingAttacked(1, 0)==false) {
				canBlackKingMove = true;
			}
		}
		if(c>0) {
			if(Main.board[l][c-1]>=0 && Checked.isBlackKingAttacked(0, -1)==false) {
				canBlackKingMove = true;
			}
		}
		if(c<7) {
			if(Main.board[l][c+1]>=0 && Checked.isBlackKingAttacked(0, 1)==false) {	
				canBlackKingMove = true;

			}
		}
		System.out.println(canBlackKingMove);
		System.out.println("size "+piecesCanBeKilled.size());
		if(piecesCanBeKilled.size()==0 && canBlackKingMove==false) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
