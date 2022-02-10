package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * La classe <b>Swing</b> appartient au package <b>view</b>, c'est une classe concrète qui implémente l'interface Strategy. 
 * Il s'agit de la vue Swing.
 * @author Thomas
 */
@SuppressWarnings("serial")
public class Swing extends JFrame implements Strategy{

	/**
	 * JPanel de la frame
	 */
	private JPanel panel;
	
	/**
	 * logger du log4j
	 */
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	/**
	 * int qui définie la valeur horizontale de l'espace entre la bordure et l'échiquier
	 */
	private int x = 200;
	
	/**
	 * int qui définie la valeur verticale de l'espace entre la bordure et l'échiquier
	 */
	private int y = 25;
	
	private int squareSize = 75;
	
	private BufferedImage boardImage = null;
	
	/**
	  * La méthode createFrame permet de créer la frame et d'y ajouter un panel.
	  * @param board image de l'échiquier à mettre en background
	  * @return 1 si la méthode a bien été exécutée
	  */
    @Override
    public int createFrame() {
    	
		try {
			boardImage = ImageIO.read(Swing.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	panel = new JPanel() { //affichage de l'image sur le panel
    		@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(boardImage, x, y, null);
            }
        };      
        
        BufferedImage icon = null;
		try {
			icon = ImageIO.read(Swing.class.getResource("/rb.png")); //cherche l'image rb.png
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		panel.setLayout(null); //layout null
		this.setTitle("Chess"); //nom de la frame
		this.setSize(1100, 700); //taille de la frame
		this.setIconImage(icon); //icon de la frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //quitte l'application lorsqu'elle est fermée
		this.setContentPane(panel); //ajoute le panel à la frame
		this.setLocationRelativeTo(null); //met la frame au milieu de l'écran
 		this.setResizable(false); //on ne peut pas redimentionner la frame 
		this.setVisible(true); //on voit la frame
		logger.log(Level.INFO, "vue = swing");
		return 1;
	}
     
     /**
	  * La méthode addComponent permet d'ajouter un composant au panel.
	  * @param component composant à ajouter au panel
	  * @return 1 si la méthode a bien été exécutée
	  */
     @Override
     public int addComponent(Component component) {
    	 panel.add(component);
    	 return 1;
     }
     
     /**
	  * La méthode updateView permet de mettre à jour la vue.
	  * @return 1 si la méthode a bien été exécutée
	  */
     @Override
     public int updateView() {
    	 panel.repaint();
 		 panel.revalidate();
    	 return 1;
     }
     
     /**
 	 * La méthode getX retourne la valeur de la variable x
 	 * @return la valeur horizontale en pixel
 	 */
     @Override
     public int getX() {
    	 return x;
     }
     
     /**
 	 * La méthode getY retourne la valeur de la variable x
 	 * @return la valeur horizontale en pixel
 	 */
     @Override
     public int getY() {
    	 return y;
     }
     
     @Override
     public void addListener(MouseAdapter listener) {
 		 panel.addMouseListener(listener);
     }

	@Override
	public int getSquareSize() {
		return squareSize;
	}
	
	@Override
	public void clearPossibilities() {
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JLabel) {
		        panel.remove(component);
		    }
			if (component instanceof JButton) {
		        Component[] buttons = ((Container) component).getComponents();
		        JButton btn = (JButton) component;
		        for (Component comp : buttons) {
		        	if (comp instanceof JLabel) {
				        btn.remove(comp);
				    }
		        }
		    }
		} 
	}

	@Override
	public void removeButton(JButton btnKilled) {
		panel.remove(btnKilled);
	}
}
