package com.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
        return "testName：" + testName;
    }

    @GetMapping("mood")
    public String mood() {
        return "今天的心情是：" + mood;
    }

    @GetMapping("test")
    @SentinelResource(value = "testHotKey", blockHandler = "myBlockHandler")
    public String test(String p1, String p2) {
        if (p1.equals("name") && p2.equals("mood")) {
            return testName + "," + mood;
        } else if (p1.equals("name")) {
            return testName + "," + p2;
        } else if (p2.equals("mood")) {
            return p1 + "," + mood;
        }
        return "p1:" + p1 + " p2:" + p2;
    }

    public String myBlockHandler(String p1, String p2, BlockException exception) {
        return "服务降级：myBlockHandler:" + p1 + "," + p2;
    }

    @GetMapping("testHandler")
    @SentinelResource(value = "testHandler", blockHandlerClass = {TestBlockHandler.class}, blockHandler = "handlerException")
    public String testHandler() {
        return "用户：" + testName + "<br/>" + "今天的心情是：" + mood;
    }
}
