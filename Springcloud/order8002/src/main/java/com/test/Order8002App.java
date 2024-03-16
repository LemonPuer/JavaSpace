package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 15:02:19
 */
// @EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Order8002App {
    public static void main(String[] args) {
        SpringApplication.run(Order8002App.class, args);
    }
}
