package com.tr.commons.logging;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface ILogger {
	
    void debug(String message, Object... args);

    void info(String message, Object... args);

    void warn(String message, Object... args);

    void error(String error, Object... args);

    void error(String error, Throwable th, Object... args);

}
