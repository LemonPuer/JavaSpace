package com.test.service;

import com.test.service.impl.PayServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/28 20:56:29
 */
@Component
@FeignClient(value = "PAY-SERVICE",fallback = PayServiceImpl.class)
public interface PayService {
    @GetMapping("pay")
    String pay();

    @GetMapping("pay/timeout")
    String payTimeOut();
}