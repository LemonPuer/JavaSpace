package com.SpringBoot.controller;

import com.SpringBoot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/22 18:01:11
 */
@RestController
public class TestController {
    @Autowired
    private Person person;

    @RequestMapping("/test1")
    public void test1() {
        System.out.println(person);
    }
}
