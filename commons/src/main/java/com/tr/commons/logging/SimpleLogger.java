package com.tr.commons.logging;

import org.slf4j.Logger;

/**
 * Created by Jegan on 6/18/2015.
 */
public class SimpleLogger implements ILogger {
	
    private Logger logger;

    public SimpleLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    @Override
    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    @Override
    public void error(String error, Object... args) {
        logger.error(error, args);
    }

    @Override
    public void error(String error, Throwable th, Object... args) {
        logger.error(error, th, args);
    }

}
