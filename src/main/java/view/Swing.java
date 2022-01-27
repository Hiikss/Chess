package view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Swing</b> appartient au package <b>view</b>.
 * C'est une classe concrete qui implémente l'interface Strategy
 * Il s'agit de la vue en Swing
 */
@SuppressWarnings("serial")
public class Swing extends JFrame implements Strategy{

	private JPanel panel;
	
	private final Logger logger =  LogManager.getLogger(this);
	
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
		setPanel(panel);
		this.setTitle("Chess"); //propriétés de la frame
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		logger.log(Level.INFO, "view = "+view);
		/*view = getDisplay();
		view.setPanel(getPanel());*/
		return 1;
	}
    
     public JPanel getPanel() {
    	 logger.log(Level.INFO, "panel = "+panel);
    	 return panel;
     }
     
     public void setPanel(JPanel panel) {
    	 this.panel = panel;
     }
     
     public int addComponent(JPanel panel, Component component) {
    	 panel.add(component);
    	 return 1;
     }
     
     public Display getDisplay() {
    	 return view;
     }
     
     public void setView(Display view) {
 		this.view = view;
 		
 	}
}
