package com.example.demo9.myConfig;

import java.lang.annotation.*;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/20 09:50:40
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotate {
    String value() default "info";
}
