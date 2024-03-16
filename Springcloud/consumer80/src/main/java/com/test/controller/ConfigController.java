package com.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/03 18:40:54
 */
@RefreshScope
@RestController
public class ConfigController {
    @Value("${testName}")
    private String testName;

    @Value("${today.mood}")
    private String mood;

    @GetMapping("name")
    public String name() {
        return testName;
    }

    @GetMapping("mood")
    public String mood() {
        return "今天的心情是：" + mood;
    }

}
