package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	
	private JLabel username = new JLabel("Nom d'utilisateur");
	
	private JLabel password = new JLabel("Mot de passe");
	
	private JLabel creerCompte = new JLabel("<html><u>Créer un compte</u></html>");
	
	private JLabel seConnecter = new JLabel("<html><u>Se connecter</u></html>");
	
	private JLabel info = new JLabel();
	
	private JDialog debut = new JDialog(this, "Connexion joueur 1", true);
	
	private JDialog fin = new JDialog(this, "Fin de la partie", true);
	
	private JDialog changerImage = new JDialog(this, "Changer image de profil", true);
	
	private JDialog chargerPartie = new JDialog(this, "Charger une partie", true);
	
	private JButton valider = new JButton("OK");
	
	private JButton parcourirImage1 = new JButton("Choisir");
	
	private JButton parcourirImage2 = new JButton("Choisir");
	
	private JButton loadGameButton = new JButton("Charger");
	
	private JMenuItem menuNewGame = new JMenuItem("Nouvelle partie");
	
	private JMenuItem uploadImage = new JMenuItem("Changer image");
	
	private JMenuItem saveGame = new JMenuItem("Sauvegarder une partie");
	
	private JMenuItem loadGame = new JMenuItem("Charger une partie");
	
	private JLabel imageJ1 = new JLabel();
	
	private JLabel imageJ2 = new JLabel();
	
	private JLabel imageJ1Panel = new JLabel();
	
	private JLabel imageJ2Panel = new JLabel();
	
	private JLabel nomJ1Panel = new JLabel();
	
	private JLabel nomJ2Panel = new JLabel();
	
	private JLabel nomJ1 = new JLabel();
	
	private JLabel nomJ2 = new JLabel();
	
	private JComboBox<String> gameList = new JComboBox<String>();
	
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JPasswordField();
	
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
		this.setJMenuBar(createMenuBar());
		logger.log(Level.INFO, "vue = swing");
		
		imageJ1Panel.setBounds(895, 475, 100, 100);
		imageJ2Panel.setBounds(895, 50, 100, 100);
		nomJ1Panel.setBounds(895, 580, 100, 30);
		nomJ1Panel.setFont(new Font("Arial",Font.PLAIN,20));
		nomJ2Panel.setFont(new Font("Arial",Font.PLAIN,20));
		nomJ2Panel.setBounds(895, 155, 100, 30);
		panel.add(imageJ1Panel);
		panel.add(imageJ2Panel);
		panel.add(nomJ1Panel);
		panel.add(nomJ2Panel);
		
		username.setBounds(115,30, 100, 25);
		password.setBounds(115,80, 100, 25);
		usernameField.setBounds(115, 55, 200,25);
		passwordField.setBounds(115, 105, 200,25);
		creerCompte.setBounds(165, 135, 100, 25);
		creerCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		creerCompte.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	creerCompte.setForeground(Color.red);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	creerCompte.setForeground(null);
		    }
		});
		
		seConnecter.setBounds(175, 135, 100, 25);
		seConnecter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		seConnecter.setVisible(false);
		seConnecter.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	seConnecter.setForeground(Color.red);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	seConnecter.setForeground(null);
		    }
		});

		valider.setBounds(175, 175, 80, 30);
		info.setBounds(90, 5, 300, 25);
		
		debut.setLayout(null);
		debut.setResizable(false);
		debut.setSize(450, 260);
		debut.setLocationRelativeTo(null);
		debut.add(username);
		debut.add(password);
		debut.add(usernameField);
		debut.add(passwordField);
		debut.add(valider);
		debut.add(creerCompte);
		debut.add(seConnecter);
		debut.add(info);
		
		loadGameButton.setBounds(175, 175, 80, 30);
		gameList.setBounds(115, 30, 200, 25);
		chargerPartie.setSize(450, 260);
		chargerPartie.setLocationRelativeTo(null);
		chargerPartie.setLayout(null);
		chargerPartie.setLocationRelativeTo(null);
		chargerPartie.add(gameList);
		chargerPartie.add(loadGameButton);
		
		imageJ1.setBounds(40, 10, 100, 100);
		imageJ2.setBounds(290, 10, 100, 100);
		nomJ1.setBounds(40, 120, 100, 20);
		nomJ2.setBounds(290, 120, 100, 20);
		nomJ1.setFont(new Font("Arial",Font.PLAIN,18));
		nomJ2.setFont(new Font("Arial",Font.PLAIN,18));
		parcourirImage1.setName("1");
		parcourirImage1.setBounds(50, 160, 80, 30);
		parcourirImage2.setName("2");
		parcourirImage2.setBounds(300, 160, 80, 30);
		changerImage.setLayout(null);
		changerImage.setResizable(false);
		changerImage.setSize(450, 260);
		changerImage.setLocationRelativeTo(null);
		changerImage.add(imageJ1);
		changerImage.add(imageJ2);
		changerImage.add(parcourirImage1);
		changerImage.add(parcourirImage2);
		changerImage.add(nomJ1);
		changerImage.add(nomJ2);
		changerImage.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				updateView();
			}
		});	
		
		fin.setLayout(new BorderLayout()); //propriétés du JDialog
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
     public void addListener(MouseAdapter listener, ActionListener validateButtonListener, MouseAdapter switchLoggingListener, ActionListener newGameListener, ActionListener uploadImageListener,
    		 ActionListener parcourirListener, ActionListener saveGameListener,ActionListener loadGameListener, ActionListener loadButtonListener) {
 		 panel.addMouseListener(listener);
 		 valider.addActionListener(validateButtonListener);
 		 seConnecter.addMouseListener(switchLoggingListener);
 		 creerCompte.addMouseListener(switchLoggingListener);
 		 usernameField.addActionListener(validateButtonListener);
 		 passwordField.addActionListener(validateButtonListener);
 		 menuNewGame.addActionListener(newGameListener); 
 		 uploadImage.addActionListener(uploadImageListener);
 		 parcourirImage1.addActionListener(parcourirListener);
 		 parcourirImage2.addActionListener(parcourirListener);
 		 saveGame.addActionListener(saveGameListener);
 		 loadGame.addActionListener(loadGameListener);
 		 loadGameButton.addActionListener(loadButtonListener);
     }

	@Override
	public int getSquareSize() {
		return squareSize;
	}
	
	@Override
	public void clearPossibilities() {
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JLabel && component.getX()>=x && component.getX()<=x+squareSize*8) {
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

	@Override
	public JButton getPieceAt(int l, int c) {
		int xp = x+c*squareSize;
		int yp = y+l*squareSize;
		JButton btn = null;
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JButton && component.getX()==xp && component.getY()==yp) {
		        btn = (JButton) component;
		    }
		}
		return btn;
	}

	@Override
	public void gameEnd(String reason) {
		JLabel label = new JLabel(reason, SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		fin.add(label);
		fin.setVisible(true);
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuParameters = new JMenu("Paramètres");
		menuNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		uploadImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));
		loadGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		saveGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menuParameters.add(menuNewGame);
		menuParameters.add(uploadImage);
		menuParameters.add(loadGame);
		menuParameters.add(saveGame);
		menuBar.add(menuParameters);
		return menuBar;
	}

	@Override
	public void deleteAllComponents() {
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if(component.getX()<=x+squareSize*8) {
		       panel.remove(component);
			}
		} 
	}

	@Override
	public void gameStart() {
		updateView();
		debut.setVisible(true);
	}

	@Override
	public JTextField getUsernameField() {
		return usernameField;
	}

	@Override
	public JTextField getPasswordField() {
		return passwordField;
	}

	@Override
	public JLabel getCreerCompte() {
		return creerCompte;
	}

	@Override
	public JLabel getSeConnecter() {
		return seConnecter;
	}
	
	@Override
	public JLabel getInfo() {
		return info;
	}

	@Override
	public void setJDialogTitle(String title) {
		debut.setTitle(title);
	}

	@Override
	public void setUploadImageVisible() {
		changerImage.setVisible(true);
	}

	@Override
	public void setImageJ1(ImageIcon image) {
		imageJ1.setIcon(image);
		imageJ1Panel.setIcon(image);
	}

	@Override
	public void setImageJ2(ImageIcon image) {
		imageJ2.setIcon(image);
		imageJ2Panel.setIcon(image);
	}

	@Override
	public void setNameJ1(String name) {
		nomJ1.setText(name);
		nomJ1Panel.setText(name);
	}

	@Override
	public void setNameJ2(String name) {
		nomJ2.setText(name);
		nomJ2Panel.setText(name);
	}

	@Override
	public void setLoadGameVisible() {
		chargerPartie.setVisible(true);
	}

	@Override
	public void addItemsToList(List<String> items) {
		gameList.setModel(new DefaultComboBoxModel<String>(items.toArray(new String[0])));
	}

	@Override
	public String getItem() {
		return gameList.getSelectedItem().toString();
	}
}
