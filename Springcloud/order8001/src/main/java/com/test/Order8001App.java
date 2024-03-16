package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 15:02:19
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Order8001App {
    public static void main(String[] args) {
        SpringApplication.run(Order8001App.class, args);
    }

    @Bean
    public Consumer<String> getMessage() {
        return message -> {
            System.out.println("Received message: " + message);
            // 处理消息的逻辑
        };
    }
}
