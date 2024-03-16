package com.example.demo9.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 09:49:13
 */
@Data
@Accessors(chain = true)
public class MyResponse<T> {
    private T body;
    private Integer code;
    private String message;

    public static <T> MyResponse<T> success(@Nullable T data, @Nullable String message) {
        return new MyResponse<T>().setBody(data).setCode(200).setMessage(message);
    }

    public static <T> MyResponse<T> failed(@Nullable T data, @NotNull String message) {
        return new MyResponse<T>().setBody(data).setCode(500).setMessage(message);
    }
}
