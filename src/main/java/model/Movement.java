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
			int size = model.getSquareSize();
			JLabel possibility = new JLabel();
			possibility.setIcon(icercle);
			possibility.setSize(size, size);
			possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			possibility.addMouseListener(model.addKillLabelListener());
			model.getPieceAt(l, c).add(possibility);
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

	public int[][] copyBoard(int[][] board){
		int[][] newBoard = new int[8][8];
		for(int l=0; l<8; l++) {
			for(int c=0; c<8; c++) {
				newBoard[l][c] = board[l][c];
			}
		}
		return newBoard;
	}
	
	public boolean deplacementPion(int l, int c, int[][] board, int value) {
		setRockFalse();
		boolean canKingMove = false;
		int[][] newBoard = copyBoard(board);
		if(value>0) {
		newBoard[l][c] = 0;
		newBoard[l-1][c] = 1;
		if(l==6) {
			for(int i=1;i<=2;i++) {
				newBoard[l-i+1][c] = 0;
				newBoard[l-i][c] = 1;
				if(board[l-i][c]==0 && isWhiteKingAttacked(newBoard)==false) {
					createPossibility(l-i, c);
					canKingMove = true;
				}
				else if(isWhiteKingAttacked(newBoard)==false){
					i=3;
				}
			}
		}

		else if(l>0 && board[l-1][c]==0 && isWhiteKingAttacked(newBoard)==false){
			createPossibility(l-1, c);
			canKingMove = true;
		}
		if(l>0) {
			if(c>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-1][c-1] = 1;
				if(board[l-1][c-1]<0 && isWhiteKingAttacked(newBoard)==false) {		
					createPossibilityKill(l-1, c-1);
					canKingMove = true;
				}
			}
			if(c<7) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-1][c+1] = 1;
				if(board[l-1][c+1]<0 && isWhiteKingAttacked(newBoard)==false) {			
					createPossibilityKill(l-1, c+1);
					canKingMove = true;
				}
			}
	
		}
		}
		else {
			newBoard[l][c] = 0;
			newBoard[l+1][c] = -1;
			if(l==1) {
				for(int i=1;i<=2;i++) {	
					newBoard[l+i-1][c] = 0;
					newBoard[l+i][c] = -1;
					if(board[l+i][c]==0 && isBlackKingAttacked(newBoard)==false) {
						createPossibility(l+i,c);
						canKingMove = true;
					}
					else if(isWhiteKingAttacked(newBoard)==false){
						i=3;
					}
				}
			}
			else if(l<7 && board[l+1][c]==0 && isBlackKingAttacked(newBoard)==false){
				createPossibility(l+1, c);
				canKingMove = true;
			}
			if(l<7) {
				if(c>0) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l+1][c-1] = -1;
					if(board[l+1][c-1]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l+1, c-1);
						canKingMove = true;
					}
				}	
				if(c<7) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l+1][c+1] = -1;
					if(board[l+1][c+1]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l+1, c+1);
						canKingMove = true;
					}
				}
			}
		}
		return canKingMove;
	}
	
	public boolean deplacementDiag(int l, int c, int[][] board, int value) {
		setRockFalse();
		boolean canKingMove = false;
		int[][] newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c-i>=0) {
				newBoard[l-i+1][c-i+1] = 0;
				newBoard[l-i][c-i] = value;
				if(value>0) {
					if(board[l-i][c-i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l-i, c-i);
						canKingMove = true;
					}
					else if(board[l-i][c-i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c-i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l-i][c-i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l-i, c-i);
						canKingMove = true;
					}
					else if(board[l-i][c-i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c-i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c-i>=0) {
				newBoard[l+i-1][c-i+1] = 0;
				newBoard[l+i][c-i] = value;
				if(value>0) {
					if(board[l+i][c-i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l+i, c-i);
						canKingMove = true;
					}
					else if(board[l+i][c-i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c-i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l+i][c-i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l+i, c-i);
						canKingMove = true;
					}
					else if(board[l+i][c-i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c-i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l-i>=0 && c+i<=7) {
				newBoard[l-i+1][c+i-1] = 0;
				newBoard[l-i][c+i] = value;
				if(value>0) {
					if(board[l-i][c+i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l-i, c+i);
						canKingMove = true;
					}
					else if(board[l-i][c+i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c+i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l-i][c+i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l-i, c+i);
						canKingMove = true;
					}
					else if(board[l-i][c+i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c+i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l+i<=7 && c+i<=7) {
				newBoard[l+i-1][c+i-1] = 0;
				newBoard[l+i][c+i] = value;
				if(value>0) {
					if(board[l+i][c+i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l+i, c+i);
						canKingMove = true;
					}
					else if(board[l+i][c+i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c+i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l+i][c+i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l+i, c+i);
						canKingMove = true;
					}
					else if(board[l+i][c+i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c+i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		return canKingMove;
	}
	
	public boolean deplacementLigne(int l, int c, int[][] board, int value) {
		setRockFalse();
		boolean canKingMove = false;
		int[][] newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l-i>=0) {
				newBoard[l-i+1][c] = 0;
				newBoard[l-i][c] = value;
				if(value>0) {
					if(board[l-i][c]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l-i, c);
						canKingMove = true;
					}
					else if(board[l-i][c]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l-i][c]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l-i, c);
						canKingMove = true;
					}
					else if(board[l-i][c]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l-i, c);
						canKingMove = true;
						i=8;
					}
					else if(board[l-i][c]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(l+i<=7) {
				newBoard[l+i-1][c] = 0;
				newBoard[l+i][c] = value;
				if(value>0) {
					if(board[l+i][c]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l+i, c);
						canKingMove = true;
					}
					else if(board[l+i][c]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l+i][c]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l+i, c);
						canKingMove = true;
					}
					else if(board[l+i][c]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l+i, c);
						canKingMove = true;
						i=8;
					}
					else if(board[l+i][c]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(c-i>=0) {
				newBoard[l][c-i+1] = 0;
				newBoard[l][c-i] = value;
				if(value>0) {
					if(board[l][c-i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l, c-i);
						canKingMove = true;
					}
					else if(board[l][c-i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l][c-i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l][c-i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l, c-i);
						canKingMove = true;
					}
					else if(board[l][c-i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l, c-i);
						canKingMove = true;
						i=8;
					}
					else if(board[l][c-i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		newBoard = copyBoard(board);
		for(int i=1;i<=7;i++) {
			if(c+i<=7) {
				newBoard[l][c+i-1] = 0;
				newBoard[l][c+i] = value;
				if(value>0) {
					if(board[l][c+i]==0 && isWhiteKingAttacked(newBoard)==false){
						createPossibility(l, c+i);
						canKingMove = true;
					}
					else if(board[l][c+i]<0 && isWhiteKingAttacked(newBoard)==false) {
						createPossibilityKill(l, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l][c+i]>0 || isWhiteKingAttacked(newBoard)==false){
						i=8;
					}
				}
				else {
					if(board[l][c+i]==0 && isBlackKingAttacked(newBoard)==false){
						createPossibility(l, c+i);
						canKingMove = true;
					}
					else if(board[l][c+i]>0 && isBlackKingAttacked(newBoard)==false) {
						createPossibilityKill(l, c+i);
						canKingMove = true;
						i=8;
					}
					else if(board[l][c+i]<0 || isBlackKingAttacked(newBoard)==false){
						i=8;
					}
				}
			}
		}
		return canKingMove;
	}
	
	public boolean deplacementCavalier(int l, int c, int[][] board, int value) {
		setRockFalse();
		boolean canKingMove = false;
		int[][] newBoard = copyBoard(board);
		if(l>0) {
			if(c>1) {
				newBoard[l][c] = 0;
				newBoard[l-1][c-2] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-1][c-2]==0){
						createPossibility(l-1, c-2);
						canKingMove = true;
					}
					else if(board[l-1][c-2]<0) {
						createPossibilityKill(l-1, c-2);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-1][c-2]==0) {
						createPossibility(l-1, c-2);
						canKingMove = true;
					}
					else if(board[l-1][c-2]>0 ) {
						createPossibilityKill(l-1, c-2);
						canKingMove = true;
					}
				}
			}
			if(c<6) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-1][c+2] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-1][c+2]==0){
						createPossibility(l-1, c+2);
						canKingMove = true;
					}
					else if(board[l-1][c+2]<0) {
						createPossibilityKill(l-1, c+2);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-1][c+2]==0){
						createPossibility(l-1, c+2);
						canKingMove = true;
					}
					else if(board[l-1][c+2]>0) {
						createPossibilityKill(l-1, c+2);
						canKingMove = true;
					}
				}					
			}
		}
		if(l>1) {
			if(c>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-2][c-1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-2][c-1]==0){
						createPossibility(l-2, c-1);
						canKingMove = true;
					}
					else if(board[l-2][c-1]<0) {
						createPossibilityKill(l-2, c-1);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-2][c-1]==0){
						createPossibility(l-2, c-1);
						canKingMove = true;
					}
					else if(board[l-2][c-1]>0) {
						createPossibilityKill(l-2, c-1);
						canKingMove = true;
					}
				}
			}
			if(c<7) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-2][c+1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-2][c+1]==0){
						createPossibility(l-2, c+1);
						canKingMove = true;
					}
					else if(board[l-2][c+1]<0) {
						createPossibilityKill(l-2, c+1);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-2][c+1]==0){
						createPossibility(l-2, c+1);
						canKingMove = true;
					}
					else if(board[l-2][c+1]>0) {
						createPossibilityKill(l-2, c+1);
						canKingMove = true;
					}
				}			
			}
		}
		if(l<7) {
			if(c>1) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+1][c-2] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+1][c-2]==0){
						createPossibility(l+1, c-2);
						canKingMove = true;
					}
					else if(board[l+1][c-2]<0) {
						createPossibilityKill(l+1, c-2);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+1][c-2]==0){
						createPossibility(l+1, c-2);
						canKingMove = true;
					}
					else if(board[l+1][c-2]>0) {
						createPossibilityKill(l+1, c-2);
						canKingMove = true;
					}
				}
			}
			if(c<6) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+1][c+2] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+1][c+2]==0){
						createPossibility(l+1, c+2);
						canKingMove = true;
					}
					else if(board[l+1][c+2]<0) {
						createPossibilityKill(l+1, c+2);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+1][c+2]==0){
						createPossibility(l+1, c+2);
						canKingMove = true;
					}
					else if(board[l+1][c+2]>0) {
						createPossibilityKill(l+1, c+2);
						canKingMove = true;
					}
				}
			}
		}
		if(l<6) {
			if(c>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+2][c-1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+2][c-1]==0){
						createPossibility(l+2, c-1);
						canKingMove = true;
					}
					else if(board[l+2][c-1]<0) {
						createPossibilityKill(l+2, c-1);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+2][c-1]==0){
						createPossibility(l+2, c-1);
						canKingMove = true;
					}
					else if(board[l+2][c-1]>0) {
						createPossibilityKill(l+2, c-1);
						canKingMove = true;
					}
				}			
			}
			if(c<7) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+2][c+1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+2][c+1]==0){
						createPossibility(l+2, c+1);
						canKingMove = true;
					}
					else if(board[l+2][c+1]<0) {
						createPossibilityKill(l+2, c+1);
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+2][c+1]==0){
						createPossibility(l+2, c+1);
						canKingMove = true;
					}
					else if(board[l+2][c+1]>0) {
						createPossibilityKill(l+2, c+1);
						canKingMove = true;
					}
				}			
			}
		}
		return canKingMove;
	}
	
	public boolean deplacementRoi(int l, int c, int[][] board, int value) {
		setRockFalse();
		boolean canKingMove = false;
		int[][] newBoard = copyBoard(board);
		if(l>0) {
			if(c>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-1][c-1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-1][c-1]==0){
						createPossibility(l-1, c-1);						
						canKingMove = true;
					}
					else if(board[l-1][c-1]<0) {
						createPossibilityKill(l-1, c-1);						
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-1][c-1]==0){
						createPossibility(l-1, c-1);						
						canKingMove = true;
					}
					else if(board[l-1][c-1]>0) {
						createPossibilityKill(l-1, c-1);						
						canKingMove = true;
					}
				}
			}
			if(c<7) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l-1][c+1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l-1][c+1]==0){
						createPossibility(l-1, c+1);						
						canKingMove = true;
					}
					else if(board[l-1][c+1]<0) {
						createPossibilityKill(l-1, c+1);						
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l-1][c+1]==0){
						createPossibility(l-1, c+1);						
						canKingMove = true;
					}
					else if(board[l-1][c+1]>0) {
						createPossibilityKill(l-1, c+1);						
						canKingMove = true;
					}
				}
			}
			newBoard = copyBoard(board);
			newBoard[l][c] = 0;
			newBoard[l-1][c] = value;
			if(value>0 && isWhiteKingAttacked(newBoard)==false) {
				if(board[l-1][c]==0){
					createPossibility(l-1, c);					
					canKingMove = true;
				}
				else if(board[l-1][c]<0) {
					createPossibilityKill(l-1, c);					
					canKingMove = true;
				}
			}
			else if(value<0 && isBlackKingAttacked(newBoard)==false){
				if(board[l-1][c]==0){
					createPossibility(l-1, c);					
					canKingMove = true;
				}
				else if(board[l-1][c]>0) {
					createPossibilityKill(l-1, c);					
					canKingMove = true;
				}
			}
		}
		if(l<7) {
			if(c>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+1][c-1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+1][c-1]==0){
						createPossibility(l+1, c-1);						
						canKingMove = true;
					}
					else if(board[l+1][c-1]<0) {
						createPossibilityKill(l+1, c-1);						
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+1][c-1]==0){
						createPossibility(l+1, c-1);						
						canKingMove = true;
					}
					else if(board[l+1][c-1]>0) {
						createPossibilityKill(l+1, c-1);						
						canKingMove = true;
					}
				}
			}
			if(c<7) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l+1][c+1] = value;
				if(value>0 && isWhiteKingAttacked(newBoard)==false) {
					if(board[l+1][c+1]==0){
						createPossibility(l+1, c+1);						
						canKingMove = true;
					}
					else if(board[l+1][c+1]<0) {
						createPossibilityKill(l+1, c+1);						
						canKingMove = true;
					}
				}
				else if(value<0 && isBlackKingAttacked(newBoard)==false){
					if(board[l+1][c+1]==0){
						createPossibility(l+1, c+1);						
						canKingMove = true;
					}
					else if(board[l+1][c+1]>0) {
						createPossibilityKill(l+1, c+1);						
						canKingMove = true;
					}
				}		
			}
			newBoard = copyBoard(board);
			newBoard[l][c] = 0;
			newBoard[l+1][c] = value;
			if(value>0 && isWhiteKingAttacked(newBoard)==false) {
				if(board[l+1][c]==0){
					createPossibility(l+1, c);					
					canKingMove = true;
				}
				else if(board[l+1][c]<0) {
					createPossibilityKill(l+1, c);					
					canKingMove = true;
				}
			}
			else if(value<0 && isBlackKingAttacked(newBoard)==false){
				if(board[l+1][c]==0){
					createPossibility(l+1, c);				
					canKingMove = true;
				}
				else if(board[l+1][c]>0) {
					createPossibilityKill(l+1, c);					
					canKingMove = true;
				}
			}
		}
		if(c>0) {
			newBoard = copyBoard(board);
			newBoard[l][c] = 0;
			newBoard[l][c-1] = value;
			if(value>0 && isWhiteKingAttacked(newBoard)==false) {
				if(board[l][c-1]==0){
					createPossibility(l, c-1);					
					canKingMove = true;
				}
				else if(board[l][c-1]<0) {
					createPossibilityKill(l, c-1);					
					canKingMove = true;
				}
			}
			else if(value<0 && isBlackKingAttacked(newBoard)==false){
				if(board[l][c-1]==0){
					createPossibility(l, c-1);
					canKingMove = true;
				}
				else if(board[l][c-1]>0) {
					createPossibilityKill(l, c-1);
					canKingMove = true;
				}
			}
		}
		if(c<7) {
			newBoard = copyBoard(board);
			newBoard[l][c] = 0;
			newBoard[l][c+1] = value;
			if(value>0 && isWhiteKingAttacked(newBoard)==false) {
				if(board[l][c+1]==0){
					createPossibility(l, c+1);
					canKingMove = true;
				}
				else if(board[l][c+1]<0) {
					createPossibilityKill(l, c+1);	
					canKingMove = true;
				}
			}
			else if(value<0 && isBlackKingAttacked(newBoard)==false){
				if(board[l][c+1]==0){
					createPossibility(l, c+1);
					canKingMove = true;
				}
				else if(board[l][c+1]>0) {
					createPossibilityKill(l, c+1);
					canKingMove = true;
				}
			}
			if(value>0) {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l][c-2] = value;
				if(model.hasTA1Moved==false && model.hasWhiteKingMoved==false && board[7][1]==0 && board[7][2]==0 && board[7][3]==0 && isWhiteKingAttacked(newBoard)==false) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l][c-1] = value;
					if(isWhiteKingAttacked(newBoard)==false) {
						createPossibility(l,c-2);
						model.roqueBlancGauche = true;
					}
				}
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l][c+2] = value;
				if(model.hasTH1Moved==false && model.hasWhiteKingMoved==false && board[7][5]==0 && board[7][6]==0 && isWhiteKingAttacked(newBoard)==false) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l][c+1] = value;
					if(isWhiteKingAttacked(newBoard)==false) {
						createPossibility(l,c+2);
						model.roqueBlancDroit = true;
					}
				}
			}
			else {
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l][c-2] = value;
				if(model.hasTA8Moved==false && model.hasBlackKingMoved==false && board[0][1]==0 && board[0][2]==0 && board[0][3]==0 && isBlackKingAttacked(newBoard)==false) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l][c-1] = value;
					if(isBlackKingAttacked(newBoard)==false) {
						createPossibility(l,c-2);
						model.roqueNoirGauche = true;
					}
			}
				newBoard = copyBoard(board);
				newBoard[l][c] = 0;
				newBoard[l][c+2] = value;
				if(model.hasTH8Moved==false && model.hasBlackKingMoved==false && board[0][5]==0 && board[0][6]==0 && isBlackKingAttacked(newBoard)==false) {
					newBoard = copyBoard(board);
					newBoard[l][c] = 0;
					newBoard[l][c+1] = value;
					if(isBlackKingAttacked(newBoard)==false) {
						createPossibility(l,c+2);
						model.roqueNoirDroit = true;
					}
				}
			}
		}
		return canKingMove;
	}
	
	public boolean isWhiteKingAttacked(int[][] board) {
		return model.isWhiteKingAttacked(board);
	}
	
	public boolean isBlackKingAttacked(int[][] board) {
		return model.isBlackKingAttacked(board);
	}
	
	public void setRockFalse() {
		model.roqueNoirDroit = false;
		model.roqueNoirGauche = false;
		model.roqueBlancDroit = false;
		model.roqueBlancGauche = false;
	}
}
