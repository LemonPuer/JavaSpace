package com.test.controller;

import com.test.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/16 11:08:52
 */
@RestController
public class MqController {
    @Autowired
    private MqService mqService;

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        return mqService.sendMessage(message);
    }
}
