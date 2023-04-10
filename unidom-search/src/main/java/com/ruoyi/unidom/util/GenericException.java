package com.ruoyi.unidom.util;

public class GenericException extends RuntimeException {
    public GenericException() {
    }

    public GenericException(final String msg) {
        super(msg);
    }

    public GenericException(final Throwable cause) {
        super(cause);
    }

    public GenericException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}