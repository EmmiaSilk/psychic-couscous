package com.emmiasilk.urealms.core.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

    private final static Logger LOGGER = LogManager.getLogger(Logging.class);

    static {

    }

    public static void logTrace(String message) {
        LOGGER.trace(message);
    }

    public static void logDebug(String message) {
        LOGGER.debug(message);
    }

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logWarn(String message) {
        LOGGER.warn(message);
    }

    public static void logError(String message) {
        LOGGER.error(message);
    }

    public static void logError(String message, Exception exception) {
        LOGGER.error(message, exception);
    }

    public static void logFatal(String message) {
        LOGGER.fatal(message);
    }

    public static void logFatal(String message, Exception exception) {
        LOGGER.fatal(message, exception);
    }

}