package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import log4j2.Log4j;

public class Board {
	
	private String[] strNums;
	
	private int [][] board = new int [8][8];

	Log4j log = new Log4j();	
	
	public Board() {
		InputStream in = getClass().getResourceAsStream("/chessboard.txt"); //recherche du fichier ressource chessboard.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(in)); //lecture du fichier
        for(int l = 0; l<8; l++) { //fonction permettant de convertir le fichier texte en tableau multidimensionel
            try {
				strNums = br.readLine().split(", "); 
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        	for (int c = 0; c < 8; c++) {
        		board[l][c] = Integer.parseInt(strNums[c]);
        	}
        }
        log.logInfo(board.toString());
	}
	
	public int getBoard(int l, int c){
		return board[l][c];
	}
	
}
