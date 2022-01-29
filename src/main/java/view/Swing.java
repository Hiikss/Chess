package view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Swing</b> appartient au package <b>view</b>.
 * C'est une classe concrete qui implémente l'interface Strategy. 
 * Il s'agit de la vue Swing.
 * @author Thomas
 */
@SuppressWarnings("serial")
public class Swing extends JFrame implements Strategy{

	private JPanel panel;
	
	public Swing swing;
	
	private final Logger logger =  LogManager.getLogger(this);
	
    @Override
    public int createFrame(Image board) {
    	panel = new JPanel() { //affichage de l'image sur le panel
    		@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(board, 200, 25, null);
            }
        };      
        
        BufferedImage icon = null;
		try {
			icon = ImageIO.read(Swing.class.getResource("/rb.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		panel.setLayout(null); //layout null
		this.setTitle("Chess"); //propriétés de la frame
		this.setSize(1100, 700);
		this.setIconImage(icon);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
 		this.setResizable(false);
		this.setVisible(true);
		logger.log(Level.INFO, "vue = swing");
		return 1;
	}
    
     public void setPanel(JPanel panel) {
    	 this.panel = panel;
     }
     
     public int addComponent(Component component) {
    	 panel.add(component);
    	 return 1;
     }
     
     public int updateView() {
    	 panel.repaint();
 		 panel.revalidate();
    	 return 1;
     }
}
