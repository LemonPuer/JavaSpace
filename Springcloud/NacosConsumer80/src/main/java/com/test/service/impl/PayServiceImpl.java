package com.test.service.impl;

import com.test.service.PayService;
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
        return "PayServiceImpl.pay()";
    }

    @Override
    // @HystrixCommand(commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    // })
    public String payTimeOut() {
        return "PayServiceImpl.payTimeOut()";
    }

    @Override
    public String payByDb(Long userId) {
        return "fail";
    }
}
