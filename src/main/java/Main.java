
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;
import model.Model;
import view.Display;
import view.Swing;
import view.Swingtest;

public class Main {
	
	private static int vue = 0;
	
	public static Main instance;
	
	private final Logger logger =  LogManager.getLogger(this);
	
	public Main() throws IOException {
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		
		//Init init = new Init();
		Display view = null;
		Model model = new Model();

		switch(vue) {
		case 0: //cas où la vue est en swing
			view = new Display(new Swing());
			view.setDisplay(view);
			break;
		case 1:
			view = new Display(new Swingtest());
			view.setDisplay(view);
			break;
		}
		
		view.executeStrategy(boardImage);
		Controller controller = new Controller(model, view);
		logger.log(Level.INFO, "controller = "+controller);
		model.setController(controller);
		controller.initBoard();
	}
	
	public static void main(String[] args) throws IOException{	
		instance = new Main();
	}

}
