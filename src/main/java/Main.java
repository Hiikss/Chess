
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;
import model.Model;
import view.View;
import view.Swing;
import view.Swingtest;

/** 
 * La classe <b>Main</b> appartient au package <b>java</b>.
 * Il s'agit de la classe principale qui lance l'application
 */
public class Main {
	
	private static int vue = 0;
	
	public static Main instance;
	
	private final Logger logger =  LogManager.getLogger(this);
	
	public Main() throws IOException {
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		
		View view = null; //la classe View est instanciée
		Model model = new Model(); //la classe model est instanciée

		switch(vue) { //on choisi quelle vue est affichée
		case 0: //cas où la vue est swing
			view = new View(new Swing());			
			break;
		case 1: //cas où la vue est swingtest
			view = new View(new Swingtest());
			break;
		}
		view.createFrame(boardImage); //on crée la frame et le panel de la vue
		Controller controller = new Controller(model, view); //la classe Controller est instanciée
		logger.log(Level.INFO, "controller = " + controller);
		model.setController(controller);
		controller.initBoard(); //on initialise l'échiquier
	}
	
	public static void main(String[] args) throws IOException{	
		instance = new Main(); //execute la fonction Main() lors du démarrage de l'application
	}

}
