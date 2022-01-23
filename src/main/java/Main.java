
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import log4j2.Log4j;
import model.Init;
import view.Display;
import view.Swing;
import view.Swingtest;

public class Main {
	
	private static int vue = 0;
	
	public static Main instance;
	
	private Display view;
	
	private Log4j log = new Log4j();
	
	public Main() throws IOException {
		BufferedImage boardImage = ImageIO.read(Main.class.getResource("/chessboardblue.png")); //chemin de l'image de l'échiquier
		
		Init init = new Init();
		
		switch(vue) {
		case 0: //cas où la vue est en swing
			setDisplay(new Display(new Swing()));
			view.executeStrategy(boardImage);
			break;
		case 1:
			setDisplay(new Display(new Swingtest()));
			view.executeStrategy(boardImage);
			break;
		}
		
		init.initBoard();
		log.logInfo(""+getDisplay());
		//Controller controller = new Controller(init, view);
	}
	
	public static void main(String[] args) throws IOException{	
		instance = new Main();
	}
	
	public Display getDisplay() {
		return view;
	}
	
	public void setDisplay(Display view) {
		this.view = view;
	}

}
