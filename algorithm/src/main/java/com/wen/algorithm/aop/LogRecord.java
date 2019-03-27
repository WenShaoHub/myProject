package com.wen.algorithm.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogRecord {

    @After(value ="within(com.wen.algorithm.aop.AopController.*))" )
    public void aopDemoMethod(){
        System.out.println("=========after========");
    }
}
