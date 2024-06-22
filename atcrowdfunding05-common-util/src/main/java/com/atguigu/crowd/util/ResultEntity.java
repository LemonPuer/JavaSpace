package com.atguigu.crowd.util;

import java.io.Serializable;

/**
 * 统一整个项目中Ajax请求返回的结果（未来也可以用于分布式架构各个模块间调用时返回统一类型）
 *
 * @author Lemon
 * @create 2023-02-17-14:32
 */
public class ResultEntity<T> implements Serializable {
    public static String SUCCESS = "SUCCESS";
    public static String FAILED = "FAILED";
    private String result;
    private String message;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static <Type> ResultEntity<Type> successWithoutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }

    /**
     * jackson有个离谱的bug，当属性没有get、set方法时会报错：No converter found for return value of type
     *
     * @return
     */
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
