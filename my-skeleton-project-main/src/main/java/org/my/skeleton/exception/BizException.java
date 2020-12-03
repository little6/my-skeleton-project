package org.my.skeleton.exception;

/**
 * 业务异常
 */
public class BizException extends Exception{
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
