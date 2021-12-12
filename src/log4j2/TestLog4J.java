package log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4J {

    // Récupération de notre logger.
	private static final Logger logger =  LogManager.getLogger(TestLog4J.class);

    // Le point d'entrée du programme.
	  public static void main(String[] args) {
		
		  // On produit un log de niveau informatif.
	        logger.log( Level.INFO, "Hello World with Log4J 2" );

	        // On produit un log de niveau erreur.
	        logger.log( Level.ERROR, "Houston, we have a problem" );
		  }
}
