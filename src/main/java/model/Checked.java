package model;

public class Checked {
	
	public boolean isWhiteKingAttacked(int[][] board) {
		
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = board[l][c];
				
				if(value==10) {
					
					for(int i=1;i<=7;i++) {
						if(l-i>=0) {
							if(board[l-i][c]==-9 || board[l-i][c]==-5) {
								return true;
							}
							else if(board[l-i][c]>0 || (board[l-i][c]<0 && board[l-i][c]!=-9 && board[l-i][c]!=-5)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7) {
							if(board[l+i][c]==-9 || board[l+i][c]==-5) {
								return true;
							}
							else if(board[l+i][c]>0 || (board[l+i][c]<0 && board[l+i][c]!=-9 && board[l+i][c]!=-5)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(c-i>=0) {
							if(board[l][c-i]==-9 || board[l][c-i]==-5) {
								return true;
							}
							else if(board[l][c-i]>0 || (board[l][c-i]<0 && board[l][c-i]!=-9 && board[l][c-i]!=-5)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(c+i<=7) {
							if(board[l][c+i]==-9 || board[l][c+i]==-5) {
								return true;
							}
							else if(board[l][c+i]>0 || (board[l][c+i]<0 && board[l][c+i]!=-9 && board[l][c+i]!=-5)) {
								i=8;
							}
						}	
					}
					for(int i=1;i<=7;i++) {
						if(l-i>=0 && c-i>=0) {
							if(board[l-i][c-i]==-9 || board[l-i][c-i]==-3) {
								return true;
							}
							else if(board[l-i][c-i]>0 || (board[l-i][c-i]<0 && board[l-i][c-i]!=-9 && board[l-i][c-i]!=-3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7 && c-i>=0) {
							if(board[l+i][c-i]==-9 || board[l+i][c-i]==-3) {
								return true;
							}
							else if(board[l+i][c-i]>0 || (board[l+i][c-i]<0 && board[l+i][c-i]!=-9 || board[l+i][c-i]!=-3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l-i>=0 && c+i<=7) {
							if(board[l-i][c+i]==-9 || board[l-i][c+i]==-3) {
								return true;
							}
							else if(board[l-i][c+i]>0 || (board[l-i][c+i]<0 && board[l-i][c+i]!=-9 && board[l-i][c+i]!=-3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7 && c+i<=7) {
							if(board[l+i][c+i]==-9 || board[l+i][c+i]==-3) {
								return true;
							}
							else if(board[l+i][c+i]>0 || (board[l+i][c+i]<0 && board[l+i][c+i]!=-9 && board[l+i][c+i]!=-3)) {
								i=8;
							}
						}
					}
					if(l>0) {
						if(c>1) {
							if(board[l-1][c-2]==-2) {
								return true;
							}
						}
						if(c<6) {
							if(board[l-1][c+2]==-2) {
								return true;
							}
						}
						if(c>0) {
							if(board[l-1][c-1]==-1) {		
								return true;			
							}
						}	
						if(c<7) {
							if(board[l-1][c+1]==-1) {
								return true;
							}
						}
					}
					if(l>1) {
						if(c>0) {
							if(board[l-2][c-1]==-2) {	
								return true;
							}
						}
						if(c<7) {
							if(board[l-2][c+1]==-2) {	
								return true;
							}			
						}
					}
					if(l<7) {
						if(c>1) {
							if(board[l+1][c-2]==-2) {	
								return true;
							}
						}
						if(c<6) {
							if(board[l+1][c+2]==-2) {	
								return true;
							}
						}
					}
					if(l<6) {
						if(c>0) {
							if(board[l+2][c-1]==-2) {	
								return true;
							}
						}
						if(c<7) {
							if(board[l+2][c+1]==-2) {	
								return true;
							}			
						}
					}
					break;
				}
			}
		}
		return false;
	}
	
	public boolean isBlackKingAttacked(int[][] board) {
		
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				int value = board[l][c];
				
				if(value==-10) {
					for(int i=1;i<=7;i++) {
						if(l-i>=0) {
							if(board[l-i][c]==9 || board[l-i][c]==5) {
								return true;
							}
							else if(board[l-i][c]<0 || (board[l-i][c]>0 && board[l-i][c]!=9 && board[l-i][c]!=5)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7) {
							if(board[l+i][c]==9 || board[l+i][c]==5) {
								return true;
							}
							else if(board[l+i][c]<0 || (board[l+i][c]>0 && board[l+i][c]!=9 && board[l+i][c]!=5)) {
								i=8;
							}
							
						}
					}
					for(int i=1;i<=7;i++) {
						if(c-i>=0) {
							if(board[l][c-i]==9 || board[l][c-i]==5) {
								return true;
							}
							else if(board[l][c-i]<0 || (board[l][c-i]>0 && board[l][c-i]!=9 && board[l][c-i]!=5)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(c+i<=7) {
							if(board[l][c+i]==9 || board[l][c+i]==5) {
								return true;
							}
							else if(board[l][c+i]<0 || (board[l][c+i]>0 && board[l][c+i]!=9 && board[l][c+i]!=5)) {
								i=8;
							}
						}	
					}
					for(int i=1;i<=7;i++) {
						if(l-i>=0 && c-i>=0) {
							if(board[l-i][c-i]==9 || board[l-i][c-i]==3) {
								return true;
							}
							else if(board[l-i][c-i]<0 || (board[l-i][c-i]>0 && board[l-i][c-i]!=9 && board[l-i][c-i]!=3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7 && c-i>=0) {
							if(board[l+i][c-i]==9 || board[l+i][c-i]==3) {
								return true;
							}
							else if(board[l+i][c-i]<0 || (board[l+i][c-i]>0 && board[l+i][c-i]!=9 && board[l+i][c-i]!=3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l-i>=0 && c+i<=7) {
							if(board[l-i][c+i]==9 || board[l-i][c+i]==3) {
								return true;
							}
							else if(board[l-i][c+i]<0 || (board[l-i][c+i]>0 && board[l-i][c+i]!=9 && board[l-i][c+i]!=3)) {
								i=8;
							}
						}
					}
					for(int i=1;i<=7;i++) {
						if(l+i<=7 && c+i<=7) {
							if(board[l+i][c+i]==9 || board[l+i][c+i]==3) {
								return true;
							}
							else if(board[l+i][c+i]<0 || (board[l+i][c+i]>0 && board[l+i][c+i]!=9 && board[l+i][c+i]!=3)) {
								i=8;
							}
						}
					}
					if(l>0) {
						if(c>1) {
							if(board[l-1][c-2]==2) {
								return true;
							}
						}
						if(c<6) {
							if(board[l-1][c+2]==2) {
								return true;
							}
						}
					}
					if(l>1) {
						if(c>0) {
							if(board[l-2][c-1]==2) {	
								return true;
							}
						}
						if(c<7) {
							if(board[l-2][c+1]==2) {	
								return true;
							}			
						}
					}
					if(l<7) {
						if(c>1) {
							if(board[l+1][c-2]==2) {	
								return true;
							}
						}
						if(c<6) {
							if(board[l+1][c+2]==2) {	
								return true;
							}
						}
						if(c>0) {
							if(board[l+1][c-1]==1) {		
								return true;			
							}
						}	
						if(c<7) {
							if(board[l+1][c+1]==1) {
								return true;
							}
						}
					}
					if(l<6) {
						if(c>0) {
							if(board[l+2][c-1]==2) {	
								return true;
							}
						}
						if(c<7) {
							if(board[l+2][c+1]==2) {	
								return true;
							}			
						}
					}
					break;
				}
			}
		}
		return false;
	}
}
