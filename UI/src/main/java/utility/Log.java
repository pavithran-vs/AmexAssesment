package utility;

import org.apache.log4j.Logger;

//logger class
public class Log {
	public static final Logger logger = Logger.getLogger(Log.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}
