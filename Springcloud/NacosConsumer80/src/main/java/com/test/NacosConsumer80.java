package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/16 16:36:50
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer80.class, args);
    }
}
