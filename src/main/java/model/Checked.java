package model;

/** 
 * La classe <b>Checked</b> appartient au package <b>model</b>.
 * Elle comprend 2 méthodes vérifiant si un roi est en échec.
 * @see <b>isWhiteKingCheckmate<b>, <b>isBlackKingCheckmate<b>
 */

public class Checked {

	public static boolean isWhiteKingAttacked(int l1, int c1) {
		
		int l = (Piece.b28.getY()+(75*l1)-25)/75;
		int c = (Piece.b28.getX()+(75*c1)-200)/75;
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				if(Main.board[l-i][c]==-9 || Main.board[l-i][c]==-5) {
					return true;
				}
				else if(Main.board[l-i][c]>0 || (Main.board[l-i][c]<0 && Main.board[l-i][c]!=-9 && Main.board[l-i][c]!=-5)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				if(Main.board[l+i][c]==-9 || Main.board[l+i][c]==-5) {
					return true;
				}
				else if(Main.board[l+i][c]>0 || (Main.board[l+i][c]<0 && Main.board[l+i][c]!=-9 && Main.board[l+i][c]!=-5)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				if(Main.board[l][c-i]==-9 || Main.board[l][c-i]==-5) {
					return true;
				}
				else if(Main.board[l][c-i]>0 || (Main.board[l][c-i]<0 && Main.board[l][c-i]!=-9 && Main.board[l][c-i]!=-5)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				if(Main.board[l][c+i]==-9 || Main.board[l][c+i]==-5) {
					return true;
				}
				else if(Main.board[l][c+i]>0 || (Main.board[l][c+i]<0 && Main.board[l][c+i]!=-9 && Main.board[l][c+i]!=-5)) {
					i=8;
				}
			}	
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				if(Main.board[l-i][c-i]==-9 || Main.board[l-i][c-i]==-3) {
					return true;
				}
				else if(Main.board[l-i][c-i]>0 || (Main.board[l-i][c-i]<0 && Main.board[l-i][c-i]!=-9 && Main.board[l-i][c-i]!=-3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				if(Main.board[l+i][c-i]==-9 || Main.board[l+i][c-i]==-3) {
					return true;
				}
				else if(Main.board[l+i][c-i]>0 || (Main.board[l+i][c-i]<0 && Main.board[l+i][c-i]!=-9 || Main.board[l+i][c-i]!=-3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				if(Main.board[l-i][c+i]==-9 || Main.board[l-i][c+i]==-3) {
					return true;
				}
				else if(Main.board[l-i][c+i]>0 || (Main.board[l-i][c+i]<0 && Main.board[l-i][c+i]!=-9 && Main.board[l-i][c+i]!=-3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				if(Main.board[l+i][c+i]==-9 || Main.board[l+i][c+i]==-3) {
					return true;
				}
				else if(Main.board[l+i][c+i]>0 || (Main.board[l+i][c+i]<0 && Main.board[l+i][c+i]!=-9 && Main.board[l+i][c+i]!=-3)) {
					i=8;
				}
			}
		}
		if(l>0) {
			if(c>1) {
				if(Main.board[l-1][c-2]==-2) {
					return true;
				}
			}
			if(c<6) {
				if(Main.board[l-1][c+2]==-2) {
					return true;
				}
			}
			if(c>0) {
				if(Main.board[l-1][c-1]==-1) {		
					return true;			
				}
			}	
			if(c<7) {
				if(Main.board[l-1][c+1]==-1) {
					return true;
				}
			}
		}
		if(l>1) {
			if(c>0) {
				if(Main.board[l-2][c-1]==-2) {	
					return true;
				}
			}
			if(c<7) {
				if(Main.board[l-2][c+1]==-2) {	
					return true;
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				if(Main.board[l+1][c-2]==-2) {	
					return true;
				}
			}
			if(c<6) {
				if(Main.board[l+1][c+2]==-2) {	
					return true;
				}
			}
		}
		if(l<6) {
			if(c>0) {
				if(Main.board[l+2][c-1]==-2) {	
					return true;
				}
			}
			if(c<7) {
				if(Main.board[l+2][c+1]==-2) {	
					return true;
				}			
			}
		}
		return false;
	}
	
public static boolean isBlackKingAttacked(int l1, int c1) {
		
		int l = (Piece.b4.getY()+(75*l1)-25)/75;
		int c = (Piece.b4.getX()+(75*c1)-200)/75;
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				if(Main.board[l-i][c]==9 || Main.board[l-i][c]==5) {
					return true;
				}
				else if(Main.board[l-i][c]<0 || (Main.board[l-i][c]>0 && Main.board[l-i][c]!=9 && Main.board[l-i][c]!=5)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				if(Main.board[l+i][c]==9 || Main.board[l+i][c]==5) {
					return true;
				}
				else if(Main.board[l+i][c]<0 || (Main.board[l+i][c]>0 && Main.board[l+i][c]!=9 && Main.board[l+i][c]!=5)) {
					i=8;
				}
				
			}
		}
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				if(Main.board[l][c-i]==9 || Main.board[l][c-i]==5) {
					return true;
				}
				else if(Main.board[l][c-i]<0 || (Main.board[l][c-i]>0 && Main.board[l][c-i]!=9 && Main.board[l][c-i]!=5)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				if(Main.board[l][c+i]==9 || Main.board[l][c+i]==5) {
					return true;
				}
				else if(Main.board[l][c+i]<0 || (Main.board[l][c+i]>0 && Main.board[l][c+i]!=9 && Main.board[l][c+i]!=5)) {
					i=8;
				}
			}	
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				if(Main.board[l-i][c-i]==9 || Main.board[l-i][c-i]==3) {
					return true;
				}
				else if(Main.board[l-i][c-i]<0 || (Main.board[l-i][c-i]>0 && Main.board[l-i][c-i]!=9 && Main.board[l-i][c-i]!=3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				if(Main.board[l+i][c-i]==9 || Main.board[l+i][c-i]==3) {
					return true;
				}
				else if(Main.board[l+i][c-i]<0 || (Main.board[l+i][c-i]>0 && Main.board[l+i][c-i]!=9 && Main.board[l+i][c-i]!=3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				if(Main.board[l-i][c+i]==9 || Main.board[l-i][c+i]==3) {
					return true;
				}
				else if(Main.board[l-i][c+i]<0 || (Main.board[l-i][c+i]>0 && Main.board[l-i][c+i]!=9 && Main.board[l-i][c+i]!=3)) {
					i=8;
				}
			}
		}
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				if(Main.board[l+i][c+i]==9 || Main.board[l+i][c+i]==3) {
					return true;
				}
				else if(Main.board[l+i][c+i]<0 || (Main.board[l+i][c+i]>0 && Main.board[l+i][c+i]!=9 && Main.board[l+i][c+i]!=3)) {
					i=8;
				}
			}
		}
		if(l>0) {
			if(c>1) {
				if(Main.board[l-1][c-2]==2) {
					return true;
				}
			}
			if(c<6) {
				if(Main.board[l-1][c+2]==2) {
					return true;
				}
			}
		}
		if(l>1) {
			if(c>0) {
				if(Main.board[l-2][c-1]==2) {	
					return true;
				}
			}
			if(c<7) {
				if(Main.board[l-2][c+1]==2) {	
					return true;
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				if(Main.board[l+1][c-2]==2) {	
					return true;
				}
			}
			if(c<6) {
				if(Main.board[l+1][c+2]==2) {	
					return true;
				}
			}
			if(c>0) {
				if(Main.board[l+1][c-1]==1) {		
					return true;			
				}
			}	
			if(c<7) {
				if(Main.board[l+1][c+1]==1) {
					return true;
				}
			}
		}
		if(l<6) {
			if(c>0) {
				if(Main.board[l+2][c-1]==2) {	
					return true;
				}
			}
			if(c<7) {
				if(Main.board[l+2][c+1]==2) {	
					return true;
				}			
			}
		}
		return false;
	}
	
}
