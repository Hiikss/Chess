package log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	private static final Logger logger =  LogManager.getLogger(Log4j.class);

	
	public static void logInfo(String info) {
	
	logger.log( Level.INFO, info );
	
	}

}