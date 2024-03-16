package com.example.demo9.myConfig;

import cn.hutool.core.date.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/20 10:03:41
 */
@Aspect
@Component
public class EnhanceMyNode {

    @Around("@annotation(myAnnotate)")
    public Object addMessage(ProceedingJoinPoint joinPoint, MyAnnotate myAnnotate) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("获取原始参数");
        Object[] args = joinPoint.getArgs();
        stopWatch.stop();
        System.out.println("原始参数：" + Arrays.stream(args).map(Object::toString).collect(Collectors.joining(",")));
        args = new Object[]{"hello!"};
        stopWatch.start("运行方法");
        Object result = joinPoint.proceed(args);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return result;
    }

}
