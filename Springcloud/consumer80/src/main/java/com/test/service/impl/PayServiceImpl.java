package com.test.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.service.PayService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/01 20:21:05
 */
@Component
public class PayServiceImpl implements PayService {
    @Override
    public String pay() {
        return "FallbackFactory.pay()";
    }

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String payTimeOut() {
        return "FallbackFactory.payTimeOut()";
    }
}
