package control;

import java.io.Serializable;
import java.util.logging.Logger;

public class GameSaveLoad implements Serializable{
	Controller savedController;
	Iterator savedIterator;
	
	/**
     * This version number helps make sure everything is sync'd if
     * we start changing object content
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The logger for this class
     */
    private static Logger myLogger = Logger.getLogger("MULEGame.Silver");
}
