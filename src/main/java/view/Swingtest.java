package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * La classe <b>Swing</b> appartient au package <b>view</b>.
 * C'est une classe concrete qui implémente l'interface Strategy
 * Il s'agit de la vue en Swing
 */
@SuppressWarnings("serial")
public class Swingtest extends JFrame implements Strategy{
	
	private JPanel panel;
	
	private Display view;
	
    @Override
    public int performAction(Image board) {
    	
    	panel = new JPanel() { //affichage de l'image sur le panel
    		@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(board, 200, 25, null);
            }
        };
		
		panel.setLayout(null); //layout null
		
		this.setTitle("Chess"); //propriétés de la frame
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		return 1;
	}
    
    public int setDisplay(Display view) {
   	 this.view = view;
   	 return 1;
    }

    public Display getView() {
    	return view;
    }
}