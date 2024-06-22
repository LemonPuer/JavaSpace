package com.atguigu.crowd.exception;

/**
 * description: 用户名已存在异常
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/05/25 10:14:16
 */
public class LoginAcctAlreadyInUseException extends RuntimeException{
    private static final long serialVersionUID = 5168910183389054631L;

    public LoginAcctAlreadyInUseException() {
        super();
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
