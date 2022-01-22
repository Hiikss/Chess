package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Swing extends JFrame implements Strategy{
	
	
	
	public static Image boardImage = Toolkit.getDefaultToolkit().getImage(Swing.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
	
	public static JPanel panel = new JPanel() { //affichage de l'image sur le panel
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(boardImage, 200, 25, null);
        }
    };
	
    @Override
    public int performAction() {
		
		panel.setLayout(null); //layout null
		
		this.setTitle("Chess"); //propriétés de la frame
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		return 0;
		
	
	}

}
