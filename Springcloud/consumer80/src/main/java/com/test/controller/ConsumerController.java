package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/28 10:55:34
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PayService payService;

    private String order = "http://ORDER-SERVICE";

    @GetMapping("/consumer/order")
    private String order() {
        log.info("=======进行远程调用=======");
        return restTemplate.getForObject(order + "/order", String.class);
    }

    @GetMapping("/consumer/pay")
    private String pay() {
        log.info("=======Feign进行远程调用=======");
        return payService.pay();
    }

    @GetMapping("/consumer/pay/timeout")
    private String payTimeOut() {
        log.info("=======Feign进行远程调用=======");
        return payService.payTimeOut();
    }

    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
