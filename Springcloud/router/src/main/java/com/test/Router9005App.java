package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/03 11:05:28
 */
@EnableEurekaClient
@SpringBootApplication
public class Router9005App {
    public static void main(String[] args) {
        SpringApplication.run(Router9005App.class, args);
    }
}
