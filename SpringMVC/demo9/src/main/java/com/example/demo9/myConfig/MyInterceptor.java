package com.example.demo9.myConfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/20 10:39:59
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        MyAnnotate myAnnotate = ((HandlerMethod) handler).getMethodAnnotation(MyAnnotate.class);
        if (Objects.isNull(myAnnotate)) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        insertMessage(request, (HandlerMethod) handler);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 记录（打印）日志
     */
    public void insertMessage(HttpServletRequest request, HandlerMethod handlerMethod) throws Exception {
        log.info("方法名为：{}", handlerMethod.getClass().getName() + "." + handlerMethod.getMethod().getName());
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // apache 代理添加的请求头
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // weblogic 代理添加的请求头
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // 某些代理服务器的请求头
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // 某些代理服务器的请求头
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inet = InetAddress.getLocalHost();
                ip = inet.getHostAddress();
            }
        }
        if (ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        log.info("用户ip：{}", ip);
    }
}
