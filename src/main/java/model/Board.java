package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Board</b> appartient au package <b>model</b>
 * @author Thomas
 */
public class Board {
	
	private String[] strNums;
	
	private int [][] board = new int [8][8];
	
	private final Logger logger =  LogManager.getLogger(this);

	/** 
	 * La méthode Board est la méthode principale de la classe Board, elle créer un tableau multidimentionnel à partir du fichier chessboard.txt
	 */
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
        try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        logger.log(Level.INFO, "board " + board.toString());
	}
	
	/** 
	 * La méthode getBoard retourne la valeur board
	 * @return le tableau multidimentionnel board
	 */
	public int[][] getBoard(){
		return board;
	}
	
	/** 
	 * La méthode setBoard permet d'attribuer une valeur au tableau board
	 * @param board tableau multidimentionnel
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}
}
