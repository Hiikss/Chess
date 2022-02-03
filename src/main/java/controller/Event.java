package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Thomas
 *
 */
public class Event{
	
	private Controller controller;
	
	private MouseAdapter mouseAdapter;
	
	private final Logger logger =  LogManager.getLogger(this); //log4j
	
	public Event(Controller controller) {
		setController(controller);
		
		this.mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) { 
            	logger.log(Level.INFO, "test");
            }
        };
        controller.setListener(mouseAdapter);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
