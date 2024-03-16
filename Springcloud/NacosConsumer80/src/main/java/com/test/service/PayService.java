package com.test.service;

import com.test.service.impl.PayServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/28 20:56:29
 */
@Component
@FeignClient(value = "pay-service", fallback = PayServiceImpl.class)
public interface PayService {
    @GetMapping("pay")
    String pay();

    @GetMapping("pay/timeout")
    String payTimeOut();

    @GetMapping("dbPay/{userId}")
    public String payByDb(@PathVariable("userId") Long userId);
}