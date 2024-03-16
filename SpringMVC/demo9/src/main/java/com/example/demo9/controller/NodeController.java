package com.example.demo9.controller;

import com.example.demo9.entity.MyResponse;
import com.example.demo9.myConfig.MyAnnotate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/20 09:45:13
 */
@Slf4j
@RestController
public class NodeController {

    @MyAnnotate
    @GetMapping("node/{message}")
    public MyResponse<String> node(@PathVariable String message) {
        return MyResponse.success(message, null);
    }

}
