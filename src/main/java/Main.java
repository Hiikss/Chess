
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Controller;
import log4j2.Log4j;
import model.Init;
import model.Model;
import view.Display;
import view.Swing;
import view.Swingtest;

public class Main {
	
	private static int vue = 0;
	
	public static Main instance;
	
	private Log4j log = new Log4j();
	
	public Main() throws IOException {
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		
		//Init init = new Init();
		Display view = null;
		Model model = new Model();
		
		switch(vue) {
		case 0: //cas où la vue est en swing
			view = new Display(new Swing());
			break;
		case 1:
			view = new Display(new Swingtest());
			break;
		}
		view.executeStrategy(boardImage);
		Controller controller = new Controller(model, view);
	}
	
	public static void main(String[] args) throws IOException{	
		instance = new Main();
	}

}
