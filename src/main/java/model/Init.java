package model;

import log4j2.Log4j;

public class Init {

	Log4j log = new Log4j();
	
	public int initBoard() {
		log.logInfo("Échiquier initialisé");
		return 1;
	}
	
}
