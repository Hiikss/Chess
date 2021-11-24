package chess;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public static Main instance;
	
	public static final String RES_PATH = "/resources/"; //chemin ressource
	
	public static Image boardImage = Toolkit.getDefaultToolkit().getImage(Main.class.getResource(RES_PATH+"chessboardblue.png"));
	
	public static String team = "white";	//Définition de l'équipe qui commence
	
	public static JDialog fin = new JDialog(instance, "Fin de la partie", true);
	
    public static JPanel panel = new JPanel() {
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(boardImage, 200, 25, null);
        }
    };
    
    public ImageIcon boardIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource(RES_PATH+"chessboardblue.png")));
    
	public static int [][] board = { //définition position échiquier
    { -5, -2, -3, -9, -500, -3, -2, -5 },
    { -1, -1, -1, -1, -1, -1, -1, -1 },
    { 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0 },
    { 1, 1, 1, 1, 1, 1, 1, 1 },
    { 5, 2, 3, 9, 500, 3, 2, 5 }
};

	public Main() {
		
		panel.setLayout(null);
		Player.initBoard();
		this.setTitle("Chess");
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		panel.addMouseListener(new MouseAdapter() {

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
		
		fin.setLayout(null);
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