package com.test.service.impl;

import com.test.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/16 11:09:44
 */
@Service
public class MqServiceImpl implements MqService {

    @Autowired
    private StreamBridge streamBridge;

    @Override
    public String sendMessage(String message) {
        boolean send = streamBridge.send("test-output", message);
        return send ? "发送成功" : "发送失败";
    }
}
