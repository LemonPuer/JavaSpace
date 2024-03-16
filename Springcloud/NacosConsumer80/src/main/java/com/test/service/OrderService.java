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
 * @date 2024/02/24 21:09:43
 */
@Component
@FeignClient(value = "order-service")
public interface OrderService {
    @GetMapping("dbOrder/{userId}")
    public Long dbOrder(@PathVariable("userId") Long userId);

    @GetMapping("dbOrderFinish/{id}")
    public String dbOrderFinish(@PathVariable("id") Long id);
}
