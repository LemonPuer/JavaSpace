package com.atguigu.crowd.exception;

/**
 * 登录失败异常
 * @author Lemon
 * @create 2023-02-17-12:13
 */
public class LoginFailedException extends RuntimeException {
    private static final long serialVersionUID = 5162710183389054631L;
    public LoginFailedException(){
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
