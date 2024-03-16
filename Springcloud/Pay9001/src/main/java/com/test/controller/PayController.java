package com.test.controller;

import com.test.entity.Account;
import com.test.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 16:46:29
 */
@Slf4j
@RestController
public class PayController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("pay")
    public String pay() {
        log.info("调用成功！");
        return "进行支付: " + port;
    }

    @GetMapping("pay/timeout")
    public String payTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "进行支付: " + port;
    }

    @GetMapping("dbPay/{userId}")
    public String payByDb(@PathVariable("userId") Long userId) {
        accountMapper.updateAccount(userId, 100);
        int i = 10 / 0;
        return "进行支付: " + port;
    }

    @GetMapping("account/{id}")
    public Account getAccount(@PathVariable("id") Long id) {
        return accountMapper.selectById(id);
    }
}
