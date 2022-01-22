
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Init;
import view.Display;
import view.Swing;
import view.Swingtest;

public class Main {
	
	private static int vue = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		
		Init init = new Init();
		Display view;
		
		switch(vue) {
		case 0: //cas où la vue est en swing
			view = new Display(new Swing());
			view.executeStrategy(boardImage);
			break;
		case 1:
			view = new Display(new Swingtest());
			view.executeStrategy(boardImage);
			break;
		}
		
		
		init.initBoard();
		//Controller controller = new Controller(init, view);
	}
	

}
