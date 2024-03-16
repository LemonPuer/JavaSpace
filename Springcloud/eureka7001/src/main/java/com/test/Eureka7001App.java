package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 15:02:19
 */
@EnableEurekaServer
// 以下注解用于向使用consul或者zookeeper作为注册中心时注册服务
// @EnableDiscoveryClient
@SpringBootApplication
public class Eureka7001App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001App.class, args);
    }

}
