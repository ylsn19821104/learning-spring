package com.hongxp.demo.dubbo.provider.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class ApiLogger {

    public static final Logger DEBUG = LoggerFactory.getLogger("dubbo");
    public static final Logger INFO = LoggerFactory.getLogger("info");
    public static final Logger ERROR = LoggerFactory.getLogger("error");
    public static final Logger REQUEST = LoggerFactory.getLogger("access");
    public static final Logger DB_INFO = LoggerFactory.getLogger("sql");
    public static final Logger THIRD_INFO = LoggerFactory.getLogger("third");
    public static final Logger WARN = LoggerFactory.getLogger("warn");

    public static void debug(String message) {
        DEBUG.debug(message);
    }

    public static void debug(String message, Object... object) {
        DEBUG.debug(message, object);
    }

    public static void info(String message, Object... object) {
        INFO.info(message, object);
    }

    public static void info(String message) {
        INFO.info(message);
    }

    public static void error(String message) {
        ERROR.error(message);
    }

    public static void error(String message, Throwable throwable) {
        ERROR.error(message, throwable);
    }

    public static void error(String message, Object... object) {
        ERROR.error(message, object);
    }

    public static void dbInfo(String message) {
        DB_INFO.info(message);
    }

    public static void dbInfo(String message, Object... object) {
        DB_INFO.info(message, object);
    }

    public static void requset(String message) {
        REQUEST.info(message);
    }

    public static void requset(String message, Object... object) {
        REQUEST.info(message, object);
    }

    public static void thirdInfo(String message) {
        THIRD_INFO.info(message);
    }

    public static void thirdInfo(String message, Object... object) {
        THIRD_INFO.info(message, object);
    }


    public static void warn(String message) {
        WARN.warn(message);
    }

    public static void warn(String message, Object... object) {
        WARN.warn(message, object);
    }


}
