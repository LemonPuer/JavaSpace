package com.test.controller;

import com.test.entity.Order;
import com.test.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/27 16:34:00
 */
@Slf4j
@RestController
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private OrderMapper orderMapper;


    @GetMapping("/order")
    public String oder() {
        return "下订单:" + port;
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("dbOrder/{userId}")
    public Long dbOrder(@PathVariable("userId") Long userId) {
        Order order = Order.builder().userId(userId).money(new BigDecimal(100)).count(1).productId(1L).status(0).build();
        orderMapper.insert(order);
        return order.getId();
    }

    @GetMapping("dbOrderFinish/{id}")
    public String dbOrderFinish(@PathVariable("id") Long id) {
        orderMapper.updateById(Order.builder().id(id).status(1).build());
        return "success";
    }
}
