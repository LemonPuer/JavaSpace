package com.test.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/02/24 12:07:38
 */
public class TestBlockHandler {
    public static String handlerException(BlockException exception) {
        return "自定义的限流处理信息......TestBlockHandler.handlerException";
    }
}
