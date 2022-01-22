
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.Display;
import view.Swing;

public class Main {
	
	private static int vue = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		switch(vue) {
		case 0:
			Display view = new Display(new Swing());
			view.executeStrategy(boardImage);
			break;
		}
		
		
	}

}
