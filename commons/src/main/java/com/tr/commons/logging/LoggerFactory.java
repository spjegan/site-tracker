package com.tr.commons.logging;

import org.slf4j.Logger;

/**
 * Created by Jegan on 6/18/2015.
 */
public class LoggerFactory {

	public static ILogger getLogger(Class clazz) {
		Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
		return new SimpleLogger(logger);
	}
}
