package com.tr.commons.utils;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;

import java.util.Collection;

/**
 * Created by Jegan on 6/18/2015.
 */
public class AssertUtils {

    private static final ILogger logger = LoggerFactory.getLogger(AssertUtils.class);

    public static void assertNotNull(Object object, String errorMessage, Object... args) {
        if (null == object) {
            logger.error(errorMessage, args);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void assertNotNullOrEmpty(Collection<?> collection, String errorMessage, Object... args) {
        assertNotNull(collection, errorMessage);
        if (collection.isEmpty()) {
            logger.error(errorMessage, args);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void assertNotNullOrEmpty(String string, String errorMessage, Object... args) {
        assertNotNull(string, errorMessage);
        if(string.trim().isEmpty()) {
            logger.error(errorMessage, args);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
