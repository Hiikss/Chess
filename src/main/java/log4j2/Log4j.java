package log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	private final Logger logger =  LogManager.getLogger(Log4j.class);
	private String log;
	
	public String getLog() {
		return log;
	}
	
	public void logInfo(String log) {
		this.log = log;
		logger.log( Level.INFO, log );
	}

}