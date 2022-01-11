package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Player;
import view.Display;

import javax.swing.JLabel;

/** 
 * La classe <b>Main</b> appartient au package <b>model</b>.
 * Elle d�clare la fen�tre de jeu et initialise l'�chiquier ainsi que les pi�ces.
 */

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public static Main instance;
	
	public static final String RES_PATH = "src/main/resources/"; //chemin ressource
	
	public static Image boardImage = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
	
	public static String team = "white";	//Définition de l'équipe qui commence
	
	public static JDialog fin = new JDialog(instance, "Fin de la partie", true); //fenetre de fin de partie
	
    public static JPanel panel = new JPanel() { //affichage de l'image sur le panel
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(boardImage, 200, 25, null);
        }
    };
    
    public ImageIcon boardIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/chessboardblue.png"))); 

	private String[] strNums;
	
	public static int [][] board = new int [8][8]; //déclaration du tableau tableau multidimensionel
	
	
	/**
	 * @param 
	 *
	 */
	public Main() {
		
		panel.setLayout(null); //layout null
		
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

		Player.initBoard();  //initialisation de l'échiquier
		
		this.setTitle("Chess"); //propriétés de la frame
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		
    	
		panel.addMouseListener(new MouseAdapter() { //enlève les sélections lorsqu'on clique sur le panel

            @Override
            public void mouseReleased(MouseEvent e) { 
            	if(Display.buttonSelected!=null && !(e.getSource() instanceof JLabel)) {
            		Display.clearPossibility();
            		panel.repaint();
            		panel.revalidate();
            		Display.buttonSelected.setBackground(null);
            		Display.buttonSelected.setOpaque(false);
        			Display.buttonSelected=null;
            	}	
            }
        });
		
		fin.setLayout(null); //propriétés du JDialog
		fin.setResizable(false);
		fin.setSize(450, 260);
		fin.setLocationRelativeTo(null);
		
		fin.addWindowListener(new WindowAdapter() 
		{
			  public void windowClosing(WindowEvent e)
			  {
				  System.exit(0);
			  }
		});	
	}
	
	public static void main(String[] args) throws IOException {
		instance = new Main();
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}