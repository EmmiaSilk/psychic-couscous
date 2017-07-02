package com.emmiasilk.urealms.api.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Wrapper class for out Log4J logger
 *
 * @since 0.0.1
 */
public class Logging {

    /**
     * Instance of the logger
     */
    private final static Logger LOGGER = LogManager.getLogger(Logging.class);

    /**
     * Log a Trace level message
     *
     * @param message the message to log
     */
    public static void logTrace(String message) {
        LOGGER.trace(message);
    }

    /**
     * Log a Debug level message
     *
     * @param message the message to log
     */
    public static void logDebug(String message) {
        LOGGER.debug(message);
    }

    /**
     * Log an Info level message
     *
     * @param message the message to log
     */
    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    /**
     * Log a Warning level message
     *
     * @param message the message to log
     */
    public static void logWarn(String message) {
        LOGGER.warn(message);
    }

    /**
     * Log an Error level message
     *
     * @param message the message to log
     */
    public static void logError(String message) {
        LOGGER.error(message);
    }

    /**
     * Log an Error level message
     *
     * @param message   the message to log
     * @param throwable the throwable that caused the error
     */
    public static void logError(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    /**
     * Log a Fatal level message
     *
     * @param message the message to log
     */
    public static void logFatal(String message) {
        LOGGER.fatal(message);
    }

    /**
     * Log a Fatal level message
     *
     * @param message   the message to log
     * @param throwable the throwable that caused the error
     */
    public static void logFatal(String message, Throwable throwable) {
        LOGGER.fatal(message, throwable);
    }

    /**
     * A method that gets the instance of the Logger in case you are a heathen
     * and the above methods aren't good enough for you.
     *
     * @return The instance of the logger
     */
    public static Logger getLogger() {
        return LOGGER;
    }

}