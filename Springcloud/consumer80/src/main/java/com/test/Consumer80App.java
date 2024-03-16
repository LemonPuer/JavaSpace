package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/28 10:53:05
 */
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Consumer80App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80App.class, args);
    }
}
