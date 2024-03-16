package com.test.controller;

import com.test.service.OrderService;
import com.test.service.PayService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/16 17:47:27
 */
@Slf4j
@RestController
public class ConsumerController {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/pay")
    private String pay() {
        log.info("=======Feign进行远程调用=======");
        return payService.pay();
    }

    @GetMapping("/consumer/dbPay/{userId}")
    @GlobalTransactional(name = "dbPay", rollbackFor = Exception.class)
    public String payDb(@PathVariable("userId") Long userId) {
        Long l = orderService.dbOrder(userId);
        String s = payService.payByDb(userId);
        if ("fail".equals(s)) {
            throw new RuntimeException("payService调用失败！");
        }
        orderService.dbOrderFinish(l);
        return "success";
    }
}
