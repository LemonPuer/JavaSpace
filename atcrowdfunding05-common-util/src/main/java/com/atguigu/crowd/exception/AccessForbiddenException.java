package com.atguigu.crowd.exception;

/**
 * 用户没有登录就访问受保护资源的异常
 * @author Lemon
 * @create 2023-02-19-10:20
 */
public class AccessForbiddenException extends RuntimeException{
    private static final long serialVersionUID = 5162710183389054632L;
    public AccessForbiddenException(){
        super();
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    protected AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
