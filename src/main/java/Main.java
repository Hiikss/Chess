import view.Display;
import view.Swing;

public class Main {
	
	
	public static void main(String[] args) {
		Display view = new Display(new Swing());
		view.executeStrategy();
	}

}
