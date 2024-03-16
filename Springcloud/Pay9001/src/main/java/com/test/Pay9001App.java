package com.test;

import org.mybatis.spring.annotation.MapperScan;
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
@EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
@MapperScan("com.test.mapper")
public class Pay9001App {
    public static void main(String[] args) {
        SpringApplication.run(Pay9001App.class, args);
    }
}
