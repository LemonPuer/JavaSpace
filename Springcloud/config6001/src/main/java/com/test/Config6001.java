package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/15 13:15:16
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class Config6001 {
    public static void main(String[] args) {
        SpringApplication.run(Config6001.class, args);
    }
}
